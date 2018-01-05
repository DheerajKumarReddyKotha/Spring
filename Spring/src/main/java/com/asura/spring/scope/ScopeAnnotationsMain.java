package com.asura.spring.scope;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ScopeAnnotationsMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		ScopeAnnotations scopeAnnotations = context.getBean("scopeAnnotations", ScopeAnnotations.class);
		
		ScopeAnnotations scopeAnnotationsTwo = context.getBean("scopeAnnotations", ScopeAnnotations.class);
		
		System.out.println("coach "+scopeAnnotations.getDailyWorkout());
		System.out.println("coachTwo "+scopeAnnotationsTwo.getDailyFortune());
		
		InitDestroyAnnotations initDestroyAnnotations = context.getBean("initDestroyAnnotations", InitDestroyAnnotations.class);
		context.close();
	}

}
