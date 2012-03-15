package br.com.mystudies.ds.security;

import net.sf.cglib.proxy.Enhancer;
import br.co.mystudies.ds.service.impl.ServiceImpl;
import br.com.mystudies.ds.service.Service;

public class ServiceSimpleFactory implements ServiceFactory{


	@Override
	public Service getService(User user) {

		ServiceImplProxy proxy = new ServiceImplProxy(new ServiceImpl(),user);

		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(Service.class);
		enhancer.setCallback(proxy);

		return (Service) enhancer.create();
	}
}
