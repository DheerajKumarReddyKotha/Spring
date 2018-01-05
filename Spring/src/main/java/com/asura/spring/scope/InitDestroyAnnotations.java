package com.asura.spring.scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class InitDestroyAnnotations {

	@PostConstruct //This annotation is replacement for the one which is present in applicationContext.xml file.
	public void doMyStartupStuff() {
		System.out.println("InitDestroyAnnotations: in doMyStartupStuff");
	}
	
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("InitDestroyAnnotations: in doMyCleanupStuff");
	}
}
