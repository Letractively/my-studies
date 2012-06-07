package br.com.mystudies.jaxws;

import javax.jws.WebMethod;

@javax.jws.WebService
public class WebService {

	private static String HELLO = "hello, ";

	@WebMethod
	public String operation(String name) {
		return HELLO + name;
	}

}
