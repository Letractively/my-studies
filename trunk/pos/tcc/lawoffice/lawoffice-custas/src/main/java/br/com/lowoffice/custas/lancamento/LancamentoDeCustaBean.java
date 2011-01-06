/**
 * 
 */
package br.com.lowoffice.custas.lancamento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.lawoffice.caixa.CaixaLocal;
import br.com.lawoffice.dominio.Cliente;
import br.com.lawoffice.dominio.Colaborador;
import br.com.lawoffice.dominio.Custa;
import br.com.lawoffice.dominio.Lancamento;
import br.com.lowoffice.custas.exception.LacamentoDeCustaException;

/**
 *  TODO: javadoc 
 * 
 * @author robson
 *
 */
@Stateful
@Local(LancamentoDeCustaLocal.class)
@Remote(LancamentoDeCustaRemote.class)
public class LancamentoDeCustaBean implements LancamentoDeCusta {
	
	
	/**
	 * Caixa para fechamento do lançamento , debito para o cliente , credito para o colaborador
	 */
	@EJB()
	private CaixaLocal caixa;
	
	
	
	/**
	 * Persisti os lançamentos 
	 */
	@PersistenceContext(unitName="lawoffice-custas")
	private EntityManager entityManager;
	
	
	
	/**
	 *	Mapa com os laçamento  
	 */
	private Map<Map<Cliente, Colaborador>, Lancamento> mapsLacamentos = new HashMap<Map<Cliente,Colaborador>, Lancamento>();
	
	
	
	
	// TODO: em termos da validação da custa e outros cara temos um debito técnico com beans validation
	// então vamos fechar a camada de persitência e realizar as validações 
	// falo isso pq o método abaixo está aceitando qualquer custa ou cliente ou colaborador
	// e não á testes de unidade para isso
	@Override
	public Custa adicionarCusta(Custa custa, Cliente cliente, Colaborador colaborador){
		return custa.addLancamento(
				getLacamento(
						cliente,
						colaborador
					).addCusta(custa)
			);
	}
	
	

	private Lancamento getLacamento(Cliente cliente, Colaborador colaborador){
		
		// TODO: guava ??
		Map<Cliente, Colaborador> chave = new HashMap<Cliente, Colaborador>(); 
		chave.put(cliente, colaborador);
		

		if( !mapsLacamentos.containsKey(chave))
			mapsLacamentos.put(
					chave, 
					new Lancamento()
						.adicionarCliente(cliente)
						.adicionarColaborador(colaborador)
						.adicionarDataLancamento()
				);
		
		return mapsLacamentos.get(chave);
	}



	@Override
	public void fecharLacamento()throws LacamentoDeCustaException{
		
		if(mapsLacamentos.isEmpty())
			throw new LacamentoDeCustaException("Não há lançamento(s) para fechar");
		
		List<Lancamento> lancamentos =  new ArrayList<Lancamento>(mapsLacamentos.values());
		
		for (Lancamento lancamento : lancamentos) {
			
			entityManager.persist(lancamento);
			
			caixa.creditar(
				lancamento.getColaborador().getConta(), 
				lancamento.getTotal()
			);
			
			caixa.debitar(
				lancamento.getCliente().getConta(), 
				lancamento.getTotal()
			);
		}
		
		mapsLacamentos.clear();
	}



	public void setCaixa(CaixaLocal caixa) {
		this.caixa = caixa;
	}


	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
}
