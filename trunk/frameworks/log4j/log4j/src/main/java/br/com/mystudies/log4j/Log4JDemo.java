package br.com.mystudies.log4j;

import org.apache.log4j.Logger;

public class Log4JDemo {

	private static final Logger LOGGER = Logger.getLogger(Log4JDemo.class);
	
	public static void main(String[] args) {
		LOGGER.error("teste");
	}
}
