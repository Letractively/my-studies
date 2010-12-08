package br.com.mystudies.jpa.criteria.api;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class ClienteDao{

	private EntityManager entityManager;
	
	public List<Cliente> selecionarTodosCliente(){
		
		CriteriaQuery<Cliente> criteriaQuery =			
			entityManager
			.getCriteriaBuilder()
			.createQuery(Cliente.class);

		Root<Cliente> root =
			criteriaQuery.from(Cliente.class);
		
		return entityManager
			.createQuery(criteriaQuery)
			.getResultList();
	}
	
	public Cliente selecionarClientePorNome(String nome){
		
		CriteriaBuilder criteriaBuilder 
			= entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Cliente> criteriaQuery =
			criteriaBuilder.createQuery(Cliente.class);
		
		Root<Cliente> root = 
			criteriaQuery.from(Cliente.class);
				
		criteriaQuery
			.select(root)
			.where(
				criteriaBuilder
					.equal(root.get("nome"), nome)						
			);
		
		return entityManager
			.createQuery(criteriaQuery)
			.getSingleResult();
	}

	public List<Cliente> deveSelecionarTodosClientePelaIdadeEntre(Integer idadeInicial, Integer idadeFinal){
		CriteriaBuilder criteriaBuilder 
			= entityManager.getCriteriaBuilder();

		CriteriaQuery<Cliente> criteriaQuery =
			criteriaBuilder.createQuery(Cliente.class);

		Root<Cliente> root = 
			criteriaQuery.from(Cliente.class);

		criteriaQuery
			.select(root)
			.where(
				criteriaBuilder
				 .between(root.get("idade").as(Integer.class), idadeInicial, idadeFinal)						
			);

		return entityManager
		.createQuery(criteriaQuery)
		.getResultList();
	}
	
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	
}
