package br.com.fiapbank.credito;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.fiapbank.credito.GerenciadorDeCreditosBean;
import br.com.fiapbank.dominio.entidade.Conta;
import br.com.fiapbank.dominio.entidade.Credito;
import br.com.fiapbank.dominio.entidade.Renda;
import br.com.fiapbank.dominio.entidade.StatusCredito;

/**
 * Teste unitario para o GerenciadorDeCreditosBean 
 * 
 * @author robson
 *
 */
public class GerenciadorDeCreditosBeanTest {

	
	private GerenciadorDeCreditosBean gerenciadorDeCreditosBeanTest;
	
	@Before
	public void setUp() throws Exception {
		gerenciadorDeCreditosBeanTest = new GerenciadorDeCreditosBean();
	}

	@After
	public void tearDown() throws Exception {
		gerenciadorDeCreditosBeanTest = null;
	}

	@Test
	public void testAvaliarCreditoComCreditoNulo() {
		Exception ex = null;
		
		try {
			gerenciadorDeCreditosBeanTest.avaliarCredito(null,null);
		} catch (Exception e) {
			ex = e;
		}
		
		assertNotNull(ex);
	}

	
	@Test
	public void testAvaliarCreditoComRendaNula() {
		Exception ex = null;
		try {
			gerenciadorDeCreditosBeanTest.avaliarCredito(new Credito(), null);
		} catch (Exception e) {
			ex = e;
		}
		
		assertNotNull(ex);
	}
	
	
	@Test
	public void testAvaliarCreditoAprovadoPrimeiraRegra() {
		Exception ex = null;
		
		Credito credito = new Credito();
		
		credito.setQuantidadeDeMeses(10);
		credito.setValorCredito(new BigDecimal(100.20));
		
		Renda renda = new Renda();
		
		
		// gasto - renda  = 500.00
		// entao temos 500.00 * 0.4 * 10 = 
		// com isso entramos na primeira regra
		
		renda.setGastoMensal( new BigDecimal(10.20));
		renda.setRendaMensal(new BigDecimal(510.20));
		
		try {
			credito = gerenciadorDeCreditosBeanTest.avaliarCredito(credito,renda);
		} catch (Exception e) {
			ex = e;
		}
		
		assertNull(ex);
		assertNotNull(credito);
		assertEquals(credito.getStatusCredito(), StatusCredito.APROVADO);
		
	}
	
	
	
	@Test
	public void testAvaliarCreditoAprovadoSegundaRegra() {
		Exception ex = null;
		
		Credito credito = new Credito();
		
		credito.setQuantidadeDeMeses(10);
		credito.setValorCredito(new BigDecimal(2010));
		
		Renda renda = new Renda();
		
		
		
		
		// gasto - renda  = 500.00
		
		// para primeira regra
		// 500.00 * 0.4 * 10 = 2000 
		// valor menor que o valor do credito dessa forma nao passa na primeira regra
		
		// para a segunda entao temos		
		// 500 * 0.2 * 10 + 10100.00 * 0.1 = 2010
		// 2010 >= ao credito , assim entrando na segunda regra
		
		renda.setGastoMensal(new BigDecimal(10.20));
		renda.setRendaMensal(new BigDecimal(510.20));
		renda.setValorTotalPatrimonio(new BigDecimal(10100.00));
		
		try {
			credito = gerenciadorDeCreditosBeanTest.avaliarCredito(credito,renda);
		} catch (Exception e) {
			ex = e;
		}
		
		assertNull(ex);
		assertNotNull(credito);
		assertEquals(credito.getStatusCredito(), StatusCredito.APROVADO);
		
	}
	
	
	@Test
	public void testAvaliarCreditorReprovado() {
		
		Exception ex = null;
		
		Credito credito = new Credito();
		
		credito.setQuantidadeDeMeses(10);
		credito.setValorCredito(new BigDecimal(6020));
		
		Renda renda = new Renda();
		
		// gasto - renda  = 500.00
		
		// para primeira regra
		// 500.00 * 0.4 * 10 = 2000 
		// valor menor que o valor do credito dessa forma nao passa na primeira regra
		
		// para a segunda entao temos		
		// 500 * 0.2 * 10 + 10000.00 * 0.1 = 2000
		// 2000 < ao credito , assim entrando na segunda regra

		// para a terceira entao temos		
		// 500 * 0.6 * 10 + 10000.00 * 0.3 = 6000
		// 6000 < ao credito , assim entrando na terceira regra
		
		
		
		renda.setGastoMensal(new BigDecimal(10.20));
		renda.setRendaMensal(new BigDecimal(510.20));
		renda.setValorTotalPatrimonio(new BigDecimal(10000.00));
		
		try {
			credito = gerenciadorDeCreditosBeanTest.avaliarCredito(credito,renda);
		} catch (Exception e) {
			ex = e;
		}
		
		assertNull(ex);
		assertNotNull(credito);
		assertEquals(credito.getStatusCredito(), StatusCredito.REJEITADO);
		
	}
	
	
	@Test
	public void testAvaliarCreditorSujeitoAAprovacao() {
		
		Exception ex = null;
		
		Credito credito = new Credito();
		
		credito.setQuantidadeDeMeses(10);
		credito.setValorCredito(new BigDecimal(5990));
		
		Renda renda = new Renda();
		
		// gasto - renda  = 500.00
		
		// para primeira regra
		// 500.00 * 0.4 * 10 = 2000 
		// valor menor que o valor do credito dessa forma nao passa na primeira regra
		
		// para a segunda entao temos		
		// 500 * 0.2 * 10 + 10000.00 * 0.1 = 2000
		// 2000 < ao credito , assim entrando na segunda regra

		// para a terceira entao temos		
		// 500 * 0.6 * 10 + 10000.00 * 0.3 = 6000
		// 6000 > ao credito , assim entrando na terceira regra
		
		// entrando assim para aprovocao
		
		renda.setGastoMensal(new BigDecimal(10.20));
		renda.setRendaMensal(new BigDecimal(510.20));
		renda.setValorTotalPatrimonio(new BigDecimal(10000.00));
		
		try {
			credito = gerenciadorDeCreditosBeanTest.avaliarCredito(credito,renda);
		} catch (Exception e) {
			ex = e;
		}
		
		assertNull(ex);
		assertNotNull(credito);
		assertEquals(credito.getStatusCredito(), StatusCredito.SUJEITO_A_APROVACAO);
		
	}
	
