package br.com.mystudies.mock.jmock;

/**
 * @author rduarte
 *
 */
public class ServiceImpl implements Service{

	private Dao dao;
	
	public String operation(String arg){
		return dao.find(arg);
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}

}
