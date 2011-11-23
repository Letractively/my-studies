/**
 * 
 */
package br.com.studies.designpattern.proxy;

/**
 * @author robson
 *
 */
public class RealService implements Service{

	@Override
	public void executeService(){
		System.out.println(" Executing service real ");
	}

}
