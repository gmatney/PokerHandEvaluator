package com.gmatney.poker.hand;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
	public boolean isHandValid() {
		log.debug("Validating Hand - "+this);
		if(cards==null){
			return false;
		}
		if(cards.size() != NUMBER_OF_CARDS){
			log.info("HAND INVALID: Incoming hand does not have exactly "
					+NUMBER_OF_CARDS
					+" cards. It has "
					+cards.size()
			);
			return false;
		}
		Set<Card> set = new HashSet<Card>(cards);
		if(set.size() < cards.size()  ){
			log.info("There was at least 1 duplicate of a card!");
			return false;
		}
		return true;
	}

	/**
	 * Sample output: (AC,AD,7H,5S,4S) 
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
	
	@Override
	/**
	 * Will add the cards in this hand to the current hand.
	 * It will NOT ignore duplicates. (some games might be ok with dups)
	 */
	public void addHand(Hand h) {
		for(Card c: h.getCards()){
			this.cards.add(c);
		}		
	}
	
	@Override
	/**
	 * Will remove any of the following cards from the current hand.
	 * It is okay if the current hand does not have the card.
	 */
	public void removeHand(Hand h) {
		for(Card c: h.getCards()){
			this.cards.remove(c);
		}
		
	}
	
	@Override
	public Hand getSubHandHavingNumber(CardNumber cn) {
		if(cn==null){
			return null;
		}
		FiveCardHand subHand = new FiveCardHand();
		for(Card c: cards){
			if(c.getNumber().equals(cn))
			{
				subHand.addCard(c);
			}
		}
		return subHand;
	}
	
	@Override
	public Hand getSubHandHavingSuit(CardSuit cs) {
		if(cs==null){
			return null;
		}
		FiveCardHand subHand = new FiveCardHand();
		for(Card c: cards){
			if(c.getNumber().equals(cs))
			{
				subHand.addCard(c);
			}
		}
		return subHand;
	}
	
}
