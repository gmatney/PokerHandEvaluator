package com.gmatney.playingcard.util;

import com.gmatney.playingcard.CardSuit;

public class CardSuitComparable  implements Comparable<CardSuitComparable> {
	CardSuit cardSuit;

	
	
	/**
	 * @return the cardSuit
	 */
	public CardSuit getCardSuit() {
		return cardSuit;
	}

	/**
	 * @param cardSuit the cardSuit to set
	 */
	public void setCardSuit(CardSuit cardSuit) {
		this.cardSuit = cardSuit;
	}

	/**
	 * @param cardSuit
	 */
	public CardSuitComparable(CardSuit cardSuit) {
		super();
		this.cardSuit = cardSuit;
	}

	@Override
	public int compareTo(CardSuitComparable cs) {
		
		if(this.equals(cs)){
			return 0;
		}
		if(CardUtil.getCardSuitValue(cs.getCardSuit()) < CardUtil.getCardSuitValue(cs.getCardSuit()) ){
			return -1;
		}
		return 1;

	}
	
}
