/**
 * 
 */
package br.com.fiapbank.persistencia.dao.db;

import javax.persistence.EntityManager;

/**
 * @author robson.oliveira
 *
 */
public interface DBManager {
	
	
	/**
	 * @return
	 * @throws Exception
	 */
	public EntityManager createEntityManager()throws DBManagerException;

	
	public void init()throws DBManagerException;
	
}
