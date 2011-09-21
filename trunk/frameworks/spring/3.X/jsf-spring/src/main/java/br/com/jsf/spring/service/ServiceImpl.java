package br.com.jsf.spring.service;

import org.springframework.stereotype.Component;

@Component
public class ServiceImpl implements Service {
	
	public void execute() {
		System.out.println("1 2 3 running ..");
	}

}
