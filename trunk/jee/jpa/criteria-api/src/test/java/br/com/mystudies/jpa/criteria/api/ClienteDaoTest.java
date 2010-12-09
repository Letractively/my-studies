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
		
		Endereco enderecoRobson = new Endereco();
		enderecoRobson.setLogradouro("Rua mário Calazans Machado");
		enderecoRobson.setNumero(96);
		enderecoRobson.setCep("03589070");
		
		robsonCliente.setEndereco(enderecoRobson);

		
		Cliente anaMaraCliente = new Cliente();
		anaMaraCliente.setNome("Ana mara simões");
		anaMaraCliente.setIdade(35);
		anaMaraCliente.setEmail("anamara@gmail.com");
		
		Endereco enderecoAnaMara = new Endereco();
		enderecoAnaMara.setLogradouro("Rua Ponche Verde");
		enderecoAnaMara.setNumero(103);
		enderecoAnaMara.setCep("03589071");
		
		anaMaraCliente.setEndereco(enderecoAnaMara);		
		
		Cliente cibeleCliente = new Cliente();
		cibeleCliente.setNome("Cibele Oliveira Duarte");
		cibeleCliente.setIdade(25);
		cibeleCliente.setEmail("cibele@gmail.com");	
		
		Endereco enderecoCibele = new Endereco();
		enderecoCibele.setLogradouro("Rua Gil de Siqueira");
		enderecoCibele.setNumero(122);
		enderecoCibele.setCep("01245789");
		
		cibeleCliente.setEndereco(enderecoCibele);		
		
		
		entityManager.getTransaction().begin();
		entityManager.persist(robsonCliente);
		entityManager.persist(anaMaraCliente);
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
			clienteDaoTest.selecionarTodosClientePelaIdadeEntre(30,35);
		assertNotNull(listaClientes);
		assertEquals(2, listaClientes.size());
	}
	
	
	@Test
	public void deveSelecionarTodosClientePeloNumeroEnderecoEntre(){
		List<Cliente> listaClientes=
			clienteDaoTest.selecionarTodosClientePeloNumeroEnderecoEntre(50,100);
		assertNotNull(listaClientes);
	}
	
	@Test
	public void deveSelecionarClientePorNomeIdade(){
		Cliente clienteRobson =
			 clienteDaoTest.selecionarClientePorNomeIdade("Robson Oliveira Duarte", 34);
		assertNotNull(clienteRobson);
		assertEquals("Robson Oliveira Duarte", clienteRobson.getNome());
		assertEquals(new Integer(34), clienteRobson.getIdade());
	}

}
