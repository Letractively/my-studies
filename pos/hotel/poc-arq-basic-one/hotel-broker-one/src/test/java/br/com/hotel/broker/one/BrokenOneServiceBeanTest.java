package br.com.hotel.broker.one;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.hotel.domain.Hotel;
import br.com.hotel.integration.api.BrokenFilter;

public class BrokenOneServiceBeanTest {


	private BrokenOneServiceBean brokenOneServiceBean;


	@Before
	public void setUp() throws Exception {
		brokenOneServiceBean = new BrokenOneServiceBean();
	}


	@After
	public void tearDown() throws Exception {
		brokenOneServiceBean = null;
	}



	@Test
	public void shouldReturnListOfHotels() {

		List<Hotel> hotels =
				brokenOneServiceBean.getHotels(new BrokenFilter());

		assertNotNull(hotels);
	}


}
