package com.example.prince;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		//Load the Spring Configuration File
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("beanScopeApplicationContext.xml");
		
		
		
		//Retrieve bean from Spring Container
		Coach theCoach=context.getBean("trackCoach", Coach.class);
		Coach alphaCoach=context.getBean("trackCoach", Coach.class);
		
		System.out.println("Spring by default make the objects as Singleton");
		System.out.println("theCoach :"+theCoach);
		System.out.println("alphaCoach :"+alphaCoach);
		
		//calling destroy method for prototype scope
		MyCustomBeanProcessor cp=context.getBean("customProcessor",MyCustomBeanProcessor.class);
		
		//close the context
		context.close();

	}

}
