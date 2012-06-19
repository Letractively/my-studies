package br.com.hotel.integration;

import java.util.List;

import br.com.hotel.integration.api.Broker;

public interface BrokenService {

	List<Broker> getBrokers(Region region);

}
