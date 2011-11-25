package br.com.mystudies.dp.proxy.dao.profile;

import javax.persistence.EntityManager;

import br.com.mystudies.dp.proxy.providers.EntityMangerProviderFactory;
import br.com.mystudies.dp.proxy.providers.Provider;

public class ProfileProvider {

	public static void main(String[] args) {
		
		EntityManager entityManager =
				EntityMangerProviderFactory.getEntityManger(Provider.HIBERNATE);
		
		entityManager.persist(new Object());
				
		
		entityManager =
				EntityMangerProviderFactory.getEntityManger(Provider.ECLIPSE_LINK);
		
		entityManager.persist(new Object());
		
		
		entityManager =
				EntityMangerProviderFactory.getEntityManger(Provider.OPEN_JPA);
		
		entityManager.persist(new Object());
		
	}
}
