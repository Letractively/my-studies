package br.com.mystudies.ejb.schedule;

import java.util.logging.Logger;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Timer;

@Singleton
public class JobOne {

	private Logger LOGGER = Logger.getLogger(this.getClass().getName());
	

	// optional Timer with parameter
	// http://docs.oracle.com/javaee/6/tutorial/doc/bnboy.html >> @Schedule() attributes 
	@Schedule(hour="*", minute="*/1")
	public void executeOne(Timer timer){
		LOGGER.info("Exectuing job one.. " + timer.getSchedule());
	}
	
	
}
