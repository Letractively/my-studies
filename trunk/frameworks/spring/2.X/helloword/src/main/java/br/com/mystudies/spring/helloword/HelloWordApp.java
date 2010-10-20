package br.com.mystudies.spring.helloword;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author rduarte
 *
 */
public class HelloWordApp {

	public static void main(String[] args) {		
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		HelloWord helloWord = (HelloWord) context.getBean("helloWorld");
		helloWord.display();
	}
}
