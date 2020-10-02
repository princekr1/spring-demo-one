package com.prince.example.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		
		//load beans to the container
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Retrieve Bean from the Container
		Coach theCoach=context.getBean("cricketCoach",Coach.class);
		
		Coach alphaCoach=context.getBean("cricketCoach",Coach.class);
		
		//Check if they are the same
		boolean result=(theCoach ==alphaCoach);
		
		System.out.println(result);
		
		System.out.println("memory location for theCoach :"+theCoach);
		
		System.out.println("memory location for alphaCoach :"+alphaCoach);
		//Close the container
		context.close();

	}

}
