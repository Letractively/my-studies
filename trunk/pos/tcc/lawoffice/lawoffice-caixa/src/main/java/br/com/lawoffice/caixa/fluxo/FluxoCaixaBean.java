/**
 * 
 */
package br.com.lawoffice.caixa.fluxo;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.lawoffice.dominio.Conta;
import br.com.lawoffice.dominio.Transacao;

/**
 * TODO: javadoc
 * 
 * @author robson
 *
 */
@Stateless
@Local(FluxoCaixaLocal.class)
@Remote(FluxoCaixaRemote.class)
public class FluxoCaixaBean implements FluxoCaixa {

	
	@PersistenceContext(unitName="lawoffice-caixa")
	private EntityManager entityManager;
	
	
	// TODO: para realizar o teste de unidade 100 % acho que será necessário
	// criar uma camada DAO podendo mocar a mesma com mais facilidade
	// do que o entntiy manager e as criteria ....
	@Override
	public List<Transacao> consultarFluxoDeCaixa(Date dateInicial, Date dataFinal, Long numeroConta){
		validarParametros(dateInicial, dataFinal, numeroConta);
		
		CriteriaBuilder criteriaBuilder = 
			entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Transacao> criteriaQuery =
			criteriaBuilder.createQuery(Transacao.class);
		
		
		Root<Transacao> root =
			criteriaQuery.from(Transacao.class);
		
		
		criteriaQuery
			.select(root)
			.where(
				criteriaBuilder.and(
						criteriaBuilder.between(root.get("dataTransacao").as(Date.class), dateInicial, dataFinal),
						criteriaBuilder.equal(root.get("conta").get("id"), numeroConta)
					)
			);
		
		
		return entityManager
			.createQuery(criteriaQuery)
			.getResultList();
	}

	
	
	
	
	private void validarParametros(Date dateInicial, Date dataFinal,
			Long numeroConta) {
		if(dateInicial == null || dataFinal == null)
			throw new IllegalArgumentException("Data Inicial ou Data Final nula");
		if(numeroConta == null)
			throw new IllegalArgumentException("Numero Conta nula");
	}

}
