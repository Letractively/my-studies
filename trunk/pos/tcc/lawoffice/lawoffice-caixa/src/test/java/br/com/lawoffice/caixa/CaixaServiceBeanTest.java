package br.com.lawoffice.caixa;

import java.math.BigDecimal;
import java.util.ArrayList;


import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;

import br.com.lawoffice.dominio.Conta;
import br.com.lawoffice.dominio.HistoricoConta;
import br.com.lawoffice.dominio.TipoTransacao;
import br.com.lawoffice.persistencia.ContaDao;

/**
 * 
 * Teste de unidade para a classe {@link CaixaServiceBean}
 * 
 * @author rduarte
 *
 */
public class CaixaServiceBeanTest{

	
	@Mock
	private ContaDao contaDao;
	
	
	@InjectMocks
	private CaixaServiceBean caixaBean;

	
	
	@Before
	public void setUp() throws Exception {
		caixaBean = new CaixaServiceBean();
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
		caixaBean = null;
		reset(contaDao);
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
	
	
	@Test(expected=IllegalArgumentException.class)
	public void deveDispararUmaExcecaoQuandoContaNaoEncontradaCreditar(){
		Conta conta = new Conta();
		conta.setId(1L);
		
		when(
			contaDao.localizar(Conta.class, conta)
		).thenReturn(null);
		
		caixaBean.creditar(conta, new BigDecimal(1));
	}
	
	
	@Test()
	public void deveCreditarQuandoParametrosValidos(){
		Conta conta = new Conta();
		conta.setId(1L);
		conta.setSaldo(new BigDecimal(0));
		conta.setHistoricos(new ArrayList<HistoricoConta>());
		
		when(
			contaDao.localizar(Conta.class, conta)
		).thenReturn(conta);
		
		when(
			contaDao.atualizar(conta)
		).thenReturn(conta);
		
		conta = caixaBean.creditar(conta, new BigDecimal(1));
		
		
		assertNotNull(conta);
		assertEquals(new BigDecimal(1), conta.getSaldo());
		assertNotNull(conta.getHistoricos().get(0));
		assertEquals(TipoTransacao.CREDITO, conta.getHistoricos().get(0).getTipoTransacao());
		assertEquals(new BigDecimal(0), conta.getHistoricos().get(0).getSaloAnterior());
		assertEquals(new BigDecimal(1), conta.getHistoricos().get(0).getValorTransacao());
		assertNotNull(conta.getHistoricos().get(0).getConta());
		
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
	
	
	@Test(expected=IllegalArgumentException.class)
	public void deveDispararUmaExcecaoQuandoContaNaoEncontradaDebitar(){
		Conta conta = new Conta();
		conta.setId(1L);
		
		when(
			contaDao.localizar(Conta.class, conta)
		).thenReturn(null);
		
		caixaBean.debitar(conta, new BigDecimal(1));
	}
	
	
	@Test()
	public void deveDebitarQuandoParametrosValidos(){
		Conta conta = new Conta();
		conta.setId(1L);
		conta.setSaldo(new BigDecimal(0));
		conta.setHistoricos(new ArrayList<HistoricoConta>());
		
		when(
			contaDao.localizar(Conta.class, conta)
		).thenReturn(conta);
		
		when(
			contaDao.atualizar(conta)
		).thenReturn(conta);
		
		conta = caixaBean.debitar(conta, new BigDecimal(1));
		
		
		assertNotNull(conta);
		assertEquals(new BigDecimal(-1), conta.getSaldo());
		assertNotNull(conta.getHistoricos().get(0));
		assertEquals(TipoTransacao.DEBITO, conta.getHistoricos().get(0).getTipoTransacao());
		assertEquals(new BigDecimal(0), conta.getHistoricos().get(0).getSaloAnterior());
		assertEquals(new BigDecimal(1), conta.getHistoricos().get(0).getValorTransacao());
		assertNotNull(conta.getHistoricos().get(0).getConta());
		
	}
	
}
