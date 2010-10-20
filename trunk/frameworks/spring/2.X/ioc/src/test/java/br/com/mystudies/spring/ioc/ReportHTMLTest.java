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
public class ReportHTMLTest {

	Report reportTest;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		reportTest = new ReportHTML();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		reportTest = null;
	}

	/**
	 * Test method for {@link br.com.mystudies.spring.ioc.ReportHTML#getReport()}.
	 */
	@Test
	public void testGetReport() {
		assertNotNull(reportTest.getReport());
	}

}
