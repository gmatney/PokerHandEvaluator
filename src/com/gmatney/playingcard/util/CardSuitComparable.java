package com.gmatney.playingcard.util;

import com.gmatney.playingcard.CardSuit;

/**
 * Override the default ENUM ranking for CardSuit
 * Could be used in other games, as some Ranking rules require suit order  
 * @author gmatney
 *
 */
public class CardSuitComparable  implements Comparable<CardSuitComparable> {
	CardSuit cardSuit;
	
	public CardSuit getCardSuit() {
		return cardSuit;
	}

	public void setCardSuit(CardSuit cardSuit) {
		this.cardSuit = cardSuit;
	}

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
