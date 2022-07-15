package com.nt.comp;


public abstract class Cricket {


	public abstract CricketBat createCricketBat();

	public void bowling() {
		System.out.println("Bowler starts bowling");
	}

	public void fielding() {
		System.out.println("Fielder starts fielding");
	}

	public void batting() {
		CricketBat bat = createCricketBat();
		int score = bat.scoreRuns();
		System.out.println("Batsman batting and his current score is " + score);
	}

}
