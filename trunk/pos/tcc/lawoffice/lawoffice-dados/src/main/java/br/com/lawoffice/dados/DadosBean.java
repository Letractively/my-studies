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
	public <T> T atualizar(T t){
		entityManager.merge(t);
		return t;
	}

	
	@Override
	public <T> void remover(Class<T> t, long id){
		entityManager.remove(localizar(t, id));
	}

	
	@Override
	public <T> T localizar(Class<T> t,long id){
		return entityManager.find(t, id);
	}

	
	@Override
	public <T> T salvar(T t){
		entityManager.persist(t);
		return t;
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
