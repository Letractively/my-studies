package br.com.hotel.broker.two;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.com.hotel.domain.Hotel;
import br.com.hotel.integration.api.BrokenFilter;
import br.com.hotel.integration.api.Broker;

@Stateless
@Remote(Broker.class)
public class BrokerTwoServiceBean implements Broker {

	private static List<Hotel> hotels = new ArrayList<>();

	{
		hotels.add(new Hotel("hotel1-broker-two", 3));
		hotels.add(new Hotel("hotel2-broker-two", 5));
		hotels.add(new Hotel("hotel3-broker-two", 6));
		hotels.add(new Hotel("hotel4-broker-two", 3));
		hotels.add(new Hotel("hotel5-broker-two", 1));
		hotels.add(new Hotel("hotel6-broker-two", 2));
		hotels.add(new Hotel("hotel7-broker-two", 5));
	}


	@Override
	public List<Hotel> getHotels(BrokenFilter brokenFilter) {
		return hotels;
	}

}
