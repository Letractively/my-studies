/**
 * 
 */
package br.com.lowoffice.caixa.extrato;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;

import br.com.lawoffice.dominio.Cliente;
import br.com.lawoffice.dominio.Colaborador;
import br.com.lawoffice.dominio.Conta;
import br.com.lawoffice.dominio.HistoricoConta;
import br.com.lawoffice.dominio.Pessoa;
import br.com.lawoffice.persistencia.ClienteDao;
import br.com.lawoffice.persistencia.ColaboradorDao;
import br.com.lawoffice.persistencia.HistoricoContaDao;

/**
 * 
 * Implementação para o serviço de Extrato
 * 
 * 
 * @author robson
 * @see ExtratoService
 *
 */
@Stateful
@Local(ExtratoServiceLocal.class)
@Remote(ExtratoServiceRemote.class)
public class ExtratoServiceBean implements ExtratoService{


	@EJB
	private ColaboradorDao colaboradorDao;
	
	
	@EJB
	private ClienteDao clienteDao;
	
	
	@EJB
	private HistoricoContaDao historicoContaDao;


	@Override
	public ExtratoDTO getExtratoColaborador(Date dataInicial, Date dataFinal,
			Colaborador colaborador) {
		validarParametros(dataInicial, dataFinal, colaborador);
		
		colaborador = 
				colaboradorDao.localizar(Colaborador.class, colaborador);
		
		if(colaborador == null)
			return null;
		
		
		ExtratoDTO extratoDTO =
				createExtratoDTO(
					dataInicial, 
					dataFinal, 
					colaborador,
					colaborador.getConta()
				);

		
		addItemExtrato(
			extratoDTO,
			dataInicial,
			dataFinal,
			colaborador.getConta()
		);
		
		// obter historico da conta no periodo
		// obter lancamentos ( custas ) no perido
		// criar lista de itens do historicos + custas .. 
		
		return extratoDTO;
	}




	private void addItemExtrato(ExtratoDTO extratoDTO, Date dataInicial,
			Date dataFinal, Conta conta) {
		
		
		List<HistoricoConta> historicosConta =
				historicoContaDao.getHistoricosConta(dataInicial, dataFinal, conta);
		
		
		for (HistoricoConta historicoConta : historicosConta) {				
			
		}
	}




	@Override
	public ExtratoDTO getExtratoCliente(Date dataInicial, Date dataFinal,
			Cliente cliente) {
		validarParametros(dataInicial, dataFinal, cliente);
		
		cliente =
				clienteDao.localizar(Cliente.class, cliente);
		
		if(cliente == null)
			return null;
				
		
		ExtratoDTO extratoDTO =
				createExtratoDTO(
						dataInicial, 
						dataFinal, 
						cliente,
						cliente.getConta()
					);
		

		
		return extratoDTO;
	}	
	
	

	
	
	/**
	 * Cria um {@link ExtratoDTO} 
	 * 
	 * @param dataInicial - da consulta.
	 * @param dataFinal - da consulta.
	 * @param pessoa - da consulta.
	 * @param conta - da pessoa da consulta.
	 * @return  {@link ExtratoDTO}
	 */
	private ExtratoDTO createExtratoDTO(Date dataInicial, Date dataFinal, Pessoa pessoa, Conta conta) {
		return new ExtratoDTO(
			pessoa.getNome(), 
			getSaldoAnterior(conta,dataInicial), 
			conta.getSaldo(),
			dataInicial, 
			dataFinal
		);
	}	
	


	
	
	
	
	/**
	 * Obtem o saldo anterior a data inicial de pesquisa para conta passada.
	 * 
	 * @param conta - a obter o saldo anterior.
	 * @param dataInicial - de consulta.
	 * @return - {@link BigDecimal} com saldo anterior
	 */
	private BigDecimal getSaldoAnterior(Conta conta, Date dataInicial) {
	
		// data anterior / - 1 dia
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dataInicial);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
	
		List<HistoricoConta> historicosConta =
				historicoContaDao.getHistoricosConta(calendar.getTime(), conta);
		
