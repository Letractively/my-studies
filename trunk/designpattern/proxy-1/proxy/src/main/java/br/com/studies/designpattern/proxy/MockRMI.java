/**
 * 
 */
package br.com.studies.designpattern.proxy;

/**
 * @author robson
 *
 */
public class MockRMI{

	public static Service getService(){
		return new ProxyService(new RealService());
	}
}
