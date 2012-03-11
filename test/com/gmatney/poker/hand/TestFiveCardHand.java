/**
 * 
 */
package com.gmatney.poker.hand;


import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.Before;

import com.gmatney.playingcard.Card;
import com.gmatney.playingcard.CardNumber;
import com.gmatney.playingcard.CardSuit;
import com.gmatney.poker.hand.FiveCardHand;
import com.gmatney.poker.hand.FiveCardRanking;

/**
 * @author gmatney
 *
 */
public class TestFiveCardHand extends TestCase {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("##############################################################");
		System.out.println("# setUp() called "+this.getName());
		System.out.println("##############################################################");
	}
	
	/**
	 * 
	 */
	public void testIsHandValid(){
		
		//empty hand
		ArrayList<Card> cards = new ArrayList<Card>();
		FiveCardHand hand = new FiveCardHand(cards);
		assertFalse("Empty hand should not be considered Valid",hand.isHandValid());
		
		//Fewer than five
		cards.add(new Card(CardNumber.ACE, CardSuit.CLUB));
		cards.add(new Card(CardNumber.ACE, CardSuit.DIAMOND));
		hand = new FiveCardHand(cards);
		assertFalse("Empty hand should not be considered Valid",hand.isHandValid());
		
		//Correct number and all cards unique
		cards.add(new Card(CardNumber.SEVEN, CardSuit.HEART));
		cards.add(new Card(CardNumber.FIVE, CardSuit.SPADE));
		cards.add(new Card(CardNumber.FOUR, CardSuit.SPADE));
		hand = new FiveCardHand(cards);
		assertTrue("A correct hand was said to be invalid",hand.isHandValid());
		
		//Too many cards
		cards.add(new Card(CardNumber.KING, CardSuit.SPADE));
		assertFalse("A hand with too many cards was considered invalid",hand.isHandValid());
		
		//TODO add duplicate cards
	}
	
	public void testAddCard(){
		FiveCardHand hand = new FiveCardHand();
		hand.addCard(new Card(CardNumber.FOUR, CardSuit.SPADE));
		assertNotNull("Card ArrayList was NULL when it should have had one element",hand.getCards());
		assertSame("Card did not get added",hand.getCards().size(),1);
	}
	
	public void testRemoveCard(){
		ArrayList<Card> cards = new ArrayList<Card>();
		Card card = new Card(CardNumber.FOUR, CardSuit.SPADE);
		cards.add(card);
		FiveCardHand hand = new FiveCardHand(cards);
		assertSame("Card did not get added",hand.getCards().size(),1);
		hand.removeCard(card);
		assertNotNull("Card ArrayList was NULL when it should be an empty list",hand.getCards());
		assertSame("Card did not get removed",hand.getCards().size(),0);
	}
	
}
