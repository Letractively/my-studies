/**
 * 
 */
package br.com.lowoffice.custas;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.lawoffice.dominio.Custa;

/**
 * 
 * Teste de unidade para a classe {@link CustasBean}
 * 
 * @author robson
 *
 */
public class CustasBeanTest {

	
	private CustasBean custasBeanTest;
	
	private EntityManager entityManagerMock;
	
	private CriteriaBuilder criteriaBuilderMock;
	
	
	@Before
	public void setUp() throws Exception {
		custasBeanTest = new CustasBean();
		entityManagerMock = mock(EntityManager.class);
		criteriaBuilderMock = mock(CriteriaBuilder.class);
	}


	@After
	public void tearDown() throws Exception{
		custasBeanTest = null;
		reset(entityManagerMock);
		reset(criteriaBuilderMock);
	}


	@Test(expected=IllegalArgumentException.class)
	public void deveDispararUmaExcecaoRecebendoDataInicialNula() {
		custasBeanTest.getCustasPorDataCliente(null, new Date(), 1l);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deveDispararUmaExcecaoRecebendoDataFinalNula() {
		custasBeanTest.getCustasPorDataCliente(new Date(), null, 1l);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deveDispararUmaExcecaoRecebendoIDClineteNulo() {
		custasBeanTest.getCustasPorDataCliente(new Date(), new Date(), null);
	}
	
	
	// TODO: é o seguinte acho que vou der que dar uma mudada na arquitetura
		// adicioando uma camada dao ou add o hsqldb na parada, é extremamente horrivél mocar a api de crieteria
	  // do jpa 2.0.. como tenho que apresentar algo amanhã(10/12/2010) para o carlos
	 //  vou um um pouco de GHP.
	
/*	@Test()
	public void deveRetornaUmaListaDeCustas(){
		
		when(entityManagerMock.getCriteriaBuilder()).thenReturn(criteriaBuilderMock);
		
		custasBeanTest.
		
		List<Custa> custas = 
			custasBeanTest.getCustasPorDataCliente(new Date(), new Date(), 1l);
		
		
		
		assertNotNull(custas);
	}*/
		
}
