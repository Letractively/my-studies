package br.com.hotel.integration.api;

import java.util.List;

public interface BrokerManager {

	boolean register(Region region, String jndi);

	List<Broker> getBrokers(Region region);
}
