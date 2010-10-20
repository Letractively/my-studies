package br.com.mystudies.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author rduarte
 *
 */
public class PrinterApp {

	public static void main(String[] args){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
		ReportPrinter reportPrinter = (ReportPrinter) applicationContext.getBean("reportPrinter");
		reportPrinter.printReport();
	}
}
