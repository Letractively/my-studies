package br.com.lawoffice.caixa;

import java.math.BigDecimal;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.com.lawoffice.dominio.Conta;

/**
 * 
 * TODO: javadoc
 * 
 * @author robson
 *
 */
@Stateless
@Local(CaixaLocal.class)
@Remote(CaixaRemote.class)
public class CaixaBean implements Caixa {

	@Override
	public void creditar(Conta conta, BigDecimal valor) {
		// TODO Auto-generated method stub
		System.out.println("creditando");
	}

	@Override
	public void debitar(Conta conta, BigDecimal  valor) {
		// TODO Auto-generated method stub
		System.out.println("debitando");

	}

}
