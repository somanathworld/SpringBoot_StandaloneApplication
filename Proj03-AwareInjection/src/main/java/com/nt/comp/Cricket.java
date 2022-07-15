package com.nt.comp;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Cricket implements ApplicationContextAware{

	private ApplicationContext ctx;
	private String bat;
	
	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("Cricket.setApplicationContext()");
		this.ctx = ctx;
	}
	public Cricket(String bat) {
		this.bat = bat;
	}
	public void fielding() {
		System.out.println("Cricket.fielding()");
	}
	public void batting() {
		System.out.println("Cricket.batting()");
		CricketBat batId = ctx.getBean(bat, CricketBat.class);
		int runs = batId.scoreRun();
		System.out.println("Cricketer is batting and his current score is "+runs);
	}
}
