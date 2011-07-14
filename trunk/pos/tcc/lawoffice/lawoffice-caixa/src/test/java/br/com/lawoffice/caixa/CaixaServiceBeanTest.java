package br.com.lawoffice.caixa;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.lawoffice.dominio.Conta;

/**
 * 
 * Teste de unidade para a classe {@link CaixaServiceBean}
 * 
 * @author rduarte
 *
 */
public class CaixaServiceBeanTest{

	
	
	private Contad
	
	private CaixaServiceBean caixaBean;

	
	
	@Before
	public void setUp() throws Exception {
		caixaBean = new CaixaServiceBean();
	}

	@After
	public void tearDown() throws Exception {
		caixaBean = null;
	}

	
	@Test(expected=IllegalArgumentException.class)
	public void deveDispararUmaExcecaoComValorNuloCreditando(){
		Conta conta = new Conta();
		conta.setSaldo(new BigDecimal(0));		
		caixaBean.creditar(conta, null);
	}	
	
	
	@Test(expected=IllegalArgumentException.class)
	public void deveDispararUmaExcecaoComValorMenorZeroCreditando(){
		Conta conta = new Conta();
		conta.setSaldo(new BigDecimal(0));
		caixaBean.creditar(conta, new BigDecimal(-0.01));
	}	
	
	
	@Test(expected=IllegalArgumentException.class)
	public void deveDispararUmaExcecaoComContaNulaCreditando(){
		caixaBean.creditar(null, new BigDecimal(0));
	}

	
	@Test(expected=IllegalArgumentException.class)
	public void deveDispararUmaExcecaoContaComIDNulaCreditando(){
		caixaBean.creditar(new Conta(), new BigDecimal(0));
	}	
	
	
	
	
	@Test()
	public void deveAdcionarUmaTransacaoDeCredito(){
			// conta com valor zerado
			Conta conta = new Conta(); 
			conta.setSaldo(new BigDecimal(0));
			conta.setTransacoes(new ArrayList<Transacao>());
			
			conta = caixaBean.creditar(conta,new BigDecimal(10.0));
			
			assertEquals(conta.getTransacoes().get(0).getTipoTransacao(), TipoTransacao.CREDITO);		
	}
	
	
	
	@Test(expected=IllegalArgumentException.class)
	public void deveDispararUmaExcecaoComValorNuloDebitando(){
		Conta conta = new Conta();
		conta.setSaldo(new BigDecimal(0));		
		caixaBean.debitar(conta, null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deveDispararUmaExcecaoComValorMenorZeroDebitando(){
		Conta conta = new Conta();
		conta.setSaldo(new BigDecimal(0));
		caixaBean.debitar(conta, new BigDecimal(-0.01));
	}	

	@Test(expected=IllegalArgumentException.class)
	public void deveDispararUmaExcecaoComContaNulaDebitando(){
		caixaBean.debitar(null, new BigDecimal(0));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deveDispararUmaExcecaoContaComIDNulaDebitando(){
		caixaBean.debitar(new Conta(), new BigDecimal(0));
	}	
	
}
