package com.prince.example.annotations;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

	private FortuneService fortuneService;
	
	@Value("${foo.email}")
	private String email;
	@Value("${foo.team}")
	private String team;
	//Constructor
	public SwimCoach(FortuneService fortuneSevice) {
		this.fortuneService=fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "swim 200 meters everyday";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "today you will win";
	}
	
	//getter methods
	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}


}
