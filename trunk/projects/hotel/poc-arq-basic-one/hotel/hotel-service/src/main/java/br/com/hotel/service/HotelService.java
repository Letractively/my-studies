package br.com.hotel.service;

import java.util.List;

import br.com.hotel.domain.Hotel;

public interface HotelService {


	List<Hotel> getHotels(HotelFilter hotelFilter);

}
