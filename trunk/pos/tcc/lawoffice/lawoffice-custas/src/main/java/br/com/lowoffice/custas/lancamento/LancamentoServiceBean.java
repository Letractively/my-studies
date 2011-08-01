/**
 * 
 */
package br.com.lowoffice.custas.lancamento;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;

import br.com.lawoffice.caixa.CaixaServiceLocal;
import br.com.lawoffice.dominio.Cliente;
import br.com.lawoffice.dominio.Colaborador;
import br.com.lawoffice.dominio.Custa;
import br.com.lawoffice.dominio.Lancamento;
import br.com.lawoffice.persistencia.PessoaDao;

/**
 *  TODO: javadoc 
 * 
 * @author robson
 *
 */
@Stateful
@Local(LancamentoServiceLocal.class)
@Remote(LancamentoServiceRemote.class)
public class LancamentoServiceBean implements LancamentoService {
	
	
	/**
	 * Caixa para fechamento do lançamento , debito para o cliente , credito para o colaborador
	 */
	@EJB
	private CaixaServiceLocal caixaService;
	

	@EJB
	private PessoaDao pessoaDao;
	
	
	/**
	 *	Mapa com os laçamento  
	 */
	private Map<Map<Long, Long>, Lancamento> mapsLacamentos = new HashMap<Map<Long,Long>, Lancamento>();
	
	
	
	
	// TODO: em termos da validação da custa e outros cara temos um debito técnico com beans validation
	// então vamos fechar a camada de persitência e realizar as validações 
	// falo isso pq o método abaixo está aceitando qualquer custa ou cliente ou colaborador
	// e não á testes de unidade para isso
	@Override
	public Custa adicionarCusta(Custa custa, Cliente cliente, Colaborador colaborador, Date date){
		validarParametros(custa,cliente,colaborador,date);
		
		cliente = 
				pessoaDao.localizar(Cliente.class, cliente);
		
		if(cliente == null)
			throw new IllegalArgumentException("Cliente na encontrado na base de dados");
		
		
		colaborador =
				pessoaDao.localizar(Colaborador.class, colaborador);
		
		
		if(colaborador == null)
			throw new IllegalArgumentException("Colaborador na encontrado na base de dados");
		
		
		return custa.addLancamento(
				getLacamento(
						cliente,
						colaborador
					).addCusta(custa)
			);
	}
	


	@Override
	public void fecharLacamento(){
		
/*		if(mapsLacamentos.isEmpty())
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
		
		mapsLacamentos.clear();*/
	}
	
	
	@Override
	public void removerCusta(Custa custa){
		validarCusta(custa);		
		getLancamento(custa).getCustas().remove(custa);
	}
	
	

/*	
 * TODO: se rolar um tempo add essa feature
 * 
 * 
 * @Override
	public Custa atualizarCusta(Custa custa, Pessoa cliente, Colaborador colaborador) throws LancamentoDeCustaException{
		validarCusta(custa);
		
		Lancamento lancamento = getLancamento(custa);
				
		Custa custaAtual = 
			lancamento.getCustas().get(lancamento.getCustas().indexOf(custa));
		
		custaAtual.setNatureza(custa.getNatureza());
		custaAtual.setValor(custa.getValor());
		
		return custaAtual;
	}*/



	/**
	 * Retorna o Lançamento da custa que está na sessão do bean
	 * 
	 * @param custa
	 * @return
	 * @throws LancamentoDeCustaException
	 */
	private Lancamento getLancamento(Custa custa){
		Lancamento lancamento = null; 
/*			mapsLacamentos.get(
					getChave(
						custa.getLancamento().getCliente(),
						custa.getLancamento().getColaborador()
					)
				);*/
		
/*		if(lancamento  == null)
			throw new LancamentoDeCustaException("O Lançamento da custa não está na sessão do Bean");*/
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
		
/*		// TODO: guava ??
		Map<Long, Long> chave = getChave(cliente, colaborador);
		
		if( !mapsLacamentos.containsKey(chave))
			mapsLacamentos.put(
					chave, 
					new Lancamento()
						.adicionarCliente(cliente)
						.adicionarColaborador(colaborador)
						.adicionarDataLancamento()
				);
		
		return mapsLacamentos.get(chave);*/
		
		
		return new Lancamento();
	}
	

	private Map<Long, Long> getChave(Cliente cliente, Colaborador colaborador) {
		Map<Long, Long> chave = new HashMap<Long, Long>(); 
		chave.put(cliente.getId(), colaborador.getId());
		return chave;
	}

	
	
	
	private void validarParametros(Custa custa, Cliente cliente, Colaborador colaborador, Date date) {
		if(custa == null)
			throw new IllegalArgumentException("Custa está nula");
		if(cliente == null || cliente.getId() == null)
			throw new IllegalArgumentException("Cliente está nulo ou id cliente nulo");
		if(colaborador == null || colaborador.getId() == null)
			throw new IllegalArgumentException("Colaborador está nulo ou id colaborador nulo");
		if(date == null)
			throw new IllegalArgumentException("Data está nula");
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



	public void setPessoaDao(PessoaDao pessoaDao) {
		this.pessoaDao = pessoaDao;
	}
}
