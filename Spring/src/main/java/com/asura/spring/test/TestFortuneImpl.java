package com.asura.spring.test;


import java.util.Random;

import com.asura.spring.FortuneService;

public class TestFortuneImpl implements FortuneService 
{
	
	private Random myRandom = new Random();
	
	private String[] fortuneArray;

	public String[] getFortuneArray() {
		return fortuneArray;
	}

	public void setFortuneArray(String[] fortuneArray) {
		this.fortuneArray = fortuneArray;
	}

	@Override
	public String getFortune() {
		return fortuneArray[myRandom.nextInt(fortuneArray.length)];
	}

}
