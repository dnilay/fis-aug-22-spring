package org.example.impl;

import org.example.model.Coach;
import org.example.model.FortuneService;

public class SwimmingCoach implements Coach{
private FortuneService fortuneService;


	public SwimmingCoach(FortuneService fortuneService) {
	super();
	this.fortuneService = fortuneService;
}

	@Override
	public String getDailyWorlout() {
		// TODO Auto-generated method stub
		return "practice casual swimming today";
	}

	/*
	 * public FortuneService getFortuneService() { return fortuneService; }
	 * 
	 * public void setFortuneService(FortuneService fortuneService) {
	 * this.fortuneService = fortuneService; }
	 */

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getDailyFortune();
	}

}
