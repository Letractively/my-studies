/**
 * 
 */
package br.com.fiapbank.persistencia.dao;

import br.com.fiapbank.dominio.Funcionario;

/**
 * @author robson.oliveira
 *
 */
public interface FuncionarioDao extends GenericaDao<Funcionario> {

	/**
	 * Retorna o funcionario autenticado através da senha e login 
	 * 
	 * 
	 * @param funcionario {@link Funcionario} a ser autenticado
	 * @return {@link Funcionario} autenticado da base ou null caso autenticacao falhe
	 * @throws DaoException quando ocorre algum erro no banco
	 */
	public Funcionario getFuncionarioAutenticado(Funcionario funcionario)throws DaoException;
}
