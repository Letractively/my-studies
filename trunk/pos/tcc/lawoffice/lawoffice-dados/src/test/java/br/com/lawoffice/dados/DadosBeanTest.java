package br.com.lawoffice.dados;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.lawoffice.dominio.Cliente;

public class DadosBeanTest {

	
	private DadosBean dadosBean; 
	
	@Before
	public void setUp() throws Exception {
		dadosBean = new DadosBean();
	}

	@After
	public void tearDown() throws Exception {
		dadosBean = null;
	}

	@Test
	public void testAtualizar() {
		//fail("Not yet implemented");
	}

	@Test
	public void testRemover() {
		//fail("Not yet implemented");
	}

	@Test
	public void testLocalizar() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSalvar() {
		//fail("Not yet implemented");
	}

	@Test
	public void testListar(){
		assertNotNull(dadosBean.listar(Cliente.class) );
		//fail("Not yet implemented");
	}

}
