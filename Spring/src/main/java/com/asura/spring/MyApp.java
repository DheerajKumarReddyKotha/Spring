package com.asura.spring;

public class MyApp {

	public static void main(String[] args) {
		
		//create the object
		Coach theCoach = new TrackCoach(); //This should be configurable, instead of hard coding
		//Spring does it for you, yay!!!!!!!
		
		//use the object
		System.out.println(theCoach.getDailyWorkout());
	}

}