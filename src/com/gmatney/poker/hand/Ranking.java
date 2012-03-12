package com.gmatney.poker.hand;


public interface Ranking {
	public Rank getHandRank(Hand hand);
	public int getHandValue(Hand hand);	
}
