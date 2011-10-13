package br.com.mystudies.rmi.service;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



public class Server {

	private static final Log LOG = LogFactory.getLog(Server.class);
	
	public static void main(String[] args) throws Exception {
		
		LOG.info("Registrando o  Serviço de Carrinho no RMI");
		
		LocateRegistry.createRegistry(1099);		
		Naming.rebind("carrinho/service", new CarrinhoServiceImpl());
		
		LOG.info("Serviço de Carrinho Registrado RMI");
		
	}
}
