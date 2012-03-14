package br.com.mystudies.ds.security;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import br.co.mystudies.ds.service.impl.ServiceImpl;
import br.com.mystudies.ds.service.Service;

public class ServiceSimpleFactory implements ServiceFactory{


	@Override
	public Service getService(User user) {
		return new ServiceImpl();
	}
}
