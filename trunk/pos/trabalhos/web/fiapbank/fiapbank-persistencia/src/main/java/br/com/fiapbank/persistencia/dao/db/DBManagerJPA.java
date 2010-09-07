package br.com.fiapbank.persistencia.dao.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DBManagerJPA implements DBManager{

	
	/**
	 * 
	 */
	private static final Log LOG = LogFactory.getLog( DBManagerJPA.class);


	/**
	 * 
	 */
	private static EntityManagerFactory emf;


	@Override
	public EntityManager createEntityManager() throws DBManagerException {
		if (emf == null)
			throw new DBManagerException("Configuracoes da base nao foram iniciadas");
		return emf.createEntityManager();
	}
	
	
	
	public static void main(String[] args) throws DBManagerException {
		new DBManagerJPA().createEntityManager();
	}



	@Override
	public void init() throws DBManagerException {
		LOG.info("INICIANDO AS CONFIGURACOES DA BASE");
		emf = Persistence.createEntityManagerFactory("fiapbank");
		LOG.info("CONFIGURACOES DA BASE INICIADAS COM SUCESSO");
	}
}
