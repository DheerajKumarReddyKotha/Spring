package com.asura.spring.javaconfiguration;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach{

	@Value("${asura.email}")
	private String emailAddress;
	
	@Value("${asura.team}")
	private String team;
	
	public String getDailyWorkout() {
		return "Workout 1 hour a day";
	}

	public String getDailyFortune() {
		return "You are lUcky Today";
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getTeam() {
		return team;
	}
	
	

}
