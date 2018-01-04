package com.asura.spring.autowire;

import org.springframework.stereotype.Component;

@Component
public class Parrot implements Animals {

	@Override
	public String getColor() {
		return "Green";
	}

}
