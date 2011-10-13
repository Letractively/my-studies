package br.com.mystudies.rmi.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface CarrinhoService extends Remote {

	void addProduto(Produto produto)throws RemoteException;
	
	List<Produto> listarProdutosNoCarriho()throws RemoteException;
}
