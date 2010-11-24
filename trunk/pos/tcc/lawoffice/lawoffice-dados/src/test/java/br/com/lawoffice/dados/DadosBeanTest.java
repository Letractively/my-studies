package br.com.lawoffice.dados;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.lawoffice.dominio.Cliente;

public class DadosBeanTest {

	
	private DadosBean dadosBean;
	
	private EntityManager entityManagerMock;
	
	private CriteriaBuilder criteriaBuilderMock;
	
	private CriteriaQuery<Cliente> criteriaQueryMock;
	
	private TypedQuery<Cliente> typedQueryMock;
	
	
	@Before
	public void setUp() throws Exception {
		dadosBean = new DadosBean();
		entityManagerMock = mock(EntityManager.class);
		criteriaBuilderMock = mock(CriteriaBuilder.class);
		criteriaQueryMock = mock(CriteriaQuery.class);
		typedQueryMock = mock(TypedQuery.class);		
	}

	@After
	public void tearDown() throws Exception {
		dadosBean = null;
		reset(entityManagerMock);
		reset(criteriaBuilderMock);
		reset(criteriaQueryMock);
		reset(typedQueryMock);		
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
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(new Cliente());
		clientes.add(new Cliente());
		
		// preparando os mocks
		when(entityManagerMock.getCriteriaBuilder()).thenReturn(criteriaBuilderMock);
		when(criteriaBuilderMock.createQuery(Cliente.class)).thenReturn(criteriaQueryMock);
		when(entityManagerMock.createQuery(criteriaQueryMock)).thenReturn(typedQueryMock);
		when(typedQueryMock.getResultList()).thenReturn(clientes);
		
		dadosBean.setEntityManager(entityManagerMock);
		
		assertNotNull(dadosBean.listar(Cliente.class));
		
		
		assertNotNull(clientes);
		assertEquals(2,clientes.size());
	}

}
