/**
 * 
 */
package br.com.lowoffice.custas;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * Teste de unidade para a classe {@link CustasBean}
 * 
 * @author robson
 *
 */
public class CustasBeanTest {

	
	private CustasBean custasBeanTest;
	
	@Before
	public void setUp() throws Exception {
		custasBeanTest = new CustasBean();
	}


	@After
	public void tearDown() throws Exception{
		custasBeanTest = null;
	}


	@Test(expected=IllegalArgumentException.class)
	public void testGetCustasComMapsNullo() {
		custasBeanTest.getCustas(null);
	}
	
	
	@Test()
	public void testGetCustasComMapsVazio() {
		assertEquals(
			0, 
			custasBeanTest.getCustas(new HashMap<String, Object>()).size()
		);
	}

}
