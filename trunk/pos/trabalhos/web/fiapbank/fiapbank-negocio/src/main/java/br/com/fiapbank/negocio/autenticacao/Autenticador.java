/**
 * 
 */
package br.com.fiapbank.negocio.autenticacao;

import br.com.fiapbank.dominio.Conta;
import br.com.fiapbank.dominio.Funcionario;
import br.com.fiapbank.negocio.NegocioException;


/**
 * @author robson.oliveira
 *
 */
public interface Autenticador{
	
	/**
	 * Efetua a autenticação da conta passada e retorna a Conta Autenticada
	 * 
	 * @param conta {@link Conta}
	 * @return {@link Conta}
	 * @throws InvalidContaException lançada quando a conta não encontrada
	 * @throws AuteticacaoException lançada quando ocorre algum problema na hora de realizar a autenticacão
	 */
	public Conta autenticarConta(Conta conta)throws NegocioException;
	
	
	/**
	 * Efetua a autenticação do Funcionário passado e retorna o Funcionário Autenticado
	 * 
	 * @param conta {@link Funcionario}
	 * @return {@link Funcionario}
	 * @throws InvalidFuncionarioException lançada quando o Funcionário não é encontrada
	 * @throws AuteticacaoException lançada quando ocorre algum problema na hora de realizar a autenticação
	 */
	public Funcionario autenticarFuncionario(Funcionario funcionario)throws NegocioException;
}
