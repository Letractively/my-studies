package br.com.studies.maven;

import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang.time.DateFormatUtils;

/**
 * Hello world!
 *
 */
public class App{
	
	
	
    public static void main( String[] args ){    	
    	System.out.println(" >>>>>> Horários no Brazil <<<<<<<<");
    	
    	new App()
    	.printHours("Fernando de Noronha", "GMT-2:00")
		.printHours("São Paulo", "GMT-3:00")		
    	.printHours("Acre", "GMT-4:00");
    }

    
    
    
    
	public App printHours(String estado, String gmt){
		System.out.println(" -----------------------------------");    	
        System.out.println(
        		"Em " +
        		estado +
        		DateFormatUtils.format
        			(new Date(), 
        			" dd/MM/yyyy HH:mm:ss ", 
        			TimeZone.getTimeZone(gmt)) 
        );
        System.out.println(" -----------------------------------");
        return this;
	}
}
