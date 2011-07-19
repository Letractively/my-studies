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

import br.com.lawoffice.dominio.Cliente;
import br.com.lawoffice.dominio.Colaborador;
import br.com.lawoffice.persistencia.ClienteDao;
import br.com.lawoffice.persistencia.ColaboradorDao;
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


	@Mock
	private ColaboradorDao colaboradorDao;

	@Mock
	private ClienteDao clienteDao;
	
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
	public void deveDispararUmaExceçãoQuandoColaboradorNulaExtratoColaborador() {
		extratoServiceBean.getExtratoColaborador(new Date(), new Date(), null);
	}	
	
	
	
	
	@Test(expected=IllegalArgumentException.class)
	public void deveDispararUmaExceçãoQuandoColaboradorSemIDExtratoColaborador() {
		extratoServiceBean.getExtratoColaborador(new Date(), new Date(), new Colaborador());
	}	
	
	
	@Test(expected=IllegalArgumentException.class)
	public void deveDispararUmaExceçãoQuandoDataInicialNulaExtratoCliente() {
		extratoServiceBean.getExtratoCliente(null, new Date(), new Cliente());
	}

	

	@Test(expected=IllegalArgumentException.class)
	public void deveDispararUmaExceçãoQuandoDataFinalNulaExtratoCliente() {
		extratoServiceBean.getExtratoCliente(new Date(), null, new Cliente());
	}	

	
	
	@Test(expected=IllegalArgumentException.class)
	public void deveDispararUmaExceçãoQuandoClienteNuloExtratoCliente() {
		extratoServiceBean.getExtratoCliente(new Date(), new Date(), null);
	}	
	
	
	
	@Test(expected=IllegalArgumentException.class)
	public void deveDispararUmaExceçãoQuandoClienteSemIDExtratoCliente() {
		extratoServiceBean.getExtratoCliente(new Date(), new Date(), new Cliente());
	}
	
	
	
	
	
	
	@Test()
	public void deveRetornaNullQuandoColaboradorNaoCadastrado() {

		
		Colaborador colaborador = new Colaborador();
		colaborador.setId(1L);
		
	
		when( 
			colaboradorDao.localizar(Colaborador.class, colaborador)
		).thenReturn(null);
		
		
		ExtratoDTO extratoDTO = 
			extratoServiceBean.getExtratoColaborador(
					new Date(), 
					new Date(), 
					colaborador
			);
				
		
		assertNull(extratoDTO);		
	}
	
	
	@Test()
	public void deveRetornaNullQuandoClienteNaoCadastrado() {

		
		Cliente cliente = new Cliente();
		cliente.setId(1L);
		
	
		when( 
			clienteDao.localizar(Cliente.class, cliente)
		).thenReturn(null);
		
		
		ExtratoDTO extratoDTO = 
			extratoServiceBean.getExtratoCliente(
					new Date(), 
					new Date(), 
					cliente
			);
				
		
		assertNull(extratoDTO);		
	}	
	
	
	
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
