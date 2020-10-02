package com.example.prince;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	
	public TrackCoach() {
		
	}
	//Creating Constructor
	public TrackCoach(FortuneService fortuneService) {
		
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		
		return "yes lucky boy, "+fortuneService.getFortune();
	}
	
	//Add an Init Method
	public void doMyStartupStuff() {
		System.out.println("TrackCoach : inside method doMyStratupStuff");
	}
	
	//Add a destroy Method
	public void doMyCleanupStuff() {
		System.out.println("TrackCoach : inside method doMyCleanupStuff");
	}
	
}
