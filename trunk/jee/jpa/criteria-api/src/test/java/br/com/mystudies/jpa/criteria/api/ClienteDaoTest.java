/**
 * 
 */
package br.com.mystudies.jpa.criteria.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author rduarte
 *
 */
public class ClienteDaoTest {

	private ClienteDao clienteDaoTest;
	
	private EntityManager entityManagerMock;
	
	private CriteriaBuilder criteriaBuilderMock;
	
	private CriteriaQuery<Cliente> criteriaQueryMock;
	
	private TypedQuery<Cliente> typedQueryMock;
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception{
		clienteDaoTest = new ClienteDao();
		entityManagerMock = mock(EntityManager.class);
		criteriaBuilderMock = mock(CriteriaBuilder.class);
		criteriaQueryMock = mock(CriteriaQuery.class);
		typedQueryMock = mock(TypedQuery.class);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		clienteDaoTest = null;
		reset(entityManagerMock);
		reset(criteriaBuilderMock);
	}

	/**
	 * Test method for {@link br.com.mystudies.jpa.criteria.api.ClienteDao#selecionarTodosCliente()}.
	 */
	@Test
	public void testSelecionarTodosCliente() {
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(new Cliente());
		clientes.add(new Cliente());
		
		
		// preparando os mocks
		when(entityManagerMock.getCriteriaBuilder()).thenReturn(criteriaBuilderMock);
		when(criteriaBuilderMock.createQuery(Cliente.class)).thenReturn(criteriaQueryMock);
		when(entityManagerMock.createQuery(criteriaQueryMock)).thenReturn(typedQueryMock);
		when(typedQueryMock.getResultList()).thenReturn(clientes);
		
		
		
		clienteDaoTest.setEntityManager(entityManagerMock);
		
		assertNotNull(clientes);
		assertEquals(2,clientes.size());
	}

}
