package br.com.mystudies.dp.proxy.providers;

class HibernateProviderEntityManager extends AbstractEntityManger {

	@Override
	public void persist(Object object) {
		System.out.println("Provider hibernate persiting..");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
