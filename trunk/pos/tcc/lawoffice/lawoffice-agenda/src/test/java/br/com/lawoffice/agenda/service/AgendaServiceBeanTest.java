package br.com.lawoffice.agenda.service;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.lawoffice.dominio.Colaborador;
import br.com.lawoffice.dominio.Evento;
import br.com.lawoffice.persistencia.EventoDao;

/**
 * 
 * Teste de unidade para {@link AgendaServiceBean} que implementa {@link AgendaService} utilizando tecnologina EJB 3.1.
 * 
 * 
 * @author robson
 *
 */
public class AgendaServiceBeanTest {

	@Mock
	private EventoDao enventoDao;
	
	
	@InjectMocks
	private AgendaServiceBean agendaServiceBean;
	

	
	@Before
	public void setUp() throws Exception{
		agendaServiceBean = new AgendaServiceBean();
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
		agendaServiceBean = null;
		reset(enventoDao);
	}

	@Test
	public void deveRetornarListaVaziaQuandoColaboradorNulo() {
		assertTrue(
			agendaServiceBean.listarEventos(
					null, 
					new Date(), 
					new Date()
					).isEmpty()
				);
	}
	
	@Test
	public void deveRetornarListaVaziaQuandoDataInicialNula() {
		assertTrue(
			agendaServiceBean.listarEventos(
					new Colaborador(), 
					null, 
					new Date()
					).isEmpty()
				);
	}
	
	@Test
	public void deveRetornarListaVaziaQuandoDataFinalNula() {
		assertTrue(
			agendaServiceBean.listarEventos(
					new Colaborador(), 
					new Date(), 
					null)
					.isEmpty()
				);
	}
	
	@Test
	public void deveRetornarListaVaziaQuandoColaboradorNaoCadastrado() {
		
		Colaborador colaborador = new Colaborador();
		
		when(
			enventoDao.localizar(Colaborador.class , colaborador)
			).thenReturn(null);
		
		assertTrue(
			agendaServiceBean.listarEventos(
					colaborador, 
					new Date(), 
					new Date()
					).isEmpty()
				);
	}
	
	
	@Test
	public void deveRetornarListaQuandoColaboradorCadastrado() {
		
		Colaborador colaborador = new Colaborador();
		
		when(
			enventoDao.localizar(Colaborador.class, colaborador)
			).thenReturn(new Colaborador());
		
		List<Evento> eventos = new ArrayList<Evento>();
		eventos.add(new Evento());
		
		when(
			enventoDao.getEventos(colaborador, new Date(), new Date())
			).thenReturn(eventos);
		
		assertTrue(
			!agendaServiceBean.listarEventos(
					colaborador, 
					new Date(), 
					new Date()
					).isEmpty()
			);
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
