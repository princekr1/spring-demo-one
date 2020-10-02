package com.example.prince;

public class BaseballCoach implements Coach {
	
	private FortuneService fortuneService;
	
	//Creating Constructor
	public BaseballCoach(FortuneService fortuneService) {
		
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		
		return "Spend 30 minitues on baseball training";
	}


	@Override
	public String getDailyFortune() {
		
		//using Fortune Service to get Fortune
		return fortuneService.getFortune();
	}
}
