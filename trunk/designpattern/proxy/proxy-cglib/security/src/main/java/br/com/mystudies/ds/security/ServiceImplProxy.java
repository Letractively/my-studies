package br.com.mystudies.ds.security;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import br.com.mystudies.ds.service.Service;

public class ServiceImplProxy implements  MethodInterceptor {


	private Service service;


	public ServiceImplProxy(Service service) {
		this.service = service;
	}


	@Override
	public Object intercept(Object object, Method method, Object[] objects,
			MethodProxy methodProxy) throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}

}
