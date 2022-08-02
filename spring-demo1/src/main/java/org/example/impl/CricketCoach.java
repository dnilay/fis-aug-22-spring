package org.example.impl;

import org.example.model.Coach;
import org.example.model.FortuneService;

public class CricketCoach implements Coach{
	
	private FortuneService fortuneService;

	public CricketCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}



	@Override
	public String getDailyWorlout() {
		// TODO Auto-generated method stub
		return "practice spin bowling today";
	}

	

	



	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getDailyFortune();
	}

}
