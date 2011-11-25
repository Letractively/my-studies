package br.com.mystudies.dp.proxy.providers;

class EclipseLinkProviderEntityManger extends AbstractEntityManger{

	@Override
	public void persist(Object arg0) {
		System.out.println("Provider eclipselink persiting..");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
}
