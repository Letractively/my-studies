package br.com.mystudies.rmi.client;

import java.rmi.Naming;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.mystudies.rmi.service.CarrinhoService;
import br.com.mystudies.rmi.service.Produto;


public class CarrinhoClient {

	
	private static final Log LOG = LogFactory.getLog(CarrinhoClient.class);
	
	public static void main(String[] args) throws Exception {
				
		
		LOG.info("Obtendo o serviço de carrinho via RMI (lookup)");
		
		CarrinhoService carrinhoService = 
				(CarrinhoService) Naming.lookup("rmi://localhost:1099/carrinho/service");

		LOG.info("Serviço de Carrinho obtido via RMI (lookup) com sucesso");
		
		
		
		for (int i = 0; i < args.length; i++) {
			/*
			 * estou fazendo a thread dormir para poder analizar melhor
			 * a saida do console ( LOG )  e visualizar as jvms ( processos )
			 * abertas.
			 */
			Thread.sleep(5000);
			LOG.info("Add produto no carrinho..: " + args[i]);
			carrinhoService.addProduto(new Produto(args[i], i));
		}
		
		
		List<Produto> produtos = 
				carrinhoService.listarProdutosNoCarriho();
		
		LOG.info("Listando os produtos do carrinho..:");
		for (Produto produto : produtos) {
			LOG.info("Nome do Produto..: " + produto.getNome());
			LOG.info("Número do Produto..: " + produto.getNumero());
		}
	}
}
