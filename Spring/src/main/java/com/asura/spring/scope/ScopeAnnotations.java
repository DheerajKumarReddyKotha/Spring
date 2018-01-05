package com.asura.spring.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.asura.spring.Coach;

@Component
@Scope("prototype")
public class ScopeAnnotations implements Coach {

	public ScopeAnnotations() {
		System.out.println("ScopeAnnotations: no-arg constructor");
	}
	@Override
	public String getDailyWorkout() {
		return "Scope do not have workout";
	}

	@Override
	public String getDailyFortune() {
		return "You have a bad luck today";
	}

}
