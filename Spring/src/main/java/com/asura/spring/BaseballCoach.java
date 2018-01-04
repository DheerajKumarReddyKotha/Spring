package com.asura.spring;

public class BaseballCoach implements Coach {

	private FortuneService fortuneService;
	
	public BaseballCoach() {
		System.out.println("BaseballCoach no-arg constructor");
	}
	
	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		//use happy fortune to get fortune.
		
		return fortuneService.getFortune();
	}
}
