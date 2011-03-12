/**
 * 
 */
package br.com.lowoffice.custas.extrato;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.lawoffice.dominio.Custa;
import br.com.lawoffice.dominio.Lancamento;

/**
 * 
 * Implementação para o serviço de Extrato
 * 
 * 
 * @author robson
 * @see Extrato
 *
 */
@Stateful
@Local(ExtratoLocal.class)
@Remote(ExtratoRemote.class)
public class ExtratoBean implements Extrato{

	
	/**
	 * Entity Manager para realizar as consultas na base de dados.
	 */
	@PersistenceContext(unitName="lawoffice-custas")
	EntityManager entityManager;
	
	
	/**
	 * {@link List} de {@link Custa} com o resultado da pesquisa.
	 */
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
		
		ExtratoReport extratoReport = SimpleFactoryExtratoReport.createExtratoReport(tipoExtrato);
		
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
	}
}
