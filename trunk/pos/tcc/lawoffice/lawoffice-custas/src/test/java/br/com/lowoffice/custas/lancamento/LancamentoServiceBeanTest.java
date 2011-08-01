package br.com.lowoffice.custas.lancamento;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.lawoffice.caixa.CaixaService;
import br.com.lawoffice.caixa.CaixaServiceLocal;
import br.com.lawoffice.dominio.Cliente;
import br.com.lawoffice.dominio.Colaborador;
import br.com.lawoffice.dominio.Custa;
import br.com.lawoffice.persistencia.PessoaDao;

/**
 * 
 * Teste de unidade para o {@link LancamentoServiceBean}
 * 
 * @author robson
 *
 */
public class LancamentoServiceBeanTest {

	
	
	@Mock
	private CaixaService caixaService ;
	

	@Mock
	private PessoaDao pessoaDao;
	
	
	@InjectMocks
	private LancamentoServiceBean lacamentoServiceBean;
	
	

	@Before
	public void setUp() throws Exception {
		lacamentoServiceBean = new LancamentoServiceBean();
		MockitoAnnotations.initMocks(this);
	}

	
	
	@After
	public void tearDown() throws Exception{
		reset(caixaService);
	}	
	
	

	@Test(expected=IllegalArgumentException.class)
	public void deveDispararUmaExcecaoQuandoCustaNula(){
		assertNotNull( 
			lacamentoServiceBean.adicionarCusta(
					null, 
					new Cliente(), 
					new Colaborador(),
					new Date()
				)
			);
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void deveDispararUmaExcecaoQuandoClienteNulo(){
		assertNotNull( 
			lacamentoServiceBean.adicionarCusta(
					new Custa(), 
					null, 
					new Colaborador(),
					new Date()
				)
			);
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void deveDispararUmaExcecaoQuandoClienteIDNulo(){
		
		Cliente cliente = new Cliente();
		
		
		assertNotNull( 
			lacamentoServiceBean.adicionarCusta(
					new Custa(), 
					cliente, 
					new Colaborador(),
					new Date()
				)
			);
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void deveDispararUmaExcecaoQuandoClienteNaoEncontrado(){
		
		Cliente cliente = new Cliente();
		cliente.setId(1l);
		
		
		when(
			pessoaDao.localizar(Cliente.class, cliente)
		).thenReturn(null);
		
		
		assertNotNull( 
			lacamentoServiceBean.adicionarCusta(
					new Custa(), 
					cliente, 
					new Colaborador(),
					new Date()
				)
			);
	}	
	
	
	
	@Test(expected=IllegalArgumentException.class)
	public void deveDispararUmaExcecaoQuandoColaboradorNulo(){
		
		// dados para passar na regra de validação do cliente
		Cliente cliente = new Cliente();
		cliente.setId(1L);
		
		when(
				pessoaDao.localizar(Cliente.class, cliente)
			).thenReturn(cliente);		
		
		
		assertNotNull( 
			lacamentoServiceBean.adicionarCusta(
					new Custa(), 
					cliente, 
					null,
					new Date()
				)
			);
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void deveDispararUmaExcecaoQuandoColaboradorIDNulo(){
		
		// dados para passar na regra de validação do cliente
		Cliente cliente = new Cliente();
		cliente.setId(1L);
		
		when(
				pessoaDao.localizar(Cliente.class, cliente)
			).thenReturn(cliente);
		
		
		assertNotNull( 
			lacamentoServiceBean.adicionarCusta(
					new Custa(), 
					cliente, 
					new Colaborador(),
					new Date()
				)
			);
	}
	
	
	
	
	@Test(expected=IllegalArgumentException.class)
	public void deveDispararUmaExcecaoQuandoColaboradorNaoEncontrado(){
		
		// dados para passar na regra de validação do cliente
		Cliente cliente = new Cliente();
		cliente.setId(1L);
		
		when(
				pessoaDao.localizar(Cliente.class, cliente)
			).thenReturn(cliente);
		
		// dados do colaborador
		Colaborador colaborador = new Colaborador();
		colaborador.setId(1l);
		
		
		when(
			pessoaDao.localizar(Colaborador.class, colaborador)
		).thenReturn(null);
		
		
		assertNotNull( 
			lacamentoServiceBean.adicionarCusta(
					new Custa(), 
					cliente,
					colaborador,
					new Date()
				)
			);
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void deveDispararUmaExcecaoQuandoDataNula(){
		
		// dados para passar na regra de validação do cliente
		Cliente cliente = new Cliente();
		cliente.setId(1L);
		
		when(
				pessoaDao.localizar(Cliente.class, cliente)
			).thenReturn(cliente);
		
		// dados para passar na regra de vailidação do colaborador
		Colaborador colaborador = new Colaborador();
		colaborador.setId(1l);
		
		
		when(
			pessoaDao.localizar(Colaborador.class, colaborador)
		).thenReturn(colaborador);
		
		
		assertNotNull( 
			lacamentoServiceBean.adicionarCusta(
					new Custa(), 
					cliente,
					colaborador,
					null
				)
			);
	}	
	
	
	
	

	@Test
	public void deveRetornaUmaCustaQuandoParmentrosValidos(){
		// dados para passar na regra de validação do cliente
		Cliente cliente = new Cliente();
		cliente.setId(1L);
		
		when(
				pessoaDao.localizar(Cliente.class, cliente)
			).thenReturn(cliente);
		
		// dados para passar na regra de vailidação do colaborador
		Colaborador colaborador = new Colaborador();
		colaborador.setId(1l);
		
		
		when(
			pessoaDao.localizar(Colaborador.class, colaborador)
		).thenReturn(colaborador);
		
		
		assertNotNull( 
			lacamentoServiceBean.adicionarCusta(
					new Custa(), 
					cliente, 
					colaborador,
					new Date()
				)
			);		

	}

	
	
		
	
	@Test
	public void deveRetornaUmaCustaComLancamentoQuandoParmentrosValidos(){
		
		// dados para passar na regra de validação do cliente
		Cliente cliente = new Cliente();
		cliente.setId(1L);
		
		when(
				pessoaDao.localizar(Cliente.class, cliente)
			).thenReturn(cliente);
		
		// dados para passar na regra de vailidação do colaborador
		Colaborador colaborador = new Colaborador();
		colaborador.setId(1l);
		
		
		when(
			pessoaDao.localizar(Colaborador.class, colaborador)
		).thenReturn(colaborador);
		
		
		assertNotNull( 
			lacamentoServiceBean.adicionarCusta(
					new Custa(), 
					cliente, 
					colaborador,
					new Date()
				).getLancamento()
			);
	}
	
	
	
	
			
	/**
	 * 
	 * Deve adicionar uma custa a um lancamento ja criado para o cliente, colaborador e data passados. 
	 * 
	 */
	@Test
	public void deveAdicionarCustaNoMesmoLancamento(){
		
		// dados para passar na regra de validação do cliente
		Cliente cliente = new Cliente();
		cliente.setId(1L);
		
		when(
				pessoaDao.localizar(Cliente.class, cliente)
			).thenReturn(cliente);
		
		// dados para passar na regra de vailidação do colaborador
		Colaborador colaborador = new Colaborador();
		colaborador.setId(1l);
		
		
		when(
				pessoaDao.localizar(Colaborador.class, colaborador)
			).thenReturn(colaborador);
		
		Date date = new Date();
		
		
		assertSame(
			lacamentoServiceBean.adicionarCusta(
				new Custa(), 
				cliente, 
				colaborador,
				date).getLancamento(), 
			lacamentoServiceBean.adicionarCusta(
				new Custa(), 
				cliente,
				colaborador,
				date).getLancamento()
		);
	}
	
	
	/*
	
	@Test
	public void testAdicionarCustaChaveClienteColaboradorDiferente(){
		
		Cliente cliente1 = new Cliente();
		cliente1.setId(1l);
		
		Cliente cliente2 = new Cliente();
		cliente2.setId(2l);		
		
		Colaborador colaborador1 = new Colaborador();
		colaborador1.setId(1l);
		
		Colaborador colaborador2 = new Colaborador();
		colaborador2.setId(1l);
		
		
		assertNotSame(
				lacamentoServiceBean.adicionarCusta(
					new Custa(),  
					cliente1, 
					colaborador1).getLancamento(), 
				lacamentoServiceBean.adicionarCusta(
					new Custa(), 
					cliente2,
					colaborador2).getLancamento()
			);
	}
	
	
	
	
	@Test
	public void testAdicionarCustaGetTotalLancamento(){
		
		Cliente cliente = new Cliente();
		Colaborador colaborador = new Colaborador();
		
		Custa custa1 = new Custa();
		custa1.setValor(new BigDecimal(22.00));
		
		Custa custa2 = new Custa();
		custa2.setValor(new BigDecimal(10.00));
		
		
		// add custa 1
		lacamentoServiceBean.adicionarCusta(
				custa1,  
				cliente, 
				colaborador
		);
		
		// add custa 2 no mesmo lançamento		
		assertEquals(
			new BigDecimal(32.00), 
			lacamentoServiceBean.adicionarCusta(
					custa2,  
					cliente, 
					colaborador
				).getLancamento().getTotal()
		);
		
		
	}*/
	
	
	
/*	
	//TODO: renomear testes para o padrão devefazeralgumacoias.....
	@Test(expected=LancamentoDeCustaException.class)
	public void testFecharLacamentoSemLacamentosAFechar() throws LancamentoDeCustaException{		
		lacamentoServiceBean.fecharLacamento();
	}

	
	
	@Test(expected=IllegalArgumentException.class)
	public void deveDispararUmaExcecaoQuandoRemoverCustaNula() throws LancamentoDeCustaException{
		lacamentoServiceBean.removerCusta(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deveDispararUmaExcecaoQuandoRemoverCustaSemLancamento() throws LancamentoDeCustaException{
		lacamentoServiceBean.removerCusta(new Custa());
	}
	
	@Test(expected=LancamentoDeCustaException.class)
	public void deveDispararUmaExcecaoQuandoRemoverCustaEOLancamentoNaoEncontratoNaSessao() throws LancamentoDeCustaException{
		lcTest.removerCusta(new Custa().addLancamento(new Lancamento()));
	}
	
	
	
	@Test()
	public void deveRemoverACustaPassada() throws LancamentoDeCustaException{
		
		// add a custa
		Custa custa = lacamentoServiceBean.adicionarCusta(
				new Custa(), 
				new Cliente(), 
				new Colaborador()
			);
		
		// removendo a custa do lançamento
		lacamentoServiceBean.removerCusta(custa);
		 
		// lançamento sem custas
		assertEquals(0, custa.getLancamento().getCustas().size());
	}*/
	
	
	
/*	@Test(expected=IllegalArgumentException.class)
	public void deveDispararUmaExcecaoQuandoAtualizarCustaNula() throws LancamentoDeCustaException{
		lcTest.atualizarCusta(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deveDispararUmaExcecaoQuandoAtulizarCustaSemLancamento() throws LancamentoDeCustaException{
		lcTest.atualizarCusta(new Custa());
	}

	@Test(expected=LancamentoDeCustaException.class)
	public void deveDispararUmaExcecaoQuandoAtualizarCustaEOLancamentoNaoEncontratoNaSessao() throws LancamentoDeCustaException{
		lcTest.atualizarCusta(new Custa().addLancamento(new Lancamento()));
	}	
	
	@Test()
	public void deveAtualizarACustaPassada() throws LancamentoDeCustaException{
		
		
		Custa custa = new Custa();  
			
		custa.setNatureza("Natureza");
		custa.setValor(new BigDecimal(10));
		
			
		// add a custa
		 custa = lcTest.adicionarCusta(
				custa, 
				new Cliente(), 
				new Colaborador()
			);
		
		// novos valores ...
		 custa.setNatureza("Nova Natureza");
		 custa.setValor(new BigDecimal(11));
		 
         custa = lcTest.atualizarCusta(custa);
         
         assertEquals("Nova Natureza", custa.getNatureza());
         assertEquals(new BigDecimal(11), custa.getValor());
         
	}*/	
	
	
/*	@Test(expected=LacamentoDeCustaException.class)
	public void testFecharLacamentoComLacamentos() throws LacamentoDeCustaException{
		
		
		// FIXME: devido a falta de validação ( débito  técnico beans validation )
		// está disparando um nullpoi... quando pega o total do lançamento
		// e a custa não tem valor .. isso deve ser corrigido ao add as validações
		// portanto para esse teste nesse momento add o cara abaixo
		// assim que as validações forem add remover o cara e rodar o teste
		Custa custa = new Custa();
		custa.setValor(new BigDecimal(20.0));
		
		
			
			lcTest.adicionarCusta(
					custa,
					new Cliente(), 
					new Colaborador()
				);
							
			lcTest.setCaixa(caixaMock);
			lcTest.setEntityManager(entityManagerMock);
			lcTest.fecharLacamento();

			// chamada para verificar se realmente
			// ocorreu a limpeza dos lançamentos
			// após realizar o fechamento
			lcTest.fecharLacamento();
	}*/
	

}
