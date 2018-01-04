package com.asura.spring;

import org.springframework.stereotype.Component;

@Component("tennisCoach") //we can remove bean id "tennisCoach" as spring automatically crates it when scanning
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return "You infact have a good fortune";
	}

}
