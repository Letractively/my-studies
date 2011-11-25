package br.com.mystudies.dp.proxy.providers;

import java.lang.reflect.Proxy;

import javax.persistence.EntityManager;


public final class EntityMangerProviderFactory {

	
	public static final EntityManager getEntityManger(Provider provider){
		switch (provider) {
		
		case ECLIPSE_LINK:
			return createEntityManger(new EclipseLinkProviderEntityManger());
		case OPEN_JPA:			
			return createEntityManger(new OpenJPAProviderEntityManager());
		case HIBERNATE:			
			return createEntityManger(new HibernateProviderEntityManager());			
		default:
			throw new IllegalArgumentException("don't exist implementation for this provider..: " + provider);
		}
		
	}

	
	private static EntityManager createEntityManger(EntityManager entityManger) {
		return (EntityManager) Proxy.newProxyInstance(
					EntityManager.class.getClassLoader(), 
					new Class[]{EntityManager.class}, 
					new ProviderEntityManagerHandle(entityManger)
			);
	}
}


