package br.com.hotel.integration;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.com.hotel.domain.Hotel;
import br.com.hotel.integration.api.BrokenFilter;
import br.com.hotel.integration.api.Broker;

@Stateless
@Remote(HotelIntegrationService.class)
public class HotelIntegrationServiceBean implements HotelIntegrationService {


	@EJB
	private BrokenService brokenService;


	@Override
	public List<Hotel> getHotels(HotelIntegrationFilter hotelIntegrationFilter) {

		List<Broker> brokers =
				brokenService.getBrokers(new Region(hotelIntegrationFilter.getDestino()));

		List<Hotel> hotels = new ArrayList<>();

		for (Broker broker : brokers) {

			List<Hotel> brokerHotels =
					broker.getHotels(new BrokenFilter());

			for (Hotel hotel : brokerHotels) {

				if(hotel.getStars() == hotelIntegrationFilter.getStars()){
					hotels.add(hotel);
				}
			}
		}

		return hotels;
	}

}
