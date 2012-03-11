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

public class FiveCardRanking implements Ranking {
	private Logger log = Logger.getLogger(FiveCardRanking.class);

	public Rank getHandRank(FiveCardHand hand) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getHandValue(Hand hand) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Rank getHandRank(Hand hand) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean hasRoyalFlush(Hand handToCheck){
	
		return false;
	}
	public boolean hasStraightFlush(Hand handToCheck){
	
		return false;
	}
	public boolean hasFourOfAKind(Hand handToCheck){
		Hand hand = new FiveCardHand(handToCheck); //Make copy of the object so original doesn't get modified
		log.debug("hasFourOfAKind(hand = "+hand+")");
		if(hand == null){
			log.debug("Hand was null. Returning false");
			return false;
		}
		ArrayList<Card> cards = hand.getCards();
		if(cards == null){
			log.debug("The ArrayLhast<Card> inside the Hand Object was NULL. Returning false");
			return false;
		}
		log.debug("Number of cards in Hand: "+cards.size());
		Set<CardNumber> set = new HashSet<CardNumber>(hand.getNumberValues());
		for (CardNumber num : set){
			//See how many of thhas number there are 
			int n = Collections.frequency(hand.getNumberValues(),num);
			log.trace("There are "+n+" '"+num+"'s");
			if(n>3){return true;}
		}
		
		return false;
	}
	public boolean hasFullHouse(Hand handToCheck){
		
		return false;
	}
	
	/**
	 * Determines if a hand has five cards with the same suit
	 * @param handToCheck
	 * @return
	 */
	public boolean hasFlush(Hand handToCheck){
		Hand hand = new FiveCardHand(handToCheck); //Make copy of the object so original doesn't get modified
		log.debug("hasFlush(hand = "+hand+")");
		if(hand == null){
			log.debug("Hand was null. Returning false");
			return false;
		}
		ArrayList<Card> cards = hand.getCards();
		if(cards == null){
			log.debug("The ArrayList<Card> inside the Hand Object was NULL. Returning false");
			return false;
		}
		log.debug("Number of cards in Hand: "+cards.size());
		
		List<CardSuit> sorted = CollectionHelper.asSortedList(hand.getSuitValues());
		
		int highestNumberInARowThusFar=0;
		int suitsInARow=0;
		if(sorted.size()>1){
			suitsInARow=1;
			for(int i=1; i<sorted.size();i++){
				if(sorted.get(i-1).equals(sorted.get(i))){
					suitsInARow++;
				}
				else{
					if(suitsInARow > highestNumberInARowThusFar){
						highestNumberInARowThusFar = suitsInARow;
					}
					suitsInARow = 1;
				}	
			}
			if(suitsInARow > highestNumberInARowThusFar){
				highestNumberInARowThusFar = suitsInARow;
			}
		}
		log.debug("Max number of suits found in a row = "+highestNumberInARowThusFar);
		if(highestNumberInARowThusFar>4){
			return true;
		}
		return false;
	}
	/**
	 * Determines if a hand has five cards with sequential number values
	 * @param handToCheck
	 * @return
	 */
	public boolean hasStraight(Hand handToCheck){
		Hand hand = new FiveCardHand(handToCheck); //Make copy of the object so original doesn't get modified
		log.debug("hasStraight(hand = "+hand+")");
		if(hand == null){
			log.debug("Hand was null. Returning false");
			return false;
		}
		ArrayList<Card> cards = hand.getCards();
		if(cards == null){
			log.debug("The ArrayList<Card> inside the Hand Object was NULL. Returning false");
			return false;
		}
		log.debug("Number of cards in Hand: "+cards.size());
		Set<CardNumber> set = new HashSet<CardNumber>(hand.getNumberValues());
		List<CardNumber> sorted = CollectionHelper.asSortedList(set);
		
		int numberInSequence=0;
		if(sorted.size()>1){
			numberInSequence=1;
			//Inch worm a long
			for(int i=1; i<sorted.size();i++){
				if(CardUtil.areCardNumbersSequential(sorted.get(i-1),sorted.get(i))){
					numberInSequence++;
				}
				else{
					numberInSequence=1;
				}
			}
			 //Check wrap around, (example: Ace)
			if(CardUtil.areCardNumbersSequential(sorted.get(0),sorted.get(sorted.size()-1))){
				numberInSequence++;
			}
		}
		log.debug("Number of cards in sequence: "+numberInSequence);
		if(numberInSequence>4){
			return true;
		}
		return false;
	}
	
