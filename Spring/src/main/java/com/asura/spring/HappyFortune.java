package com.asura.spring;

public class HappyFortune implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is your Lucky Day!";
	}

}
