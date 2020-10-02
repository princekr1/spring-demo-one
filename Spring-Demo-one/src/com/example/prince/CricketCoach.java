package com.example.prince;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	private String emailAddress;
	private String team;
	
	//creating Default Constructor
	CricketCoach(){
		System.out.println("CricketCoach : Inside no-args Constructor");
	}
	
	//Setter methods
	public void setFortuneService(FortuneService fortuneService) {
		
		System.out.println("CricketCoach : Inside Setter Method : setFortuneService");
		
		this.fortuneService=fortuneService;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		
		System.out.println("CricketCoach : Inside Setter Method : setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		
		System.out.println("CricketCoach : Inside Setter Method : setTeam");
		this.team = team;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice fast bowling for 15 mins";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
