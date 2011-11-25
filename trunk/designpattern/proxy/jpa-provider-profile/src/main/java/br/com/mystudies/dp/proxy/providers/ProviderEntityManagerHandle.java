package br.com.mystudies.dp.proxy.providers;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import javax.persistence.EntityManager;

class ProviderEntityManagerHandle implements InvocationHandler{

	
	private EntityManager entityManager;
	
	
	public ProviderEntityManagerHandle(EntityManager entityManager) {
		if(entityManager == null)
			throw new IllegalArgumentException("entity manager nulo");
		this.entityManager = entityManager;
	}



	@Override
	public Object invoke(Object object, Method method, Object[] objects)
			throws Throwable {
		long start = System.currentTimeMillis();
			Object invoke = method.invoke(entityManager, objects);
		long end = System.currentTimeMillis();
		
		System.out.println("Total time for execution..:" + (end - start) / 1000 + " seconds");
		
		return invoke;
	}
}