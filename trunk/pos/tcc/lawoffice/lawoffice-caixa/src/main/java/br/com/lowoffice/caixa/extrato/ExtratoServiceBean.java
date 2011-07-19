/**
 * 
 */
package br.com.lowoffice.caixa.extrato;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;

import br.com.lawoffice.dominio.Cliente;
import br.com.lawoffice.dominio.Colaborador;
import br.com.lawoffice.dominio.Pessoa;
import br.com.lawoffice.persistencia.ClienteDao;
import br.com.lawoffice.persistencia.ColaboradorDao;

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


	@Override
	public ExtratoDTO getExtratoColaborador(Date dataInicial, Date dataFinal,
			Colaborador colaborador) {
		validarParametros(dataInicial, dataFinal, colaborador);
		
		colaborador = 
				colaboradorDao.localizar(Colaborador.class, colaborador);
		
		if(colaborador == null)
			return null;
		
		// obter saldo da datainicial - 1
		// obter historico da conta no periodo
		// obter lancamentos ( custas ) no perido
		// criar lista de itens do historicos + custas .. 
		
		return new ExtratoDTO(null, null, null);
	}






	@Override
	public ExtratoDTO getExtratoCliente(Date dataInicial, Date dataFinal,
			Cliente cliente) {
		validarParametros(dataInicial, dataFinal, cliente);
		
		cliente =
				clienteDao.localizar(Cliente.class, cliente);
		
		if(cliente == null)
			return null;
				
		
		return new ExtratoDTO(null, null, null);
	}	
	
	
	
	
	
	/*@Override
	public ExtratoDTO getExtrato(Date dataInicial, Date dataFinal, Pessoa pessoa) {
		validarParametros(dataInicial,dataFinal,pessoa);
		
		
		pessoa = 
			pessoaDao.localizar(Pessoa.class, pessoa);
		
		
		if(pessoa == null)
			return null;
		

		// obter a conta
		// pegar o seu historico pela datainicial - 1;
		// pegar as custas no periodo (lançamento)
		// gerar os itens baseado nas datas
		
		
		
		
		ExtratoDTO extratoDTO =
				new ExtratoDTO(
						pessoa.getNome(),
						dataInicial, 
						dataFinal
					);
		
		
		
		
		return extratoDTO null;
	}*/

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	










































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
