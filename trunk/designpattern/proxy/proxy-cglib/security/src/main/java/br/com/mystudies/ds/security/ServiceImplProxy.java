package br.com.mystudies.ds.security;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import br.com.mystudies.ds.service.Service;

public class ServiceImplProxy implements  MethodInterceptor {


	private Service service;

	private User user;

	public ServiceImplProxy(Service service, User user) {
		this.service = service;
		this.user = user;
	}


	@Override
	public Object intercept(Object object, Method method, Object[] args,
			MethodProxy methodProxy) throws Throwable {

		switch (user.getGroup()) {
			case ADMINISTRATORS:
				return method.invoke(service, args);
			default:
				throw new SecurityException("User isn't of group administrators");
		}
	}

}
