package br.com.mystudies.jaxws;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WebServiceTest {

	private WebService webService;

	@Before
	public void setUp() throws Exception {
		webService = new WebService();
	}

	@After
	public void tearDown() throws Exception {
		webService = null;
	}

	@Test
	public void test() {
		String s = webService.operation("Robson");
		assertEquals("hello, Robson", s);
	}

}
