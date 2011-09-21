package br.com.jsf.spring.cdi.service;

import javax.inject.Named;

@Named()
public class ServiceImpl implements Service {
	

	public void execute() {
		System.out.println("1 2 3 running ..");
	}

}
