package br.com.mystudies.jaxws.client;

import br.com.mystudies.jaxws.WebService;
import br.com.mystudies.jaxws.WebServiceService;

public class WSClient {

	public static void main(String[] args) {
		WebServiceService wss = new WebServiceService();
		WebService ws = wss.getWebServicePort();

		System.out.println(ws.operation("Robson"));
	}
}
