package br.com.mystudies.jpa.criteria.api;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public class ClienteDao{

	private EntityManager entityManager;
	
	public List<Cliente> selecionarTodosCliente(){
		
		CriteriaQuery<Cliente> criteriaQuery =			
			entityManager
			.getCriteriaBuilder()
			.createQuery(Cliente.class);
		
		criteriaQuery.from(Cliente.class);
		
		return entityManager
			.createQuery(criteriaQuery)
			.getResultList();
	}

	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
}