	/**
	 * Determines whether a hand has three cards with the same number value
	 * @param handToCheck
	 * @return
	 */
	public boolean hasThreeOfAKind(Hand handToCheck){
		Hand hand = new FiveCardHand(handToCheck); //Make copy of the object so original doesn't get modified
		log.debug("hasThreeOfAKind(hand = "+hand+")");
		if(hand == null){
			log.debug("Hand was null. Returning false");
			return false;
		}
		ArrayList<Card> cards = hand.getCards();
		if(cards == null){
			log.debug("The ArrayList<Card> inside the Hand Object was NULL. Returning false");
			return false;
		}
		log.debug("Number of cards in Hand: "+cards.size());
		
		
		Set<CardNumber> set = new HashSet<CardNumber>(hand.getNumberValues());
		for (CardNumber num : set){
			//See how many of this number there are 
			int n = Collections.frequency(hand.getNumberValues(),num);
			log.trace("There are "+n+" '"+num+"'s");
			if(n>2){return true;}
		}
		
		return false;
	}
	
	/**
	 * Determines whether a hand has two sets of two cards with the same number value
	 * @param handToCheck
	 * @return
	 */
	public boolean hasTwoPair(Hand handToCheck){
		Hand hand = new FiveCardHand(handToCheck); //Make copy of the object so original doesn't get modified
		boolean foundFirstPair = false;
		log.debug("hasTwoPair(hand = "+hand+")");
		if(hand == null){
			log.debug("Hand was null. Returning false");
			return false;
		}
		ArrayList<Card> cards = hand.getCards();
		if(cards == null){
			log.debug("The ArrayList<Card> inside the Hand Object was NULL. Returning false");
			return false;
		}
		log.debug("Number of cards in Hand: "+cards.size());
		for (int i =0; i< cards.size(); i++){
			Card c1= cards.remove(0);
			if(i>0){i--;} //Update index
			for (int j = 0; j<cards.size()&&!foundFirstPair; j++){
				log.trace("PairSearch1: Are '"+c1.getShortName()+"' and '"
						+cards.get(j).getShortName()+"' a pair?");
				if(c1.getNumber().equals(cards.get(j).getNumber())){
					log.trace("\tYes!");
					//Found one pair
					foundFirstPair = true;
					cards.remove(0);//Remove card to not include in pairing any more
					if(i>0){i--;}if(j>0){j--;}//Update indexes;
					log.debug("Found first Pair, looking for Second now");
				}
				log.trace("\tNo.!");
			}
			if(foundFirstPair){
				break;
			}
		}
		for (int i =0; i< cards.size(); i++){
			Card c1= cards.remove(0);
			if(i>0){i--;} //Update index
			for (Card c2: cards){
				log.trace("PairSearch2:Are '"+c1.getShortName()+"' and '"+c2.getShortName()+"' a pair?");
				if(c1.getNumber().equals(c2.getNumber())){
					log.trace("\tYes!");
					log.debug("Two pairs found!");
					cards.remove(0);
					return true;
				}
				log.trace("\tNo.!");
			}
		}
		
		log.debug("returning false");
		return false;
	}
	/**
	 * Determines whether a hand has two cards with the same number value
	 * @param handToCheck
	 * @return
	 */
	public boolean hasPair(Hand handToCheck){
		Hand hand = new FiveCardHand(handToCheck); //Make copy of the object so original doesn't get modified
		log.debug("hasPair(hand = "+hand+")");
		if(hand == null){
			log.debug("Hand was null. Returning false");
			return false;
		}
		ArrayList<Card> cards = hand.getCards();
		if(cards == null){
			log.debug("The ArrayList<Card> inside the Hand Object was NULL. Returning false");
			return false;
		}
		log.debug("Number of cards in Hand: "+cards.size());
		for (int i =0; i< cards.size(); i++){
			Card c1= cards.remove(0);
			i--; //Update index
			for (Card c2: cards){
				log.trace("Are '"+c1.getShortName()+"' and '"+c2.getShortName()+"' a pair?");
				if(c1.getNumber().equals(c2.getNumber())){
					log.trace("\tYes!");
					log.debug("A pairs found!");
					return true;
				}
				log.trace("\tNo.!");
				
			}
		}
		log.debug("returning false");
		return false;
	}

	
	
	

}
