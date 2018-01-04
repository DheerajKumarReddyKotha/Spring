package com.asura.spring.autowire;

import org.springframework.stereotype.Component;


@Component
public class Pig implements Animals {

	@Override
	public String getColor() {
		return "Black";
	}

	
}
