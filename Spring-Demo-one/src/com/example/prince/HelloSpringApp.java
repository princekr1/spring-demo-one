package com.example.prince;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		
		//Load Spring configuration file
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//get the Bean
		Coach trackcoach=context.getBean("trackCoach",Coach.class);
		Coach baseballcoach=context.getBean("baseballCoach",Coach.class);
		Coach cricketcoach=context.getBean("cricketCoach",Coach.class);
		CricketCoach cricketcoachorg=context.getBean("cricketCoach",CricketCoach.class);
		TennisCoach tenniscoach=context.getBean("tennisCoach",TennisCoach.class);
		//call the Method
		System.out.println("track Coach :");
		System.out.println(trackcoach.getDailyWorkout());
		System.out.println(trackcoach.getDailyFortune());
		
		System.out.println("\nBaseball Coach :");
		System.out.println(baseballcoach.getDailyWorkout());
		System.out.println(baseballcoach.getDailyFortune());
		
		System.out.println("\nCricket Coach :");
		System.out.println(cricketcoach.getDailyWorkout());
		System.out.println(cricketcoach.getDailyFortune());
		
		System.out.println("\nCricket Coach Original Class Bean/Object :");
		System.out.println(cricketcoachorg.getDailyWorkout());
		System.out.println(cricketcoachorg.getDailyFortune());
		System.out.println(cricketcoachorg.getEmailAddress());
		System.out.println(cricketcoachorg.getTeam());
		
		
		System.out.println("\nTennis Coach Original Class Bean/Object :");
		System.out.println(tenniscoach.getDailyWorkout());
		System.out.println(tenniscoach.getDailyFortune());
		System.out.println(tenniscoach.getEmailAddress());
		System.out.println(tenniscoach.getTeam());
		
		
		//close the spring Container
		context.close();
	}

}