		if(historicosConta.isEmpty())
			return new BigDecimal(0.0);
		
		
		return historicosConta.get(historicosConta.size() -1).getSaloAnterior();
	}

	
	
	
	
	

	@Override
	public byte[] gerarExtrato(TipoExtrato tipoExtrato) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	private void validarParametros(Date dataInicial, Date dataFinal,Pessoa pessoa) {
		if(dataInicial == null)
			throw new IllegalArgumentException("Data inicial nula");
		if(dataFinal == null)
			throw new IllegalArgumentException("Data final nula");
		if(pessoa == null || pessoa.getId() == null)
			throw new IllegalArgumentException("Pessoa nula ou Pessoa sem ID"); 		
	}




	public void setColaboradorDao(ColaboradorDao colaboradorDao) {
		this.colaboradorDao = colaboradorDao;
	}



	public void setClienteDao(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}


	
	public void setHistoricoContaDao(HistoricoContaDao historicoContaDao) {
		this.historicoContaDao = historicoContaDao;
	}


	






















































	
	

	/*
	*//**
	 * Entity Manager para realizar as consultas na base de dados.
	 *//*
	@PersistenceContext(unitName="lawoffice-custas")
	EntityManager entityManager;
	
	
	*//**
	 * {@link List} de {@link Custa} com o resultado da pesquisa.
	 *//*
	private List<Custa> listaCustas ;
	
	
	@Override
	public List<Custa> getCustasPorDataCliente(Date dataInicial, Date dataFinal, Long idCliente){
		this.checarDataInicial(dataInicial) // TODO: refatorar a validacao conforme o bean de fluxo
			.checarDataFinal(dataFinal) // criar um metodo que da resolve tudo
			.checarIdCliente(idCliente);
	
		List<Lancamento> listaLancamentos = 
			getLancamentos(dataInicial,dataFinal,idCliente);
		
		listaCustas = new ArrayList<Custa>();
		
		for (Lancamento lancamento : listaLancamentos)
			listaCustas.addAll(lancamento.getCustas());
		
		return listaCustas;
	}


	@Override
	public BigDecimal getValorTotalPesquisa() {
		if(listaCustas == null || listaCustas.isEmpty())
			return new BigDecimal(0.0);
		
		BigDecimal valorTotal = new BigDecimal(0.0);
		
		for (Custa custa : listaCustas) 			
			valorTotal = valorTotal.add(custa.getValor());
				
		return valorTotal;
	}
	
	@Override
	public byte[] gerarExtrato(TipoExtrato tipoExtrato){
		if(listaCustas == null || listaCustas.isEmpty())
			throw new IllegalStateException("Não existe custas para gerar o extrato");
		
		ExtratoReport extratoReport = 
			SimpleFactoryExtratoReport.createExtratoReport(tipoExtrato);
		
		return extratoReport.gerarExtrato(listaCustas);
	}	
	
	
	private List<Lancamento> getLancamentos(Date dataInicial, Date dataFinal, Long idCliente) {
		CriteriaBuilder criteriaBuilder =
			entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Lancamento> criteriaQuery =
			criteriaBuilder.createQuery(Lancamento.class);
		
		Root<Lancamento> root =
			criteriaQuery.from(Lancamento.class);
		
		criteriaQuery
			.select(root)
			.where(
				criteriaBuilder.and(
					criteriaBuilder.between(root.get("dataLancamento").as(Date.class), dataInicial, dataFinal),
					criteriaBuilder.equal(root.get("cliente").get("id"), idCliente)
				)		
			);
		
		return entityManager
			.createQuery(criteriaQuery)
			.getResultList();
	}

	
	private ExtratoBean checarDataInicial(Date dataInicial) {
		if(dataInicial == null)
			throw new IllegalArgumentException("Data Inicial nula");
		return this;
	}
	
	private ExtratoBean checarDataFinal(Date dataFinal) {
		if(dataFinal == null)
			throw new IllegalArgumentException("Data Final nula");
		return this;		
	}
	
	private ExtratoBean checarIdCliente(Long idCliente){
		if(idCliente == null)
			throw new IllegalArgumentException("ID cliente nulo");
		return this;
	}


	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}*/
}
