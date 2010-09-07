package br.com.fiapbank.persistencia.dao.hibernate.jpa;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import br.com.fiapbank.persistencia.dao.db.DBManager;
import br.com.fiapbank.persistencia.dao.db.DBManagerException;
import br.com.fiapbank.persistencia.dao.db.DBManagerJPA;

/**
 * Classe 
 * 
 * 
 * 
 * @author robson.oliveira
 *
 */
public class BaseDaoJPAHibernate{
	
	/**
	 * 
	 */
	private EntityManager manager;
	


	/**
	 * 
	 */
	private DBManager dbMamager;
	
	
	/**
	 * 
	 */
	public BaseDaoJPAHibernate() {
		dbMamager = new DBManagerJPA();
	}
	
	

	/**
	 * @return
	 * @throws BibliotecaDBManagerException 
	 * @throws PersistenceConfigException
	 */
	protected EntityManager getEntityManager() throws DBManagerException{
		if ( manager == null || !manager.isOpen() )		
				manager = dbMamager.createEntityManager();		
		return manager;
	}
	



	/**
	 * @return Session
	 * @throws PersistenceConfigException
	 */
	protected Session getSessionHibernate() throws DBManagerException{
		return (Session) dbMamager.createEntityManager().getDelegate();
	}	


	

	/**
	 * @throws BibliotecaDBManagerException
	 */
	protected void begin() throws DBManagerException {
		 getEntityManager().getTransaction().begin(); 
	}

	
	

	/**
	 * @throws BibliotecaDBManagerException
	 */
	protected void commit() throws DBManagerException {
		 getEntityManager().getTransaction().commit();
	}

	

	/**
	 * 
	 */
	protected void close(){		
		if ( manager != null && manager.isOpen())
			manager.close();		
	}	
	
	
	/**
	 * 
	 */
	protected void rollback(){		
		if ( manager != null && manager.isOpen() && manager.getTransaction().isActive())			
				manager.getTransaction().rollback();			
	}
	
}
