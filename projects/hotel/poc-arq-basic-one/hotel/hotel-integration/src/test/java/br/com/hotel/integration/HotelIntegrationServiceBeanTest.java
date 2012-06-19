package br.com.hotel.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import br.com.hotel.domain.Hotel;
import br.com.hotel.integration.api.BrokenFilter;
import br.com.hotel.integration.api.Broker;

public class HotelIntegrationServiceBeanTest {


	@InjectMocks
	private HotelIntegrationServiceBean hotelIntegrationServiceBean;


	@Mock
	private BrokenService brokenService;


	@Before
	public void setUp() throws Exception {
		hotelIntegrationServiceBean = new HotelIntegrationServiceBean();
		initMocks(this);
	}



	@After
	public void tearDown() throws Exception {
		hotelIntegrationServiceBean = null;
		reset(brokenService);
	}































	@Test
	public void shouldReturnListOfHotels() {

		List<Broker> brokers = new ArrayList<>();

		Broker broker1 = mock(Broker.class);
		Broker broker2 = mock(Broker.class);

		brokers.add(broker1);
		brokers.add(broker2);

		List<Hotel> hotelsBroker1 = new ArrayList<>();
		hotelsBroker1.add(new Hotel("broker1-hotel1", 3));
		hotelsBroker1.add(new Hotel("broker1-hotel2", 1));
		hotelsBroker1.add(new Hotel("broker1-hotel3", 3));
		hotelsBroker1.add(new Hotel("broker1-hotel4", 5));


		List<Hotel> hotelsBroker2 = new ArrayList<>();
		hotelsBroker1.add(new Hotel("broker2-hotel1", 3));
		hotelsBroker1.add(new Hotel("broker2-hotel2", 1));
		hotelsBroker1.add(new Hotel("broker2-hotel3", 3));
		hotelsBroker1.add(new Hotel("broker2-hotel4", 5));


		// TODO: em relação ao broken filter no momento pode ser qualquer um
		// pelo fato de se trata de uma poc de arquitetura e nao temos nada
		// definido ainda em relacao aos parametros de consulta nos brokens..
		when(broker1.getHotels(any(BrokenFilter.class))).thenReturn(hotelsBroker1);
		when(broker2.getHotels(any(BrokenFilter.class))).thenReturn(hotelsBroker2);


		// TODO: no momento iremos apenas utilizar o pais como região
		// para obter os brokers
		when(brokenService.getBrokers(new Region("Brasil"))).thenReturn(brokers);


		List<Hotel> hotels =
				hotelIntegrationServiceBean.getHotels( new HotelIntegrationFilter(3, "Brasil") ); // only hotels 3 stars


        verify(brokenService).getBrokers(new Region("Brasil"));
        verify(broker1).getHotels(any(BrokenFilter.class));
        verify(broker2).getHotels(any(BrokenFilter.class));


		assertNotNull(hotels);
		assertEquals(4, hotels.size());
		assertEquals("broker1-hotel1", hotels.get(0).getName());
		assertEquals("broker1-hotel3", hotels.get(1).getName());
		assertEquals("broker2-hotel1", hotels.get(2).getName());
		assertEquals("broker2-hotel3", hotels.get(3).getName());

	}



















}
