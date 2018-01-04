package com.asura.spring.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TestAutowire {

	private Animals animals;

//  This is getter injection for dependency
//	@Autowired
//	public TestAutowire(@Qualifier("pig")Animals animals) {
//		this.animals = animals;
//	}
	
//  This is setter injection for auto wiring
	@Autowired
	@Qualifier("parrot") //When a interface has multiple implementations go with qualifier name
	public void setAnimals(Animals animals) {
		this.animals = animals;
	}
	
	
	public String getAnimalColor() {
		return animals.getColor();
	}
	
}
