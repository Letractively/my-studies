package br.com.hotel.integration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.PostActivate;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.hotel.integration.api.Broker;

@Stateless
@Local(BrokenService.class)
public class BrokenServiceBean implements BrokenService {


	private Map<Region, List<String>> brokers = new HashMap<>();





	@PostConstruct
	public void init(){

		List<String> jndiBrokers1 = new ArrayList<>();

		jndiBrokers1.add("java:global/hotel-broker-one/BrokenOneServiceBean!br.com.hotel.integration.api.Broker");
		jndiBrokers1.add("java:global/hotel-broker-three/BrokenThreeServiceBean!br.com.hotel.integration.api.Broker");


		brokers.put(new Region("Brasil"), jndiBrokers1);





		List<String> jndiBrokers2 = new ArrayList<>();

		jndiBrokers2.add("java:global/hotel-broker-two/BrokerTwoServiceBean!br.com.hotel.integration.api.Broker");

		brokers.put(new Region("Mexico"), jndiBrokers2);

	}



	/*	{

		List<String> jndiBrokers = new ArrayList<>();


	}*/



	@Override
	public List<Broker> getBrokers(Region region) {

		List<String> jndis = brokers.get(region);

		List<Broker> brokers = new ArrayList<>();

		for (String jndi : jndis) {

			try {
				Context context = new InitialContext();
				brokers.add((Broker) context.lookup(jndi));
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		return brokers;
	}

}
