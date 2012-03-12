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
		// TODO Create class to generate weight of hand, to be able to tell winner in tie.  
		return 0;
	}

	@Override
	public Rank getHandRank(Hand hand) {
		//if(hasRoyalFlush)
		return null;
	}
	
	/**
	 * Return if a hand has hand with cards of all the same suit, and in sequential order
	 * And is Ace High
	 * @param handToCheck
	 * @return
	 */
	public boolean hasRoyalFlush(Hand handToCheck){
		Hand hand = new FiveCardHand(handToCheck); //Make copy of the object so original doesn't get modified
		log.debug("hasRoyalFlush(hand = "+hand+")");
		Hand straightFlush = getStraightFlush(hand);
		if(straightFlush != null
			&& straightFlush.getNumberValues().contains(CardNumber.ACE)
			&& straightFlush.getNumberValues().contains(CardNumber.KING)//Make sure not Ace Low
		){
			return true;
		}
		return false;
	}
	/**
	 * Return if a hand has hand with cards of all the same suit, and in sequential order 
	 * @param handToCheck
	 * @return
	 */
	public boolean hasStraightFlush(Hand handToCheck){
		Hand hand = new FiveCardHand(handToCheck); //Make copy of the object so original doesn't get modified
		log.debug("hasStraightFlush(hand = "+hand+")");
		if(getStraightFlush(hand)==null){
			return false;
		}
		return true;
	}
	/**
	 * If the hand has a straight flush, return the straight flush 
	 * otherwise, return null
	 * @param handToCheck
	 * @return
	 */
	private Hand getStraightFlush(Hand handToCheck){
		Hand hand = new FiveCardHand(handToCheck); //Make copy of the object so original doesn't get modified
		log.debug("getStraightFlush(hand = "+hand+")");
		Hand subHandThatIsStraight = getStraight(hand);
		if(subHandThatIsStraight == null){
			return null;
		}
		if(!hasFlush(subHandThatIsStraight)){
			return null;
		}
		return subHandThatIsStraight;
	}
	
	/**
	 * Find out if hand has four cards with the same number value.
	 */
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
	/**
	 * Find out if has three of a kind and a pair
	 * @param handToCheck
	 * @return
	 */
	public boolean hasFullHouse(Hand handToCheck){
		Hand hand = new FiveCardHand(handToCheck); //Make copy of the object so original doesn't get modified
		log.debug("hasFullHouse(hand = "+hand+")");
		
		Hand threeOfAKind = getThreeOfAKind(hand);
		if(threeOfAKind == null){
			return false;
		}
		log.debug("Three of a kind = "+threeOfAKind);
		hand.removeHand(threeOfAKind);
		Hand thePair = getPair(hand);
		if(thePair == null){
			return false;
		}
		log.debug("The Pair = "+thePair);

		log.debug("returning true");
		return true;
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
		if(getStraight(hand)==null){
			return false;
		}
		return true;
	}
	
	/**
	 * If there are five cards with sequential number values, return all* cards with those values from the hand
	 * otherwise, return null
	 * @param hand
	 * @return
	 */
	private Hand getStraight(Hand handToCheck){
		Hand hand = new FiveCardHand(handToCheck); //Make copy of the object so original doesn't get modified
		log.debug("getStraight(hand = "+hand+")");
		if(hand == null){
			log.debug("Hand was null. Returning null");
			return null;
		}
		ArrayList<Card> cards = hand.getCards();
		if(cards == null){
			log.debug("The ArrayList<Card> inside the Hand Object was NULL. Returning null");
			return null;
		}
		log.debug("Number of cards in Hand: "+cards.size());
		Set<CardNumber> set = new HashSet<CardNumber>(hand.getNumberValues());
		if(set.size()<5){
			log.debug("Only "+set.size()+" unique numbers");
			return null;
		}
		List<CardNumber> sorted = CollectionHelper.asSortedList(set);
		
		Hand numberInSequence = new FiveCardHand();
		if(sorted.size()>1){
			//Inch worm a long, adding hands as this will handle more than 5 cards
			numberInSequence.addHand(hand.getSubHandHavingNumber(sorted.get(0)));
			for(int i=1; i<sorted.size();i++){
				if(CardUtil.areCardNumbersSequential(sorted.get(i-1),sorted.get(i))){
					numberInSequence.addHand(hand.getSubHandHavingNumber(sorted.get(i)));
				}
				else{
					numberInSequence = hand.getSubHandHavingNumber(sorted.get(i));
				}
			}
			 //Check wrap around, (example: Ace)
			if(CardUtil.areCardNumbersSequential(sorted.get(0),sorted.get(sorted.size()-1))){
				numberInSequence.addHand(hand.getSubHandHavingNumber(sorted.get(sorted.size()-1)));
			}
		}
		log.debug("Number of cards in sequence: "+numberInSequence.getCards().size());
		if(numberInSequence.getCards().size()>4){
			return numberInSequence;
		}
		return null;
	}
	
	
	/**
	 * Determines whether a hand has three cards with the same number value
	 * @param handToCheck
	 * @return
	 */
	public boolean hasThreeOfAKind(Hand handToCheck){
		Hand hand = new FiveCardHand(handToCheck); //Make copy of the object so original doesn't get modified
		log.debug("hasThreeOfAKind(hand = "+hand+")");
		if(getThreeOfAKind(hand)!=null){
			return true;
		}
		
		return false;

	}
	
	/**
	 * If there is three of a kind return the number which there are three of
	 * otherwise, return null
	 * @param hand
	 * @return
	 */
	private Hand getThreeOfAKind(Hand handToCheck){
		Hand hand = new FiveCardHand(handToCheck); //Make copy of the object so original doesn't get modified
		log.debug("getThreeOfAKind(hand = "+hand+")");
		if(hand == null){
			log.debug("Hand was null. Returning null");
			return null;
		}
		ArrayList<Card> cards = hand.getCards();
		if(cards == null){
			log.debug("The ArrayList<Card> inside the Hand Object was NULL. Returning null");
			return null;
		}
		log.debug("Number of cards in Hand: "+cards.size());
		
		
		Set<CardNumber> set = new HashSet<CardNumber>(hand.getNumberValues());
		for (CardNumber num : set){
			//See how many of this number there are 
			int n = Collections.frequency(hand.getNumberValues(),num);
			log.trace("There are "+n+" '"+num+"'s");
			if(n>2){
				FiveCardHand h = new FiveCardHand();
				for (Card c : hand.getCards()){
					if(c.getNumber().equals(num) ){
						h.addCard(c);
					}
				}
				return h;

			}
		}		
		return null;
	}
	
	//TODO think about if having four of a kind is also considered two pair
	/**
	 * Determines whether a hand has two sets of two cards with the same number value
	 * @param handToCheck
	 * @return
	 */
	public boolean hasTwoPair(Hand handToCheck){
		Hand hand = new FiveCardHand(handToCheck); //Make copy of the object so original doesn't get modified
		Hand firstPair = getPair(hand);
		if(firstPair == null){
			return false;
		}
		log.debug("First Pair = "+firstPair);
		hand.removeHand(firstPair);
		Hand secondPair = getPair(hand);
		if(secondPair == null){
			return false;
		}
		log.debug("Second Pair = "+secondPair);

		log.debug("returning true");
		return true;
	}
	/**
	 * Determines whether a hand has two cards with the same number value
	 * @param handToCheck
	 * @return
	 */
	public boolean hasPair(Hand handToCheck){
		Hand hand = new FiveCardHand(handToCheck); //Make copy of the object so original doesn't get modified
		log.debug("hasPair(hand = "+hand+")");
		if(getPair(hand)!=null){
			return true;
		}
		return false;
	}
	
	/**
	 * If there is three of a kind return the number which there are three of
	 * otherwise, return null
	 * @param hand
	 * @return
	 */
	private Hand getPair(Hand handToCheck){
		Hand hand = new FiveCardHand(handToCheck); //Make copy of the object so original doesn't get modified
		log.debug("getPair(hand = "+hand+")");
		if(hand == null){
			log.debug("Hand was null. Returning null");
			return null;
		}
		ArrayList<Card> cards = hand.getCards();
		if(cards == null){
			log.debug("The ArrayList<Card> inside the Hand Object was NULL. Returning null");
			return null;
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
					ArrayList<Card> ca = new ArrayList<Card>();
					ca.add(c1);
					ca.add(c2);
					return new FiveCardHand(ca);
				}
				log.trace("\tNo.!");
				
			}
		}
		log.debug("returning null");
		return null;
	}
	
	

}
