package br.com.fiapfuncionarios.gerenciamento;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.fiapfuncionarios.dominio.Funcionario;

public class GerenciadorDeFuncionarioBeanTest {

	
	GerenciadorDeFuncionarioBean gerenciadorDeFuncionarioBeanTest;
	
	@Before
	public void setUp() throws Exception {
		gerenciadorDeFuncionarioBeanTest = new GerenciadorDeFuncionarioBean();
	}

	@After
	public void tearDown() throws Exception {
		gerenciadorDeFuncionarioBeanTest = null;
	}

	@Test
	public void testRemoverFuncionarioNull() {
		Exception ex = null;
		try {
			gerenciadorDeFuncionarioBeanTest.Remover(null);
		} catch (Exception e) {
			ex = e;
		}
		assertNotNull(ex);
	}
	
	@Test
	public void testRemoverFuncionarioIDNull() {
		Exception ex = null;
		try {
			gerenciadorDeFuncionarioBeanTest.Remover(new Funcionario());
		} catch (Exception e) {
			ex = e;
		}
		assertNotNull(ex);
	}	

	@Test
	public void testGetFuncionarioPromocao() {
	}

	
	@Test
	public void testCadastrarFuncionarioNull(){
		Exception ex =  null;
		try {
			gerenciadorDeFuncionarioBeanTest.cadastrar(null);
		} catch (Exception e) {
			ex = e;
		}		
		assertNotNull(ex);
	}
}
