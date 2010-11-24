/**
 * 
 */
package br.com.lawoffice.dados;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

/**
 * 
 * Bean para o serviço de dados
 * 
 * 
 * @author robson
 *
 */
public class DadosBean implements Dados {

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
	
	
	
}
