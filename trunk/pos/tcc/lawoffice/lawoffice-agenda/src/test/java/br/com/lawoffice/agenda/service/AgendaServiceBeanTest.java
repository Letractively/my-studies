package br.com.lawoffice.agenda.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * Teste de unidade para {@link AgendaServiceBean} que implementa {@link AgendaService} utilizando tecnologina EJB 3.1.
 * 
 * 
 * @author robson
 *
 */
public class AgendaServiceBeanTest {

	
	private AgendaServiceBean agendaServiceBean;
	
	@Before
	public void setUp() throws Exception{
		agendaServiceBean = new AgendaServiceBean();
	}

	@After
	public void tearDown() throws Exception {
		agendaServiceBean = null;
	}

	@Test
	public void deveRetornarListaVaziaComDataNulas() {
		assertTrue(agendaServiceBean.listarEventos(null, null, null).isEmpty());
	}
	

	
	@Test
	public void testAdicionarEvento() {
		fail("Not yet implemented");
	}

	@Test
	public void testAtualizarEvento() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoverEvento() {
		fail("Not yet implemented");
	}

}
