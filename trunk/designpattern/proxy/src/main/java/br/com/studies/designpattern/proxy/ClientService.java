package br.com.studies.designpattern.proxy;

public class ClientService {

	public static void main(String[] args) {
		
		Service service = MockRMI.getService();
		
		service.executeService();
	}
}
