package br.com.lawoffice.caixa;

import java.math.BigDecimal;

import br.com.lawoffice.caixa.exception.CaixaException;
import br.com.lawoffice.dominio.Conta;

/**
 * 
 * TODO: javadoc
 * 
 *  Representa o contrato 
 * 
 * 
 * @author robson
 *
 */
public interface Caixa {
	
	public Conta creditar(Conta conta, BigDecimal valor) throws CaixaException;
	public Conta debitar(Conta conta, BigDecimal valor) throws CaixaException;
	public BigDecimal getSaldo(Conta conta) throws CaixaException;
}
