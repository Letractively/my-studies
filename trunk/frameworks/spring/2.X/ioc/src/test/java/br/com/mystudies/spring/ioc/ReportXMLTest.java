/**
 * 
 */
package br.com.mystudies.spring.ioc;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author rduarte
 *
 */
public class ReportXMLTest {

	
	private Report reportTest;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		reportTest = new ReportXML();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		reportTest = null;
	}

	/**
	 * Test method for {@link br.com.mystudies.spring.ioc.ReportXML#getReport()}.
	 */
	@Test
	public void testGetReport() {
		assertNotNull(reportTest.getReport());
	}

}
