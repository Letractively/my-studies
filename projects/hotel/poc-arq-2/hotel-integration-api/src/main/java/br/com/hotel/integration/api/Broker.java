package br.com.hotel.integration.api;

import java.util.List;

import br.com.hotel.domain.Hotel;

public interface Broker {

	List<Hotel> getHotels();

	void register();

}
