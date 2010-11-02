package br.com.mystudies.spring.setter.injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main{
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
		User user = (User) applicationContext.getBean("user");
		System.out.println(user.toString());
	}
}
