package com.asura.spring.javaconfiguration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SportConfigMain {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new 
				AnnotationConfigApplicationContext(SportConfig.class);
		
//		Sports sports = context.getBean("sports", Sports.class);
//
//		System.out.println(sports.getSports());
		
		SwimCoach swimCoachOne = context.getBean("swimCoach",SwimCoach.class); 
		//Name "swimCoach" should be same as the name assigned in SportConfig File
		System.out.println(swimCoachOne.getDailyFortune());
		
		System.out.println(swimCoachOne.getEmailAddress());
		System.out.println(swimCoachOne.getTeam());
		context.close();
	}

}
