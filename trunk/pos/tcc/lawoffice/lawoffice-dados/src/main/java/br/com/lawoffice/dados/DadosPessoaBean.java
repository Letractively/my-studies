/**
 * 
 */
package br.com.lawoffice.dados;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.lawoffice.dominio.Pessoa;

/**
 * @author robson
 *
 */
@Stateless
@Local(DadosPessoaLocal.class)
public class DadosPessoaBean implements DadosPessoa {

	@PersistenceContext(unitName="lawoffice-dados")
	private EntityManager entityManager;

	
	@Override
	public <T extends Pessoa> List<T> listarPorNome(Class<T> c,  String nome) {

		 // TODO: validar pessoa ( teste de unidade )
				
		CriteriaBuilder criteriaBuilder =
			entityManager.getCriteriaBuilder();		
		
		CriteriaQuery<T> criteriaQuery  =
			criteriaBuilder.createQuery(c);
		
		Root<T> root =
			criteriaQuery.from(c);		

		
		criteriaQuery
			.select(root)
			.where( 
					criteriaBuilder.like(
							root.get("nome").as(String.class), 
							nome + "%"  
						)
				);
				
		return entityManager
			.createQuery(criteriaQuery)
			.getResultList();
	}

}
