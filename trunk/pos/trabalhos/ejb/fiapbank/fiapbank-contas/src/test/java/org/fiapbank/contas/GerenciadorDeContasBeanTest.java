package org.fiapbank.contas;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.fiapbank.contas.ContaInvalidaExcetpion;
import br.com.fiapbank.contas.GerenciadorDeContasBean;
import br.com.fiapbank.dominio.entidade.Cliente;
import br.com.fiapbank.dominio.entidade.Conta;
import br.com.fiapbank.dominio.entidade.Renda;

/**
 * 
 * teste de unidade para o gerenciador de contas bean
 * 
 * @author robson
 *
 */
public class GerenciadorDeContasBeanTest {

	
	
	/*
	 *  lembrado que esse bean é @Stateful, um por cliente então vamos ter um apenas para o teste
	 */
	private GerenciadorDeContasBean gerenciadorDeContasBeanTest = new GerenciadorDeContasBean();
	
	

	
	@Test
	public void testAvaliarClienteNulo() {
		
		Exception ex = null;
			
		try {
			gerenciadorDeContasBeanTest.avaliarCliente(null);
		} catch (Exception e) {
			ex = e;
		}
		
		assertNotNull(ex);
	}
	
	
	@Test
	public void testAvaliarClienteCPFNULO() {
		
		Exception ex = null;
			
		try {
			gerenciadorDeContasBeanTest.avaliarCliente(new Cliente());
		} catch (Exception e) {
			ex = e;
		}
		
		assertNotNull(ex);
	}
	
	@Test
	public void testAvaliarClienteComNomeSujo() {
		
		Exception ex = null;
			
		try {
			
			Cliente c = new Cliente();
			c.setCpf("21468086839");
			
			gerenciadorDeContasBeanTest.avaliarCliente(c);
		} catch (Exception e) {
			ex = e;
		}
		
		assertNotNull(ex);
	}
	
	
	@Test
	public void testAvaliarClienteComNomeLimpo() {
		
		Exception ex = null;
			
		try {
			
			Cliente c = new Cliente();
			c.setCpf("31468086839");
			
			gerenciadorDeContasBeanTest.avaliarCliente(c);
		} catch (Exception e) {
			ex = e;
		}
		
		assertNull(ex);
	}	
	

	@Test
	public void testAvaliarRendaNula() {
		Exception ex = null;
		
		try {
			gerenciadorDeContasBeanTest.avaliarRenda(null);
		} catch (Exception e) {
			ex = e;
		}
		
		assertNotNull(ex);
	}
	
	;
	
	
	@Test
	public void testAvaliarRendaInvalida() {
		Exception ex = null;
		
		try {
			Renda r = new Renda();
			r.setGastoMensal( new BigDecimal(0));
			r.setRendaMensal(new BigDecimal(0));
			gerenciadorDeContasBeanTest.avaliarRenda(r);
		} catch (Exception e) {
			ex = e;
		}
		
		assertNotNull(ex);
	}
	
	
	@Test
	public void testAvaliarRendaValida() {
		Exception ex = null;
		
		try {
			Renda r = new Renda();
			r.setGastoMensal( new BigDecimal(5));
			r.setRendaMensal(new BigDecimal(15));
			gerenciadorDeContasBeanTest.avaliarRenda(r);
		} catch (Exception e) {
			ex = e;
		}
		
		assertNull(ex);
	}
	
	
	@Test
	public void testAbriContaNula() {
		Exception ex = null;		
		try {
			gerenciadorDeContasBeanTest.abriConta(null);
		} catch (Exception e) {
			ex = e;
		}
		
		assertNotNull(ex);
		assertTrue(ex instanceof ContaInvalidaExcetpion);
	}
	
	
	@Test
	public void testAbriContaSemAvaliacao() {
		Exception ex = null;		
		// esse cara nao executou os metodos de avaliaca antes de abrir a conta
		GerenciadorDeContasBean gerenciadorDeContasBean = new GerenciadorDeContasBean();
		
		try {
			gerenciadorDeContasBean.abriConta(new Conta());
		} catch (Exception e) {
			ex = e;
		}
		
		assertNotNull(ex);
		assertTrue(ex instanceof ContaInvalidaExcetpion);
	}

}
