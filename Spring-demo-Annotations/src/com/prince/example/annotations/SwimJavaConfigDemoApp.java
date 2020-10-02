package com.prince.example.annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		//Read java Spring Configuration File
			AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SportsConfig2.class);
				
				//get the Bean from Spring Container
				SwimCoach theCoach=context.getBean("swimCoach",SwimCoach.class);
				
				System.out.println("SwimCoach :");
				System.out.println(theCoach.getDailyWorkout());
				System.out.println(theCoach.getDailyFortune());
				System.out.println(theCoach.getEmail());
				System.out.println(theCoach.getTeam());
				
				//close the context
				context.close();


	}

}
