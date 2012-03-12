package com.gmatney.poker.hand;

import org.apache.log4j.Logger;

public class FiveCardRanking extends PokerRanking {
	private Logger log = Logger.getLogger(FiveCardRanking.class);

	@Override
	public int getHandValue(Hand hand) {
		// TODO Create class to generate weight of hand, to be able to tell winner in tie.  
		return 0;
	}

	@Override
	public Rank getHandRank(Hand hand) {
		log.debug("getHandRank(hand = "+hand+")");
		
		Rank rank;
		if(hand == null)                {return null;}
		else if(!hand.isHandValid())    {rank = Rank.CHEATER;}
		else if(hasRoyalFlush(hand))    {rank = Rank.ROYAL_FLUSH;}
		else if(hasStraightFlush(hand)) {rank = Rank.STRAIGHT_FLUSH;}
		else if(hasFourOfAKind(hand))   {rank = Rank.FOUR_OF_A_KIND;}
		else if(hasFullHouse(hand))     {rank = Rank.FULL_HOUSE;}
		else if(hasFlush(hand))         {rank = Rank.FLUSH;}
		else if(hasStraight(hand))      {rank = Rank.STRAIGHT;}
		else if(hasThreeOfAKind(hand))  {rank = Rank.THREE_OF_A_KIND;}
		else if(hasTwoPair(hand))       {rank = Rank.TWO_PAIR;}
		else if(hasPair(hand))          {rank = Rank.PAIR;}
		else                            {rank = Rank.HIGH_CARD;}
		
		log.info("The Rank of "+hand+" is "+rank);
		return rank;
	}
	

	

}