	@Test
	public void testCriarCreditoComCreditoNulo() {
		Exception ex = null;
		try {
			gerenciadorDeCreditosBeanTest.criarCredito(null, null);
		} catch (Exception e) {
			ex = e;
		}
		assertNotNull(ex);
	}
	
	
	@Test
	public void testCriarCreditoComContaNula() {
		Exception ex = null;
		try {
			gerenciadorDeCreditosBeanTest.criarCredito(new Credito(), null);
		} catch (Exception e) {
			ex = e;
		}
		assertNotNull(ex);
	}
	
	
	@Test
	public void testCriarCreditoComCreditoSemStatus() {
		Exception ex = null;
		try {
			gerenciadorDeCreditosBeanTest.criarCredito(new Credito(), new Conta());
		} catch (Exception e) {
			ex = e;
		}
		assertNotNull(ex);
	}	

	@Test
	public void testCriarCreditoComCreditoComStatusRejeitado() {
		Exception ex = null;
		try {
			Credito credito = new Credito();
			credito.setStatusCredito(StatusCredito.REJEITADO);
			gerenciadorDeCreditosBeanTest.criarCredito(credito, new Conta());
		} catch (Exception e) {
			ex = e;
		}
		assertNotNull(ex);
	}	
	

	@Test
	public void testGetCreditosContaNula() {
		Exception ex = null;
		try {
			gerenciadorDeCreditosBeanTest.getCreditos(null);
		} catch (Exception e) {
			ex = e;
		}
		assertNotNull(ex);
	}


	@Test
	public void testAprovarCreditoComCreditoNullo() {
		Exception ex = null;
		try {
			gerenciadorDeCreditosBeanTest.aprovarCredito(null);
		} catch (Exception e) {
			ex = e;
		}
		assertNotNull(ex);
	}
	
	
	@Test
	public void testAprovarCreditoComCreditoComIDNulo() {
		Exception ex = null;
		try {			
			gerenciadorDeCreditosBeanTest.aprovarCredito(new Credito());
		} catch (Exception e) {
			ex = e;
		}
		assertNotNull(ex);
	}
	
	
	@Test
	public void testReijetarCreditoComCreditoNulo() {
		Exception ex = null;
		try {
			gerenciadorDeCreditosBeanTest.reijetarCredito(null);
		} catch (Exception e) {
			ex = e;
		}
		assertNotNull(ex);
	}
	
	
	@Test
	public void testReijetarCreditoComCreditoComIDNulo() {
		Exception ex = null;
		try {
			gerenciadorDeCreditosBeanTest.reijetarCredito(new Credito());
		} catch (Exception e) {
			ex = e;
		}
		assertNotNull(ex);
	}	
	
}
