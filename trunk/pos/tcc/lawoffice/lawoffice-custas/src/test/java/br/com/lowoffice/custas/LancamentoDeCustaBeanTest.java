package br.com.lowoffice.custas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.lawoffice.dominio.Cliente;
import br.com.lawoffice.dominio.Colaborador;
import br.com.lawoffice.dominio.Custa;

public class LancamentoDeCustaBeanTest {

	
	private LancamentoDeCusta lcTest;
	
	
	@Before
	public void setUp() throws Exception {
		lcTest = new LancamentoDeCustaBean();
	}


	@Test
	public void testAdicionarCustaNotNullReturnCusta(){
		assertNotNull( 
			lcTest.adicionarCusta(
					new Custa(), 
					new Cliente(), 
					new Colaborador()
				).getLancamento()
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
	public void testFecharLacamento() {
		//fail("Not yet implemented");
	}

}
