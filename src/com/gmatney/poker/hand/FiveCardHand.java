package com.gmatney.poker.hand;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.gmatney.playingcard.Card;
import com.gmatney.playingcard.CardNumber;
import com.gmatney.playingcard.CardSuit;

public class FiveCardHand implements Hand{
	ArrayList<Card> cards;
	private final int NUMBER_OF_CARDS = 5;
	private Logger log = Logger.getLogger(FiveCardHand.class);
	
	/**
	 * Empty Constructor
	 * @param cards
	 */
	public FiveCardHand() {
		super();
		this.cards = new ArrayList<Card>();
	}
	/**
	 * Normal Constructor
	 * @param cards
	 */
	public FiveCardHand(ArrayList<Card> cards) {
		super();
		this.cards = cards;
	}
	
	public void removeCard(Card card){
		log.trace("Removing "+card.getShortName()+" from "+this);
		if(cards.contains(card)){
			cards.remove(cards.indexOf(card));
			log.debug("Removed "+card.getShortName()+" from the hand");
		}
		else{
			log.debug("Card "+card.getShortName()+" was not in the hand");
		}
	}
	public void addCard(Card card){
		if(cards==null){
			cards = new ArrayList<Card>();
		}
		cards.add(card);
		log.debug("Added Card "+card.getShortName()+" to the hand");
	}
	
	public void setCards(ArrayList<Card> cards){
		this.cards = cards;
	}

	/**
	 * Copy constructor
	 * @param another
	 */
	@SuppressWarnings("unchecked")
	public FiveCardHand(Hand another) {
		    this.setCards((ArrayList<Card>) another.getCards().clone());
		    //TODO figure out if can do better checking of cards
	}

	@Override
	public ArrayList<Card> getCards() {
		return cards;
	}

	@Override
	public Rank getHandRank() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getHandValue() {
		// TODO Auto-generated method stub
		return 0;
	}
	

	@Override
	public boolean isHandValid() {
		log.debug("Validating Hand");
		boolean isValid = true;
		if(cards.size() != NUMBER_OF_CARDS){
			log.info("HAND INVALID: Incoming hand does not have exactly "
					+NUMBER_OF_CARDS
					+" cards. It has "
					+cards.size()
			);
			isValid=false;
		}
		//TODO could put in interface
		
		return isValid;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		for(int i=0; i< cards.size(); i++){
			sb.append(cards.get(i).getShortName());
			if(i<cards.size()-1){//Don't put comma at very end
				sb.append(",");
			}
		}
		sb.append(")");
		return sb.toString();
	}
	@Override
	public ArrayList<CardNumber> getNumberValues() {
		ArrayList<CardNumber> numbers = new ArrayList<CardNumber>();
		for(int i=0;cards!=null && i<cards.size();i++){
			numbers.add(cards.get(i).getNumber());
		}
		return numbers;
	}
	@Override
	public ArrayList<CardSuit> getSuitValues() {
		ArrayList<CardSuit> suits = new ArrayList<CardSuit>();
		for(int i=0;cards!=null && i<cards.size();i++){
			suits.add(cards.get(i).getSuit());
		}
		return suits;
	}
	
	

	
	//TODO Have my own kind of Exceptions
	
}
