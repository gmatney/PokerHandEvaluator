package com.gmatney.playingcard.util;


import org.apache.log4j.Logger;

import com.gmatney.playingcard.CardNumber;
import com.gmatney.playingcard.CardSuit;

public class CardUtil {
	private static Logger log = Logger.getLogger(CardUtil.class);
	/**
	 * Gets the numerical value of a CardNumber
	 * Ace gets returned as 1, not 14
	 * 
	 * If unknown or null, returns -1
	 * 
	 * @param cn
	 * @return
	 */
	//TODO implementation which can specify ace high or low
	public static int getCardNumberValue(CardNumber cn){
		if(cn==null){return -1;}
		else if(cn.equals(CardNumber.ACE)  ){return 1;}
		else if(cn.equals(CardNumber.TWO)  ){return 2;}
		else if(cn.equals(CardNumber.THREE)){return 3;}
		else if(cn.equals(CardNumber.FOUR) ){return 4;}
		else if(cn.equals(CardNumber.FIVE) ){return 5;}
		else if(cn.equals(CardNumber.SIX)  ){return 6;}
		else if(cn.equals(CardNumber.SEVEN)){return 7;}
		else if(cn.equals(CardNumber.EIGHT)){return 8;}
		else if(cn.equals(CardNumber.NINE) ){return 9;}
		else if(cn.equals(CardNumber.TEN)  ){return 10;}
		else if(cn.equals(CardNumber.JACK) ){return 11;}
		else if(cn.equals(CardNumber.QUEEN)){return 12;}
		else if(cn.equals(CardNumber.KING) ){return 13;}
		else{return -1;}                
	}
	
	/**
	 * Gets a numerical value for a CardSuit, 
	 * Follows bridge notation
	 * 
	 * If unknown or null, returns -1
	 * 
	 * http://en.wikipedia.org/wiki/High_card_by_suit_(poker)
	 * Alternating colors: diamonds (lowest), followed by clubs, hearts, and spades (highest). This ranking is also used in the Chinese card game Big Two or Choh Dai Di.
	 * Reverse alphabetical order: clubs (lowest), followed by diamonds, hearts, and spades (highest). This ranking is also used in the game of bridge.
	 * @param cs
	 * @return
	 */
	public static int getCardSuitValue(CardSuit cs){		
		if(cs==null){return -1;}
		else if(cs.equals(CardSuit.CLUB)   ){return 1;}
		else if(cs.equals(CardSuit.DIAMOND)){return 2;}
		else if(cs.equals(CardSuit.HEART)  ){return 3;}
		else if(cs.equals(CardSuit.SPADE)  ){return 4;}
		else {return -1;}
	}
	
	public static boolean isCardRankedLessThanSecondCard(CardNumber n1, CardNumber n2){
		if(getCardNumberValue(n1) < getCardNumberValue(n2)){
			return true;
		}
		return false;
	}
	
	public static boolean areCardNumbersSequential(CardNumber n1, CardNumber n2){
		
		int diff = getCardNumberValue(n1)-getCardNumberValue(n2);
		if(Math.abs(diff)==1){
			log.trace(n1+" is sequential to "+n2);
			return true;
		}
		//Check special Ace case
		else if(n1.equals(CardNumber.ACE) && n2.equals(CardNumber.KING)){
			log.trace(n1+" is sequential to "+n2);
			return true;
		}
		log.trace(n1+" is NOT sequential to "+n2);
		return false;
	}
}
