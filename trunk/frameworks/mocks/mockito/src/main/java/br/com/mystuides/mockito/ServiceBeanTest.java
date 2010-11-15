/**
 * 
 */
package br.com.mystuides.mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.ExactComparisonCriteria;

/**
 * @author robson
 *
 */
public class ServiceBeanTest {


	private ServiceBean serviceTest;
	
	private Dao dao = mock(Dao.class);
	
	@Before
	public void setUp() throws Exception {
		serviceTest = new ServiceBean();
	}

	@After
	public void tearDown() throws Exception {
		serviceTest = null;
		reset(dao);
	}


	@Test(expected=IllegalArgumentException.class)
	public void testWhitStringNull() {
		serviceTest.operation(null);
	}
	
	@Test()
	public void testWhitStringNotNull(){
		when(dao.find("teste"))
			.thenReturn("teste");
		serviceTest.setDao(dao);
		assertNotNull(serviceTest.operation("teste"));
	}
	
	
	@Test(expected=Exception.class)
	public void testWhitDaoTrowingException(){				
		doThrow(new Exception())
			.when(dao)
			.find("teste");
		serviceTest.setDao(dao);serviceTest.operation("teste");
	}	

}
