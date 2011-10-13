package br.com.mystudies.rmi.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CarrinhoServiceImpl extends UnicastRemoteObject implements CarrinhoService {

	private static final long serialVersionUID = 8172490690258254724L;

	private static final Log LOG = LogFactory.getLog(CarrinhoServiceImpl.class);
	
	private List<Produto> listaProdutos;
	
	protected CarrinhoServiceImpl() throws RemoteException {
		super();
		listaProdutos = new ArrayList<Produto>();
	}

	@Override
	public void addProduto(Produto produto) {
		
		LOG.info("Add produto no carrinho.." + produto.getNome() );		
		listaProdutos.add(produto);
		LOG.info("produto adicionado no carrinho.." + produto.getNome() );
	}

	@Override
	public List<Produto> listarProdutosNoCarriho() {
		return listaProdutos;
	}

}
