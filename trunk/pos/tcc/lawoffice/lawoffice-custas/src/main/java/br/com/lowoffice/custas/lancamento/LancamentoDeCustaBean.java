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

import br.com.lawoffice.caixa.CaixaServiceLocal;
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
	private CaixaServiceLocal caixaService;
	
	
	
	/**
	 * Persisti os lançamentos 
	 */
	@PersistenceContext(unitName="lawoffice-custas")
	private EntityManager entityManager;
	
	
	
	/**
	 *	Mapa com os laçamento  
	 */
	private Map<Map<Long, Long>, Lancamento> mapsLacamentos = new HashMap<Map<Long,Long>, Lancamento>();
	
	
	
	
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
		
		for (Lancamento lancamento : lancamentos){
			
			entityManager.persist(lancamento);
			
			
			caixaService.creditar(
				lancamento.getColaborador().getConta(), 
				lancamento.getTotal()
			);
			
			caixaService.debitar(
				lancamento.getCliente().getConta(),
				lancamento.getTotal()
			);
								
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
		Map<Long, Long> chave = getChave(cliente, colaborador);
		
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
	

	private Map<Long, Long> getChave(Cliente cliente, Colaborador colaborador) {
		Map<Long, Long> chave = new HashMap<Long, Long>(); 
		chave.put(cliente.getId(), colaborador.getId());
		return chave;
	}



	private void validarCusta(Custa custa) {
		if(custa == null)
			throw new IllegalArgumentException("Custa está nula");
		if(custa.getLancamento() == null)
			throw new IllegalArgumentException("Custa não está associada a um lancamento");
	}	



	public void setCaixa(CaixaServiceLocal caixaService) {
		this.caixaService = caixaService;
	}

	

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
}
