package br.com.lawoffice.caixa;

import java.math.BigDecimal;

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
	
	public void creditar(Conta conta, BigDecimal valor);
	public void debitar(Conta conta, BigDecimal valor);
}
