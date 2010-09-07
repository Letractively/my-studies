package br.com.fiapbank.credito;

import java.util.List;

import br.com.fiapbank.dominio.entidade.Conta;
import br.com.fiapbank.dominio.entidade.Credito;
import br.com.fiapbank.dominio.entidade.Renda;

/**
 * 
 * interface para gerenciar creditos de uma conta simples
 * 
 * @author robson
 *
 */
public interface GerenciadorDeCreditos {

	/**
	 * 
	 * efetua a avaliacao do credito
	 * 
	 * @param renda
	 * @return
	 */
	public Credito avaliarCredito(Credito credito, Renda renda);
	
	
	/**
	 * cria um credito para conta passada
	 * 
	 * @param credito
	 */
	public void criarCredito(Credito credito, Conta conta);
	
	
	
	/**
	 * 
	 * Retorna os creditos da conta passada
	 * 
	 * @param conta - conta a ser pesquisa os creditos
	 * @return {@link List}- com o s creditos da conta
	 */
	public List<Credito> getCreditos(Conta conta);
	
	
	
	/**
	 * 
	 * Retorna os creditos que estao para ser avaliados
	 * 
	 * @param conta - conta a ser pesquisa os creditos
	 * @return {@link List}- com o s creditos da conta
	 */
	public List<Credito> getCreditosAvaliar();
	
	
	/**
	 * 
	 * 
	 * @param credito
	 */
	public void aprovarCredito(Credito credito);
	
	
	/**
	 * 
	 * 
	 * @param credito
	 */
	public void reijetarCredito(Credito credito);
	
	
	
	/**
	 * 
	 * retorna a conta para avalicacao de credtio atraves do seu login ..
	 * 
	 * @param login
	 * @return
	 */
	public Conta getContaParaCredito(String login);
	
}
