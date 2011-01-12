package br.com.lowoffice.custas.lancamento;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.lawoffice.caixa.CaixaLocal;
import br.com.lawoffice.dominio.Cliente;
import br.com.lawoffice.dominio.Colaborador;
import br.com.lawoffice.dominio.Custa;
import br.com.lawoffice.dominio.Lancamento;
import br.com.lowoffice.custas.exception.LancamentoDeCustaException;
import br.com.lowoffice.custas.lancamento.LancamentoDeCustaBean;

/**
 * @author robson
 *
 */
public class LancamentoBeanTest {

	
	private LancamentoDeCustaBean lcTest;
	
	
	
	private CaixaLocal caixaMock = mock(CaixaLocal.class);
	

	private EntityManager entityManagerMock;
	
	
	@Before
	public void setUp() throws Exception {
		lcTest = new LancamentoDeCustaBean();
		// TODO: problemas para criar o mock do entintymanager
		// vamos aguardar novas versões nos repositorios da api de persistencia
		// e realizar estudos , agora preciso tocar o projeto ( 05/01/11 )
		/*entityManagerMock = mock(EntityManager.class);*/
	}

	
	@After
	public void tearDown() throws Exception{
		/*reset(entityManagerMock);*/
	}	
	
	
	
	/**
	 * TODO: ver com endo se java doc de teste é relevante o melhor o nomes dos métodos de teste 
	 */
	@Test
	public void testAdicionarCustaNotNullReturnCusta(){
		assertNotNull( 
			lcTest.adicionarCusta(
					new Custa(), 
					new Cliente(), 
					new Colaborador()
				)
			);
	}
	
	@Test
	public void testAdicionarCustaNotNullLacamento(){
		assertNotNull( 
			lcTest.adicionarCusta(
					new Custa(), 
					new Cliente(), 
					new Colaborador()
				).getLancamento()
			);
	}
	
	
	@Test
	public void testAdicionarCustaChaveClienteColaboradorIguais(){
		
		Cliente cliente = new Cliente();
		Colaborador colaborador = new Colaborador(); 
		
		assertSame(
				lcTest.adicionarCusta(
					new Custa(), 
					cliente, 
					colaborador).getLancamento(), 
				lcTest.adicionarCusta(
					new Custa(), 
					cliente,
					colaborador).getLancamento()
			);
	}
	
	
	@Test
	public void testAdicionarCustaChaveClienteColaboradorDiferente(){
				
		assertNotSame(
				lcTest.adicionarCusta(
					new Custa(),  
					new Cliente(), 
					new Colaborador()).getLancamento(), 
				lcTest.adicionarCusta(
					new Custa(), 
					new Cliente(),
					new Colaborador()).getLancamento()
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
		lcTest.adicionarCusta(
				custa1,  
				cliente, 
				colaborador
		);
		
		// add custa 2 no mesmo lançamento		
		assertEquals(
			new BigDecimal(32.00), 
			lcTest.adicionarCusta(
					custa2,  
					cliente, 
					colaborador
				).getLancamento().getTotal()
		);
		
		
	}
	
	
	
	
	
	@Test(expected=LancamentoDeCustaException.class)
	public void testFecharLacamentoSemLacamentosAFechar() throws LancamentoDeCustaException{		
		lcTest.fecharLacamento();
	}

	
	
	@Test(expected=IllegalArgumentException.class)
	public void deveDispararUmaExcecaoQuandoCustaNula() throws LancamentoDeCustaException{
		lcTest.removerCusta(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deveDispararUmaExcecaoQuandoCustaNãoTiverLancamento() throws LancamentoDeCustaException{
		lcTest.removerCusta(new Custa());
	}
	
	@Test(expected=LancamentoDeCustaException.class)
	public void deveDispararUmaExcecaoQuandoOLancamentoNaoEncontratoNaSessao() throws LancamentoDeCustaException{
		lcTest.removerCusta(new Custa().addLancamento(new Lancamento()));
	}
	
	
	
	@Test()
	public void deveRemoverACustaPassada() throws LancamentoDeCustaException{
		
		// add a custa
		Custa custa = lcTest.adicionarCusta(
				new Custa(), 
				new Cliente(), 
				new Colaborador()
			);
		
		// removendo a custa do lançamento
		lcTest.removerCusta(custa);
		 
		// lançamento sem custas
		assertEquals(0, custa.getLancamento().getCustas().size());
	}
	
	
	
	
	
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
