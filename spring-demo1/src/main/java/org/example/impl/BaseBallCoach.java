package org.example.impl;

import org.example.model.Coach;
import org.example.model.FortuneService;

public class BaseBallCoach implements Coach{

	private FortuneService fortuneService;
	
	public BaseBallCoach() {
		super();
		//fortuneService=new SadFortuneService();
	}

	public BaseBallCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	/*
	 * public FortuneService getFortuneService() { return fortuneService; }
	 */

	/*
	 * public void setFortuneService(FortuneService fortuneService) {
	 * this.fortuneService = fortuneService; }
	 */

	@Override
	public String getDailyWorlout() {
		// TODO Auto-generated method stub
		return "practice back volley today";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getDailyFortune();
	}

}
