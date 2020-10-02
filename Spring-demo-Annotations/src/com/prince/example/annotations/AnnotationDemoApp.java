package com.prince.example.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		//Read Spring Configuration File
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//get the Bean from Spring Container
		Coach theCoach=context.getBean("thatSillyCoach",Coach.class);
		Coach volleyCoach=context.getBean("volleyBallCoach",Coach.class);
		Coach cricketCoach=context.getBean("cricketCoach",Coach.class);
		
		//call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		System.out.println("\nvolleyball Coach :");
		System.out.println(volleyCoach.getDailyWorkout());
		System.out.println(volleyCoach.getDailyFortune());
		System.out.println("\nCricket Coach :");
		System.out.println(cricketCoach.getDailyWorkout());
		System.out.println(cricketCoach.getDailyFortune());
		
		//close the context
		context.close();

	}

}
