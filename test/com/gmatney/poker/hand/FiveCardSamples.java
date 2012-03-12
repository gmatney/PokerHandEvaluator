package com.gmatney.poker.hand;

import java.util.ArrayList;

import com.gmatney.playingcard.Card;
import com.gmatney.playingcard.CardNumber;
import com.gmatney.playingcard.CardSuit;

public class FiveCardSamples {
	//Full House
	public static FiveCardHand getTwoPairNoHouse(){
		FiveCardHand twoPairNoHouse = new FiveCardHand();
		twoPairNoHouse.addCard(new Card(CardNumber.ACE, CardSuit.CLUB));
		twoPairNoHouse.addCard(new Card(CardNumber.ACE, CardSuit.DIAMOND));
		twoPairNoHouse.addCard(new Card(CardNumber.THREE, CardSuit.HEART));
		twoPairNoHouse.addCard(new Card(CardNumber.THREE, CardSuit.SPADE));
		twoPairNoHouse.addCard(new Card(CardNumber.FIVE, CardSuit.SPADE));
		return twoPairNoHouse;
	}
	public static FiveCardHand getThreeOfAKindNotFullHouse(){
		FiveCardHand threeOfAKindNoHouse = new FiveCardHand();
		threeOfAKindNoHouse.addCard(new Card(CardNumber.TEN, CardSuit.CLUB));
		threeOfAKindNoHouse.addCard(new Card(CardNumber.KING, CardSuit.SPADE));
		threeOfAKindNoHouse.addCard(new Card(CardNumber.TEN, CardSuit.HEART));
		threeOfAKindNoHouse.addCard(new Card(CardNumber.JACK, CardSuit.SPADE));
		threeOfAKindNoHouse.addCard(new Card(CardNumber.TEN, CardSuit.SPADE));
		return threeOfAKindNoHouse;
	}
	public static FiveCardHand getFullHouseLow(){
		FiveCardHand lowHouse = new FiveCardHand();
		lowHouse.addCard(new Card(CardNumber.THREE, CardSuit.DIAMOND));
		lowHouse.addCard(new Card(CardNumber.THREE, CardSuit.HEART));
		lowHouse.addCard(new Card(CardNumber.THREE, CardSuit.SPADE));
		lowHouse.addCard(new Card(CardNumber.TWO, CardSuit.DIAMOND));
		lowHouse.addCard(new Card(CardNumber.TWO, CardSuit.HEART));
		return lowHouse;
	}
	public static FiveCardHand getFullHouseHigh(){
		FiveCardHand highHouse = new FiveCardHand();
		highHouse.addCard(new Card(CardNumber.ACE, CardSuit.HEART));
		highHouse.addCard(new Card(CardNumber.ACE, CardSuit.CLUB));
		highHouse.addCard(new Card(CardNumber.ACE, CardSuit.SPADE));
		highHouse.addCard(new Card(CardNumber.KING, CardSuit.HEART));
		highHouse.addCard(new Card(CardNumber.KING, CardSuit.DIAMOND));
		return highHouse;
	}
	//Flush
	public static FiveCardHand getFlushHeartNotStraight(){
		FiveCardHand heartFlush = new FiveCardHand();
		heartFlush.addCard(new Card(CardNumber.ACE, CardSuit.HEART));
		heartFlush.addCard(new Card(CardNumber.KING, CardSuit.HEART));
		heartFlush.addCard(new Card(CardNumber.QUEEN, CardSuit.HEART));
		heartFlush.addCard(new Card(CardNumber.JACK, CardSuit.HEART));
		heartFlush.addCard(new Card(CardNumber.EIGHT, CardSuit.HEART));
		return heartFlush;
	}
	public static FiveCardHand getFlushDiamondNotStraight(){
		FiveCardHand diamondFlush = new FiveCardHand();
		diamondFlush.addCard(new Card(CardNumber.ACE, CardSuit.DIAMOND));
		diamondFlush.addCard(new Card(CardNumber.TWO, CardSuit.DIAMOND));
		diamondFlush.addCard(new Card(CardNumber.QUEEN, CardSuit.DIAMOND));
		diamondFlush.addCard(new Card(CardNumber.JACK, CardSuit.DIAMOND));
		diamondFlush.addCard(new Card(CardNumber.SEVEN, CardSuit.DIAMOND));
		return diamondFlush;
	}
	//Four of a kind
	public static FiveCardHand getFourOfAKindAceSequentialHavingKing(){
		FiveCardHand fourOfAKind = new FiveCardHand();
		fourOfAKind.addCard(new Card(CardNumber.ACE, CardSuit.HEART));
		fourOfAKind.addCard(new Card(CardNumber.ACE, CardSuit.CLUB));
		fourOfAKind.addCard(new Card(CardNumber.ACE, CardSuit.SPADE));
		fourOfAKind.addCard(new Card(CardNumber.ACE, CardSuit.DIAMOND));
		fourOfAKind.addCard(new Card(CardNumber.KING, CardSuit.DIAMOND));
		return fourOfAKind;
	}
	//Straight Logic
	public static FiveCardHand getStraightLowNum(){
		FiveCardHand lowNumStraight = new FiveCardHand();
		lowNumStraight.addCard(new Card(CardNumber.ACE, CardSuit.CLUB));
		lowNumStraight.addCard(new Card(CardNumber.TWO, CardSuit.DIAMOND));
		lowNumStraight.addCard(new Card(CardNumber.THREE, CardSuit.HEART));
		lowNumStraight.addCard(new Card(CardNumber.FOUR, CardSuit.SPADE));
		lowNumStraight.addCard(new Card(CardNumber.FIVE, CardSuit.SPADE));
		return lowNumStraight;
	}
	public static FiveCardHand getStraightHighNum(){
		FiveCardHand highNumStraight = new FiveCardHand();
		highNumStraight.addCard(new Card(CardNumber.ACE, CardSuit.CLUB));
		highNumStraight.addCard(new Card(CardNumber.KING, CardSuit.DIAMOND));
		highNumStraight.addCard(new Card(CardNumber.QUEEN, CardSuit.HEART));
		highNumStraight.addCard(new Card(CardNumber.JACK, CardSuit.SPADE));
		highNumStraight.addCard(new Card(CardNumber.TEN, CardSuit.SPADE));
		return highNumStraight;
	}
	public static FiveCardHand getStraightNOTWrapAroundFalse(){
		FiveCardHand wrapAroundFalseStraight = new FiveCardHand();
		wrapAroundFalseStraight.addCard(new Card(CardNumber.ACE, CardSuit.CLUB));
		wrapAroundFalseStraight.addCard(new Card(CardNumber.KING, CardSuit.DIAMOND));
		wrapAroundFalseStraight.addCard(new Card(CardNumber.QUEEN, CardSuit.HEART));
		wrapAroundFalseStraight.addCard(new Card(CardNumber.JACK, CardSuit.SPADE));
		wrapAroundFalseStraight.addCard(new Card(CardNumber.TWO, CardSuit.SPADE));
		return wrapAroundFalseStraight;
	}
	//Three of a kind
	public static FiveCardHand getThreeOfAKind7(){
		FiveCardHand acePair = new FiveCardHand();
		acePair.addCard(new Card(CardNumber.SEVEN, CardSuit.CLUB));
		acePair.addCard(new Card(CardNumber.ACE, CardSuit.DIAMOND));
		acePair.addCard(new Card(CardNumber.SEVEN, CardSuit.HEART));
		acePair.addCard(new Card(CardNumber.SEVEN, CardSuit.SPADE));
		acePair.addCard(new Card(CardNumber.FOUR, CardSuit.SPADE));
		return acePair;		
	}
	//Two Pair
	public static FiveCardHand getTwoPairAA55(){
		FiveCardHand cards = new FiveCardHand();
		cards.addCard(new Card(CardNumber.ACE, CardSuit.CLUB));
		cards.addCard(new Card(CardNumber.ACE, CardSuit.DIAMOND));
		cards.addCard(new Card(CardNumber.FIVE, CardSuit.HEART));
		cards.addCard(new Card(CardNumber.FIVE, CardSuit.SPADE));
		cards.addCard(new Card(CardNumber.FOUR, CardSuit.SPADE));
		return cards;		
	}
	//Pair
	public static FiveCardHand getPairOfAces(){
		FiveCardHand acePair = new FiveCardHand();
		acePair.addCard(new Card(CardNumber.ACE, CardSuit.CLUB));
		acePair.addCard(new Card(CardNumber.ACE, CardSuit.DIAMOND));
		acePair.addCard(new Card(CardNumber.SEVEN, CardSuit.HEART));
		acePair.addCard(new Card(CardNumber.FIVE, CardSuit.SPADE));
		acePair.addCard(new Card(CardNumber.FOUR, CardSuit.SPADE));
		return acePair;		
	}
	//High
	public static FiveCardHand getEightHigh(){
		FiveCardHand acePair = new FiveCardHand();
		acePair.addCard(new Card(CardNumber.TWO, CardSuit.CLUB));
		acePair.addCard(new Card(CardNumber.THREE, CardSuit.DIAMOND));
		acePair.addCard(new Card(CardNumber.SEVEN, CardSuit.HEART));
		acePair.addCard(new Card(CardNumber.EIGHT, CardSuit.SPADE));
		acePair.addCard(new Card(CardNumber.FOUR, CardSuit.SPADE));
		return acePair;		
	}	
	
	
	
}
