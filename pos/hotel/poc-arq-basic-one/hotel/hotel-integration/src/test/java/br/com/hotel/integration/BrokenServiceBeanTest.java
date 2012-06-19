package br.com.hotel.integration;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class BrokenServiceBeanTest {


	private BrokenServiceBean brokenServiceBean;


	@Before
	public void setUp() throws Exception {
		brokenServiceBean = new BrokenServiceBean();
	}


	@After
	public void tearDown() throws Exception {
		brokenServiceBean = null;
	}



	@Test
	@Ignore
	public void shouldReturnLisOfBrokenByRegion() {

/*		List<Broker> brokers =
				brokenServiceBean.getBrokers(new Region("Brasil"));*/

		//assertNotNull(brokers);

		// FIXME: debito tecnico com teste de unidade + lookup de ejb !!
	}

}
