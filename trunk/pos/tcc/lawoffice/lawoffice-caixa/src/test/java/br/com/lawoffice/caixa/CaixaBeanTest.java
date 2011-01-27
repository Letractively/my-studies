package br.com.lawoffice.caixa;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.lawoffice.dominio.Conta;
import br.com.lawoffice.dominio.TipoTransacao;
import br.com.lawoffice.dominio.Transacao;

/**
 * 
 * Teste de unidade para a classe {@link CaixaBean}
 * 
 * @author rduarte
 *
 */
public class CaixaBeanTest{

	
	private CaixaBean caixaBean;
	
	@Before
	public void setUp() throws Exception {
		caixaBean = new CaixaBean();
	}

	@After
	public void tearDown() throws Exception {
		caixaBean = null;
	}

	
	@Test(expected=IllegalArgumentException.class)
	public void deveDispararUmaExcecaoComValorNulo() throws CaixaException{
		Conta conta = new Conta();
		conta.setSaldo(new BigDecimal(0));		
		caixaBean.creditar(conta, null);
	}	
	
	
	@Test(expected=IllegalArgumentException.class)
	public void deveDispararUmaExcecaoComValorMenorZero() throws CaixaException{
		Conta conta = new Conta();
		conta.setSaldo(new BigDecimal(0));
		caixaBean.creditar(conta, new BigDecimal(-0.01));
	}	
	
	
	@Test(expected=IllegalArgumentException.class)
	public void deveDispararUmaExcecaoComContaNula() throws CaixaException{
		caixaBean.creditar(null, new BigDecimal(0));
	}

	
	@Test(expected=IllegalArgumentException.class)
	public void deveDispararUmaExcecaoContaComIDNula() throws CaixaException{
		caixaBean.creditar(new Conta(), new BigDecimal(0));
	}	
	
/*		
	@Test()
	public void deveAdcionarUmaTransacaoDeCredito(){
		// conta com valor zerado
		Conta conta = new Conta(); 
		conta.setSaldo(new BigDecimal(0));
		conta.setTransacoes(new ArrayList<Transacao>());
		
		conta = caixaBean.creditar(conta,new BigDecimal(10.0));
		
		assertEquals(conta.getTransacoes().get(0).getTipoTransacao(), TipoTransacao.CREDITO);		
	}*/
	
	
	@Test
	public void testDebitar() {
		fail("Not yet implemented");
	}

}
