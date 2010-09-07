package br.com.fiapbank.negocio.caixa;

import br.com.fiapbank.dominio.Conta;
import br.com.fiapbank.negocio.NegocioException;

/**
 * 
 * Possui as operacoes utilizadas no caixa do sistema
 * 
 * @author robson
 *
 */
public interface CaixaNegocio {
	

	public void sacar(Conta conta, Double valor, String senha) throws NegocioException;
	
	public void depositar(Conta conta, Double valor, String senha) throws NegocioException;


	public void retirarTalao(Conta conta, int quantidade, String senha) throws NegocioException;
	
	
	public void retirarCartao(Conta conta, int quantidade, String senha) throws NegocioException;
	
}
