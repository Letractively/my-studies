package br.com.lawoffice.caixa;

import java.math.BigDecimal;

import br.com.lawoffice.caixa.exception.CaixaException;
import br.com.lawoffice.dominio.Conta;

/**
 * Interface de Serviço para realizar operações no caixa do escritório. 
 * 
 * @author robson
 * 
 * @see
 * 
 * {@link CaixaBean} {@link CaixaLocal} {@link CaixaRemote}
 *
 */
public interface Caixa {
	
	/**
	 * Realiza o crédito na {@link Conta} passada.
	 * 
	 * @param conta para realizar o crédito.
	 * @param valor do crédito
	 * @return {@link Conta} com o valor créditado.
	 * @throws CaixaException lançada quando ocorre alguma exceção na a execução do serviço.
	 */
	public Conta creditar(Conta conta, BigDecimal valor) throws CaixaException;
	
	/**
	 * Realiza o débito na {@link Conta} passada.
	 * 
	 * @param conta para realizar o débito.
	 * @param valor do débito.
	 * @return {@link Conta} com o valor débitado.
	 * @throws CaixaException lançada quando ocorre alguma exceção na a execução do serviço.
	 */
	public Conta debitar(Conta conta, BigDecimal valor) throws CaixaException;
	
	/**
	 * Obtém o saldo da {@link Conta} passada.
	 * 
	 * @param conta a obter o saldo.
	 * @return {@link BigDecimal} saldo da {@link Conta} passada.
	 * @throws CaixaException lançada quando ocorre alguma exceção na execuação do serviço.
	 */
	public BigDecimal getSaldo(Conta conta) throws CaixaException;
}
