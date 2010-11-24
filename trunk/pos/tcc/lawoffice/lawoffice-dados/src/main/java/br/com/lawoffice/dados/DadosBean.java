/**
 * 
 */
package br.com.lawoffice.dados;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

/**
 * 
 * Bean para o serviço de dados
 * 
 * 
 * @author robson
 *
 */
@Stateless
@Local(DadosLocal.class)
@Remote(DadosRemote.class)
public class DadosBean implements Dados {

	@PersistenceContext(unitName="lawoffice-dados")
	EntityManager entityManager;
	
	
	@Override
	public <T> T atualizar(T t) {
		return null;
	}

	
	@Override
	public void remover(long id) {
		
	}

	
	@Override
	public <T> T localizar(long id) {
		return null;
	}

	
	@Override
	public <T> T salvar(T t) {
		return null;
	}

	
	@Override
	public <T> List<T> listar(Class<T> c){
		
		CriteriaQuery<T> criteriaQuery =
			entityManager
			.getCriteriaBuilder()
			.createQuery(c);
		
		criteriaQuery.from(c);
		
		return entityManager.createQuery(criteriaQuery).getResultList();
	}


	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
