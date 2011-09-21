package br.com.jsf.spring.cdi.mb;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

import org.springframework.context.annotation.Scope;

import br.com.jsf.spring.cdi.service.Service;

@ManagedBean("serviceMB")
@Scope("session")
public class ServiceMB {

	
	@Inject
	private Service service;

	
	public void execute(){
		service.execute();
	}
	
}
