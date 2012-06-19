package br.com.hotel.broker.two;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.hotel.domain.Hotel;
import br.com.hotel.integration.api.BrokenFilter;

public class BrokerTwoServiceBeanTest {


	private BrokerTwoServiceBean brokerTwoServiceBean;


	@Before
	public void setUp() throws Exception {
		brokerTwoServiceBean = new BrokerTwoServiceBean();
	}

	@After
	public void tearDown() throws Exception {
		brokerTwoServiceBean = null;
	}

	@Test
	public void shouldReturnListOfHotels() {

		List<Hotel> hotels =
				brokerTwoServiceBean.getHotels(new BrokenFilter());

		assertNotNull(hotels);
	}

}
