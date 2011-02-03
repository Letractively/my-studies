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
import br.com.lawoffice.caixa.exception.CaixaException;
import br.com.lawoffice.dominio.Cliente;
import br.com.lawoffice.dominio.Colaborador;
import br.com.lawoffice.dominio.Custa;
import br.com.lawoffice.dominio.Lancamento;
import br.com.lawoffice.dominio.Pessoa;
import br.com.lowoffice.custas.exception.LancamentoDeCustaException;

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
	

	@Override
	public void fecharLacamento()throws LancamentoDeCustaException{
		
		if(mapsLacamentos.isEmpty())
			throw new LancamentoDeCustaException("Não há lançamento(s) para fechar");
		
		List<Lancamento> lancamentos =  new ArrayList<Lancamento>(mapsLacamentos.values());
		
		for (Lancamento lancamento : lancamentos) {
			
			entityManager.persist(lancamento);
			
			try {
					caixa.creditar(
						lancamento.getColaborador().getConta(), 
						lancamento.getTotal()
					);
					
					caixa.debitar(
						lancamento.getCliente().getConta(),
						lancamento.getTotal()
					);
					
			} catch (CaixaException e) {
				new LancamentoDeCustaException(e);
			}
		}
		
		mapsLacamentos.clear();
	}
	
	
	
	@Override
	public void removerCusta(Custa custa) throws LancamentoDeCustaException{
		validarCusta(custa);		
		getLancamento(custa).getCustas().remove(custa);
	}
	
	

	@Override
	public Custa atualizarCusta(Custa custa, Pessoa cliente, Colaborador colaborador) throws LancamentoDeCustaException{
		validarCusta(custa);
		
		Lancamento lancamento = getLancamento(custa);
				
		Custa custaAtual = 
			lancamento.getCustas().get(lancamento.getCustas().indexOf(custa));
		
		custaAtual.setNatureza(custa.getNatureza());
		custaAtual.setValor(custa.getValor());
		
		return custaAtual;
	}



	/**
	 * Retorna o Lançamento da custa que está na sessão do bean
	 * 
	 * @param custa
	 * @return
	 * @throws LancamentoDeCustaException
	 */
	private Lancamento getLancamento(Custa custa)throws LancamentoDeCustaException {
		Lancamento lancamento = 
			mapsLacamentos.get(
					getChave(
						custa.getLancamento().getCliente(), 
						custa.getLancamento().getColaborador()
					)
				);
		
		if(lancamento  == null)
			throw new LancamentoDeCustaException("O Lançamento da custa não está na sessão do Bean");
		return lancamento;
	}
	
	
	/**
	 * Retorna o Lançamento para a combinaçao de {@link Cliente} e {@link Colaborador} que está na sessão do bean
	 * 
	 * 
	 * @param cliente
	 * @param colaborador
	 * @return
	 */
	private Lancamento getLacamento(Cliente cliente, Colaborador colaborador){
		
		// TODO: guava ??
		Map<Cliente, Colaborador> chave = getChave(cliente, colaborador);
		
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
	

	private Map<Cliente, Colaborador> getChave(Cliente cliente, Colaborador colaborador) {
		Map<Cliente, Colaborador> chave = new HashMap<Cliente, Colaborador>(); 
		chave.put(cliente, colaborador);
		return chave;
	}



	private void validarCusta(Custa custa) {
		if(custa == null)
			throw new IllegalArgumentException("Custa está nula");
		if(custa.getLancamento() == null)
			throw new IllegalArgumentException("Custa não está associada a um lancamento");
	}	



	public void setCaixa(CaixaLocal caixa) {
		this.caixa = caixa;
	}


	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
}
