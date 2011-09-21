package br.com.jsf.spring.mb;

import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import br.com.jsf.spring.service.Service;

@ManagedBean("serviceMB")
@Scope("session")
public class ServiceMB {

	
	@Autowired
	private Service service;

	
	public void execute(){
		service.execute();
	}
	
}
