/**
 * 
 */
package br.com.fiapbank.persistencia.dao;

import br.com.fiapbank.dominio.Conta;


/**
 * @author robson.oliveira
 *
 */
public interface ContaDao extends GenericaDao<Conta> {

	/**
	 * Retorna um conta autenticada pelo número da Agência , número da Conta e frase secreta.
	 * 
	 * <br>
	 * 
	 * Ou null caso a conta não possa ser autênticada 
	 * 
	 * @param conta {@link Conta}
	 * @return {@link Conta} 
	 * @throws DaoException quando ocorre algum erro com o banco de dados  
	 */
	public Conta getContaAutenticada(Conta conta)throws DaoException;

	/**
	 * retorna a conta atraves do seu numero / agencia / senha
	 * 
	 * @param conta
	 * @return
	 * @throws DaoException 
	 */
	public Conta getContaPorNumeroAgencia(Conta conta) throws DaoException;
	
	
}
