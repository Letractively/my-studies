package br.com.mystudies.dp.proxy.providers;

class OpenJPAProviderEntityManager extends AbstractEntityManger {

	@Override
	public void persist(Object object) {
		System.out.println("Provider open jpa persiting..");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
