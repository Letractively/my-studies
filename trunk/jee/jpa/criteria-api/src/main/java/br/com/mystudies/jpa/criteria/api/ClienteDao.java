package br.com.mystudies.jpa.criteria.api;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * @author rduarte
 *
 */
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

	public List<Cliente> selecionarTodosClientePelaIdadeEntre(Integer idadeInicial, Integer idadeFinal){
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
	
	public List<Cliente> selecionarTodosClientePeloNumeroEnderecoEntre(Integer numeroEnderecoIncial, Integer numeroEnderecoFinal){
		CriteriaBuilder criteriaBuilder =
			entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Cliente> criteriaQuery =
			criteriaBuilder.createQuery(Cliente.class);
		
		Root<Cliente> root =
			criteriaQuery.from(Cliente.class);
		
		
		criteriaQuery
			.select(root)
			.where(
				criteriaBuilder.between(
					root.get("endereco").get("numero").as(Integer.class), 
					numeroEnderecoIncial, 
					numeroEnderecoFinal)
			);
				
		return entityManager
			.createQuery(criteriaQuery)
			.getResultList();
	}
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Cliente selecionarClientePorNomeIdade(String nomeCliente, Integer idadeCliente){		
		CriteriaBuilder criteriaBuilder
			= entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Cliente> criteriaQuery =
			criteriaBuilder.createQuery(Cliente.class);		
		
		Root<Cliente> root =
			criteriaQuery.from(Cliente.class);		
		
		criteriaQuery
			.select(root)
			.where(
				  criteriaBuilder.and(
					 criteriaBuilder.equal(root.get("nome"), nomeCliente),
					 criteriaBuilder.equal(root.get("idade"), idadeCliente)
				)		
			);
		
		return entityManager
				.createQuery(criteriaQuery)
				.getSingleResult();
	}
}
