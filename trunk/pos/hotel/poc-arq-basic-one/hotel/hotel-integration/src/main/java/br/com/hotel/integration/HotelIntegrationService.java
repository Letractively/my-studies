package br.com.hotel.integration;

import java.util.List;

import br.com.hotel.domain.Hotel;

public interface HotelIntegrationService {

	List<Hotel> getHotels(HotelIntegrationFilter hotelIntegrationFilter);
}
