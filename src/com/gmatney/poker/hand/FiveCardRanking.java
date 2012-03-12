package com.gmatney.poker.hand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.gmatney.playingcard.Card;
import com.gmatney.playingcard.CardNumber;
import com.gmatney.playingcard.CardSuit;
import com.gmatney.playingcard.util.CardUtil;
import com.gmatney.playingcard.util.CollectionHelper;

public class FiveCardRanking extends PokerRanking {
	private Logger log = Logger.getLogger(FiveCardRanking.class);
	private int MAX_LEGAL_NUMBER_OF_CARDS=5;

	@Override
	public int getHandValue(Hand hand) {
		// TODO Create class to generate weight of hand, to be able to tell winner in tie.  
		return 0;
	}

	/**
	 * 
	 */
	@Override
	public Rank getHandRank(Hand hand) {
		log.debug("getHandRank(hand = "+hand+")");
		//Too few cards could be allowed, but too many is unacceptable :)
		if(hand.getCards().size()>MAX_LEGAL_NUMBER_OF_CARDS){
			log.debug("Too many cards passed in.");
			return Rank.CHEATER;
		}
		Rank rank;
		if(hasRoyalFlush(hand)){ rank = Rank.ROYAL_FLUSH;}
		else if(hasStraightFlush(hand)){rank = Rank.STRAIGHT_FLUSH;}
		else if(hasFourOfAKind(hand)){rank = Rank.FOUR_OF_A_KIND;}
		else if(hasFullHouse(hand)){rank = Rank.FULL_HOUSE;}
		else if(hasFlush(hand)){rank = Rank.FLUSH;}
		else if(hasStraight(hand)){rank = Rank.STRAIGHT;}
		else if(hasThreeOfAKind(hand)){rank = Rank.THREE_OF_A_KIND;}
		else if(hasTwoPair(hand)){rank = Rank.TWO_PAIR;}
		else if(hasPair(hand)){rank = Rank.PAIR;}
		else{rank = Rank.HIGH_CARD;}
		log.info("The Rank of "+hand+" is "+rank);
		return rank;
	}
	

	

}
