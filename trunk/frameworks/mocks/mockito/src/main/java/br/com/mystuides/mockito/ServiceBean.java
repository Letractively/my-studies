/**
 * 
 */
package br.com.mystuides.mockito;

/**
 * @author robson
 *
 */
public class ServiceBean implements Service {

	private Dao dao;
	
	public String operation(String argument){
		if(argument == null)
			throw new IllegalArgumentException("Argument is null");
		return dao.find(argument);
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}
	
}
