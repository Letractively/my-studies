package br.com.fiapbank.contas;

import br.com.fiapbank.dominio.entidade.Cliente;
import br.com.fiapbank.dominio.entidade.Conta;
import br.com.fiapbank.dominio.entidade.Renda;

/**
 * 
 * Possui metodos para validacao e a criacao de uma conta simples
 * 
 * @author robson.oliveira
 * 
 * @see {@link GerenciadorDeContasBean} {@link Conta} {@link Renda} {@link Cliente}
 *
 */
public interface GerenciadorDeContas{
	
	/** 
	 * 
	 * Cria um conta comum
	 * 
	 * @param conta {@link Conta} para ser criada
	 * @return {@link Conta} criada 
	 * @throws GerenciadorDeContasException quando ocorre algum erro na criacao da conta
	 * @throws ContaInvalidaExcetpion quando ocorre algum erro na validacao da conta 
	 * @throws EntidadeInvalidaException quando a conta nao passa na validacao 
	 */
	public Conta abriConta(Conta conta)throws GerenciadorDeContasException, ContaInvalidaExcetpion;
	
	/**
	 * 
	 * valida o cliente em orgaos de consuta ..
	 * 
	 * @param cliente {@link Cliente} a ser avaliado
	 * @throws ClienteInvalidoException lancada quando o cliente nao passa na avalidacao
	 * @throws EntidadeInvalidaException  quando a entidade cliente nao passa na validacao
	 */
	public void avaliarCliente(Cliente cliente)throws ClienteInvalidoException;
	
	/**
	 * 
	 * avalia a renda passada
	 * 
	 * @param renda {@link Renda} a ser avaliada
	 * @throws RendaInvalidaExcetpion lancada quando a renda nao passa na avaliacao
	 * @throws EntidadeInvalidaException quando a entidade renda nao passa na validacao 
	 */
	public void avaliarRenda(Renda renda)throws RendaInvalidaExcetpion;
	
}
