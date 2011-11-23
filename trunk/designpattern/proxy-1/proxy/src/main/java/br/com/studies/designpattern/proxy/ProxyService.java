/**
 * 
 */
package br.com.studies.designpattern.proxy;

/**
 * @author robson
 *
 */
public class ProxyService implements Service{

	private Service service; 
	
		
	public ProxyService(Service service) {
		super();
		this.service = service;
	}


	@Override
	public void executeService() {
		System.out.println(" Executing service in proxy " );
		service.executeService();
	}

}
