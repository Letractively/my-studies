package br.com.fiapbank.listen;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.fiapbank.persistencia.dao.db.DBManager;
import br.com.fiapbank.persistencia.dao.db.DBManagerJPA;

/**
 * Application Lifecycle Listener implementation class Init
 *
 */
public class Init implements ServletContextListener {

	
	private static final Log LOG = LogFactory.getLog(Init.class);
    
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		try {
			DBManager dbManager = new DBManagerJPA();
			dbManager.init();
		} catch (Exception e) {
			LOG.error("Erro na inicializacao do sistema", e);
		}
	}
}
