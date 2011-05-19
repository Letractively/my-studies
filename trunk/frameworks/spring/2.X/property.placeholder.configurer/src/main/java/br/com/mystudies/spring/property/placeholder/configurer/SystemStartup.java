package br.com.mystudies.spring.property.placeholder.configurer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author robson.o.d@gmail.com
 */
public class SystemStartup {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
		
		SystemConfig systemConfig = (SystemConfig) applicationContext.getBean("systemConfigUbuntu");
		
		systemConfig.configSystem();
	}
}
