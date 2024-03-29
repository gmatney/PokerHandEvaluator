package com.gmatney.playingcard.util;

import com.gmatney.playingcard.Card;
import com.gmatney.playingcard.CardNumber;
import com.gmatney.playingcard.CardSuit;
/**
 * Responsible for additional names of poker
 * 
 * Originally had the actual ascii codes for the suits, but removed, as 
 * porting to intellji proved problematic 
 * 
 * http://chexed.com/ComputerTips/asciicodes.php
 * 
 * Also it could be somewhat fun to have it print out this information
 * http://en.wikipedia.org/wiki/List_of_playing_card_nicknames
 * 
 * @author gmatney
 *
 */
public class CardName {

	public static final String NULL_CARD = "<NULL CARD>";
	public static final String NULL_NUMBER = "<NULL NUMBER>";
	public static final String NULL_SUIT  = "<NULL SUIT>";
	
	public static final String INVALID_NUMBER = "<NULL NUMBER>";
	public static final String INVALID_SUIT  = "<NULL SUIT>";
	
	public static final String UNRECOGNIZED_NUMBER = "<UNRECOGNIZED NUMBER>";
	public static final String UNRECOGNIZED_SUIT = "<UNRECOGNIZED SUIT>";
	
	
	public static final String ACE_SHORT_NAME   = "A";
	public static final String TWO_SHORT_NAME   = "2";
	public static final String THREE_SHORT_NAME = "3";
	public static final String FOUR_SHORT_NAME  = "4";
	public static final String FIVE_SHORT_NAME  = "5";
	public static final String SIX_SHORT_NAME   = "6";
	public static final String SEVEN_SHORT_NAME = "7";
	public static final String EIGHT_SHORT_NAME = "8";
	public static final String NINE_SHORT_NAME  = "9";
	public static final String TEN_SHORT_NAME   = "10";
	public static final String JACK_SHORT_NAME  = "J";
	public static final String QUEEN_SHORT_NAME = "Q";
	public static final String KING_SHORT_NAME  = "K";
	
	public static final String CLUB_SHORT_NAME    = "C";
	public static final String DIAMOND_SHORT_NAME = "D";
	public static final String SPADE_SHORT_NAME   = "S";
	public static final String HEART_SHORT_NAME   = "H";
	
	
	public static String getShortName(Card c){
		if(c == null){
			return NULL_CARD;
		}
		return getCardNumberValueShortName(c.getNumber())
			+ getCardSuitShortName(c.getSuit());
	}
	public static String getCardNumberValueShortName(CardNumber n){
		if(n == null){return NULL_NUMBER;}
		else if (n.equals(CardNumber.ACE)){    return ACE_SHORT_NAME;}
		else if (n.equals(CardNumber.TWO)){    return TWO_SHORT_NAME;}
		else if (n.equals(CardNumber.THREE)){  return THREE_SHORT_NAME;}
		else if (n.equals(CardNumber.FOUR)){   return FOUR_SHORT_NAME;}
		else if (n.equals(CardNumber.FIVE)){   return FIVE_SHORT_NAME;}
		else if (n.equals(CardNumber.SIX)){    return SIX_SHORT_NAME;}
		else if (n.equals(CardNumber.SEVEN)){  return SEVEN_SHORT_NAME;}
		else if (n.equals(CardNumber.EIGHT)){  return EIGHT_SHORT_NAME;}
		else if (n.equals(CardNumber.NINE)){   return NINE_SHORT_NAME;}
		else if (n.equals(CardNumber.TEN)){    return TEN_SHORT_NAME;}
		else if (n.equals(CardNumber.JACK)){   return JACK_SHORT_NAME;}
		else if (n.equals(CardNumber.QUEEN)){  return QUEEN_SHORT_NAME;}
		else if (n.equals(CardNumber.KING)){   return KING_SHORT_NAME;}
		return UNRECOGNIZED_NUMBER;
	}
	
	public static String getCardSuitShortName(CardSuit s){;
		if(s == null){return INVALID_SUIT;}
		else if(s.equals(CardSuit.CLUB)){    return CLUB_SHORT_NAME;}
		else if(s.equals(CardSuit.DIAMOND)){ return DIAMOND_SHORT_NAME;}
		else if(s.equals(CardSuit.SPADE)){   return SPADE_SHORT_NAME;}
		else if(s.equals(CardSuit.HEART)){   return HEART_SHORT_NAME;}
		return UNRECOGNIZED_SUIT;
			
	}
	

}
