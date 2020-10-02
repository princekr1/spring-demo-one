package com.prince.example.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class VolleyBallCoach implements Coach {

	private FortuneService fortuneService;
	
	
	
	public VolleyBallCoach() {
	
	}
	
	//setter methods
	//@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("VolleyBallCoach : inside setter method : setFortuneService");
		this.fortuneService = fortuneService;
	}

	//getter methods
	
	public FortuneService getFortuneService() {
		return fortuneService;
	}
	
	
	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

	//Method Injection
	@Autowired
	@Qualifier("happyFortuneService")
	public void doSomeCrazyStuff(FortuneService fortuneService) {
		System.out.println("VolleyBallCoach : inside setter method : doSomeCrazyStuff");
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		
		return "Play VolleyBall for one hour";
	}

	
}
