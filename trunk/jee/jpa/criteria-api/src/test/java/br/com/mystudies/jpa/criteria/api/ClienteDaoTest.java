package br.com.mystudies.jpa.criteria.api;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ClienteDaoTest {

	
	private static EntityManager entityManager;
	
	private ClienteDao clienteDaoTest;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		entityManager = 
			Persistence
			.createEntityManagerFactory("criteria-api")
			.createEntityManager();
		
		
		Cliente robsonCliente = new Cliente();
		robsonCliente.setNome("Robson Oliveira Duarte");
		robsonCliente.setIdade(34);
		robsonCliente.setEmail("robson.o.d@gmail.com");

		
		Cliente anamaraCliente = new Cliente();
		anamaraCliente.setNome("Ana mara simões");
		anamaraCliente.setIdade(35);
		anamaraCliente.setEmail("anamara@gmail.com");
		
		Cliente cibeleCliente = new Cliente();
		cibeleCliente.setNome("Cibele Oliveira Duarte");
		cibeleCliente.setIdade(25);
		cibeleCliente.setEmail("cibele@gmail.com");		
		
		
		entityManager.getTransaction().begin();
		entityManager.persist(robsonCliente);
		entityManager.persist(anamaraCliente);
		entityManager.persist(cibeleCliente);
		entityManager.getTransaction().commit();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception{
		entityManager.close();
	}

	@Before
	public void setUp() throws Exception {
		clienteDaoTest = new ClienteDao();
		clienteDaoTest.setEntityManager(entityManager);
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void deveSelecionarTodosCliente(){
		List<Cliente> listaClientes = 
			clienteDaoTest.selecionarTodosCliente();
		assertNotNull(listaClientes);
		assertEquals(3, listaClientes.size());
	}

	@Test
	public void deveSelecionarClientePorNome(){
		Cliente robsonCliente = 
			clienteDaoTest.selecionarClientePorNome("Robson Oliveira Duarte");
		assertNotNull(robsonCliente);
		assertEquals("Robson Oliveira Duarte", robsonCliente.getNome());
		assertEquals(new Integer(34), robsonCliente.getIdade());
		assertEquals("robson.o.d@gmail.com", robsonCliente.getEmail());
	}
	
	
	@Test
	public void deveSelecionarTodosClientePelaIdadeEntre(){
		List<Cliente> listaClientes =
			clienteDaoTest.deveSelecionarTodosClientePelaIdadeEntre(30,35);
		assertNotNull(listaClientes);
	}

}
