package br.com.mystudies.ejb.schedule;

import java.util.logging.Logger;

import javax.ejb.Schedule;
import javax.ejb.Singleton;

@Singleton
public class JobTwo {

	private Logger LOGGER = Logger.getLogger(this.getClass().getName());
	

	// http://docs.oracle.com/javaee/6/tutorial/doc/bnboy.html >> @Schedule() attributes 
	@Schedule(hour="*", minute="*/1")
	public void executeOne(){
		LOGGER.info("Exectuing job two.. ");
	}
	
	
}
