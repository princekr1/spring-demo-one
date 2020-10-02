package com.example.prince;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {
		
		//Load the Spring Configuration File
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("beanLifeCycleApplicationContext.xml");
		
		//Retrieve bean from Spring Container
		Coach theCoach=context.getBean("trackCoach", Coach.class);
				
		System.out.println(theCoach.getDailyWorkout());
		
		//close the context
		context.close();
				
	}

}
