package br.com.mystudies.log4j;

import org.apache.log4j.Logger;

public class Log4JDemo {

	private static final Logger LOGGER = Logger.getLogger(Log4JDemo.class);
	
	public static void main(String[] args) {
		
		int i = 0;
		
		while (i++ < 10) {
			LOGGER.error("this is a erro msg");
			LOGGER.info("this is a info msg");
			LOGGER.debug("this is debug msg");
			LOGGER.fatal("this is a faltal msg");
		}
	}
}
