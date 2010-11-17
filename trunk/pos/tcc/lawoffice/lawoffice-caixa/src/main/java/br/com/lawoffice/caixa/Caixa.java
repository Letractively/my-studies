package br.com.lawoffice.caixa;

import java.math.BigDecimal;

import br.com.lawoffice.dominio.Conta;

/**
 *  Representa o contrato 
 * 
 * 
 * @author robson
 *
 */
public interface Caixa {
	
	public void creditar(Conta conta, BigDecimal quantidade);
	public void debitar(Conta conta, BigDecimal quantidade);
}
