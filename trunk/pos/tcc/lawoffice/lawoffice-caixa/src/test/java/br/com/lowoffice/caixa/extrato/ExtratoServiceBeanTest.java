package br.com.lowoffice.caixa.extrato;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


import java.util.Calendar;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.lawoffice.dominio.Colaborador;
import br.com.lawoffice.persistencia.HistoricoContaDao;
import br.com.lawoffice.persistencia.PessoaDao;

/**
 * 
 * Classe de teste de unidade para o {@link ExtratoServiceBean}.
 * 
 * @author rduarte
 *
 */
public class ExtratoServiceBeanTest {


	
	@InjectMocks
	private ExtratoServiceBean extratoServiceBean;
	
	
	@Before
	public void setUp() throws Exception {
		extratoServiceBean = new ExtratoServiceBean();
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
		extratoServiceBean  = null;
	}

	
	
	@Test(expected=IllegalArgumentException.class)
	public void deveDispararUmaExceçãoQuandoDataInicialNulaExtratoColaborador() {
		extratoServiceBean.getExtratoColaborador(null, new Date(), new Colaborador());
	}

	
	
	@Test(expected=IllegalArgumentException.class)
	public void deveDispararUmaExceçãoQuandoDataFinalNulaExtratoColaborador() {
		extratoServiceBean.getExtratoColaborador(new Date(), null, new Colaborador());
	}	
	

	
	
	@Test(expected=IllegalArgumentException.class)
	public void deveDispararUmaExceçãoQuandoPessoaNulaExtratoColaborador() {
		extratoServiceBean.getExtratoColaborador(new Date(), new Date(), null);
	}	
	
	
	
	
	@Test(expected=IllegalArgumentException.class)
	public void deveDispararUmaExceçãoQuandoColaboradorSemIDExtratoColaborador() {
		extratoServiceBean.getExtratoColaborador(new Date(), new Date(), new Colaborador());
	}	
	

	
	
	
	
	/*
	
	@Test()
	public void deveRetornaNullQuandoPessoaNaoCadastrada() {

		
		Colaborador colaborador = new Colaborador();
		colaborador.setId(1L);
		
	
		when( 
			pessoaDao.localizar(Colaborador.class, colaborador)
		).thenReturn(null);
		
		
		ExtratoDTO extratoDTO = 
				extratoServiceBean.getExtrato(
						new Date(), 
						new Date(), 
						colaborador
				);
				
		
		assertNull(extratoDTO);		
	}	*/
	
	
	
/*	@Test()
	public void deveRetornaUmExtratoDTOQuandoParametrosValidos() {

		
		// pessoa para ser pesquisada
		Colaborador colaboradorPesquisa = new Colaborador();
		colaboradorPesquisa.setId(1L);
		

		// pessoa para retorno 		
		Colaborador colaboradorRetorno
		
		
		
		// data inicial para consulta.
		Calendar calendar = Calendar.getInstance();		
		Date dataInicial = calendar.getTime();
				
		// data final para consulta.
		calendar.add(Calendar.DAY_OF_MONTH, 1);		
		Date dataFinal = calendar.getTime();
		
		
	
		when( pessoaDao.localizar(Colaborador.class, colaboradorPesquisa)).thenReturn(value);
		
		
		
		
		ExtratoDTO extratoDTO = 
				extratoServiceBean.getExtrato(dataInicial, dataFinal, colaboradorPesquisa);
		
		
		
		assertNotNull(extratoDTO);		
		assertEquals(dataInicial, extratoDTO.getDataInicial());
		assertEquals(dataFinal, extratoDTO.getDataFinal());
		assertEquals("Robson Oliveira Duarte", extratoDTO.getNomePessoa());
		assertEquals(expected, actual)
	}	*/
	
	
	
	
	@Test
	public void testGerarExtrato() {
		fail("Not yet implemented");
	}
	

}
