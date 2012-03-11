/**
 * 
 */
package com.gmatney.card;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import com.gmatney.playingcard.Card;
import com.gmatney.playingcard.CardNumber;
import com.gmatney.playingcard.CardSuit;
import com.gmatney.poker.hand.FiveCardHand;
import com.gmatney.poker.hand.FiveCardRanking;

/**
 * @author gmatney
 *
 */
public class TestFiveCardRanking extends TestCase{

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("##############################################################");
		System.out.println("# setUp() called "+this.getName());
		System.out.println("##############################################################");
	}

	@After
	public void tearDown() throws Exception {
	}
	
	public void testHasFlush(){
		FiveCardRanking r = new FiveCardRanking();

		//Hands to test
		FiveCardHand notAFlush1 = new FiveCardHand();
		FiveCardHand notAFlush2 = new FiveCardHand();
		FiveCardHand diamondFlush = new FiveCardHand();
		FiveCardHand heartFlush = new FiveCardHand();
		
		notAFlush1.addCard(new Card(CardNumber.ACE, CardSuit.CLUB));
		notAFlush1.addCard(new Card(CardNumber.TWO, CardSuit.DIAMOND));
		notAFlush1.addCard(new Card(CardNumber.THREE, CardSuit.HEART));
		notAFlush1.addCard(new Card(CardNumber.FOUR, CardSuit.SPADE));
		notAFlush1.addCard(new Card(CardNumber.FIVE, CardSuit.SPADE));

		notAFlush2.addCard(new Card(CardNumber.TEN, CardSuit.CLUB));
		notAFlush2.addCard(new Card(CardNumber.KING, CardSuit.SPADE));
		notAFlush2.addCard(new Card(CardNumber.QUEEN, CardSuit.HEART));
		notAFlush2.addCard(new Card(CardNumber.JACK, CardSuit.SPADE));
		notAFlush2.addCard(new Card(CardNumber.TEN, CardSuit.SPADE));
		
		diamondFlush.addCard(new Card(CardNumber.ACE, CardSuit.DIAMOND));
		diamondFlush.addCard(new Card(CardNumber.TWO, CardSuit.DIAMOND));
		diamondFlush.addCard(new Card(CardNumber.QUEEN, CardSuit.DIAMOND));
		diamondFlush.addCard(new Card(CardNumber.JACK, CardSuit.DIAMOND));
		diamondFlush.addCard(new Card(CardNumber.SEVEN, CardSuit.DIAMOND));
		
		heartFlush.addCard(new Card(CardNumber.ACE, CardSuit.HEART));
		heartFlush.addCard(new Card(CardNumber.KING, CardSuit.HEART));
		heartFlush.addCard(new Card(CardNumber.QUEEN, CardSuit.HEART));
		heartFlush.addCard(new Card(CardNumber.JACK, CardSuit.HEART));
		heartFlush.addCard(new Card(CardNumber.EIGHT, CardSuit.HEART));
		
		assertFalse("This was not a flush",r.hasFlush(notAFlush2));
		assertFalse("This was not a flush",r.hasFlush(notAFlush1));
		assertTrue("This was a flush of diamonds",r.hasFlush(diamondFlush));
		assertTrue("This was a flush of heart",r.hasFlush(heartFlush));
	}
	
	/**
	 * http://en.wikipedia.org/wiki/List_of_poker_hands
	 * A straight is a poker hand such as QC JS 10S 9H 8H, that contains five cards of sequential rank in at least two different suits.
	 * Two straights are ranked by comparing the highest card of each. 
	 * Two straights with the same high card are of equal value, suits are not used to separate them.
	 * Straights are described by their highest card, as in "ten-high straight" or "straight to the ten" for 10C 9D 8H 7C 6S.
	 * 
	 * A hand such as AC KC QD JS 10S is an ace-high straight (also known as Broadway or Royal straight), 
	 * and ranks above a king-high straight such as KH QS JH 10H 9C. 
	 * The ace may also be played as a low card (having a value of "1") 
	 * in a five-high straight such as 5S 4D 3D 2S AH, which is colloquially known as a wheel. The ace may not "wrap around", 
	 * or play both high and low; 3S 2D AH KS QC is not a straight.
	 */
	public void testHasStraight(){
		FiveCardRanking r = new FiveCardRanking();

		//Hands to test
		FiveCardHand lowNumStraight = new FiveCardHand();
		FiveCardHand highNumStraight = new FiveCardHand();
		FiveCardHand wrapAroundFalseStraight = new FiveCardHand();
		FiveCardHand notAStraight = new FiveCardHand();
		
		lowNumStraight.addCard(new Card(CardNumber.ACE, CardSuit.CLUB));
		lowNumStraight.addCard(new Card(CardNumber.TWO, CardSuit.DIAMOND));
		lowNumStraight.addCard(new Card(CardNumber.THREE, CardSuit.HEART));
		lowNumStraight.addCard(new Card(CardNumber.FOUR, CardSuit.SPADE));
		lowNumStraight.addCard(new Card(CardNumber.FIVE, CardSuit.SPADE));
		
		highNumStraight.addCard(new Card(CardNumber.ACE, CardSuit.CLUB));
		highNumStraight.addCard(new Card(CardNumber.KING, CardSuit.DIAMOND));
		highNumStraight.addCard(new Card(CardNumber.QUEEN, CardSuit.HEART));
		highNumStraight.addCard(new Card(CardNumber.JACK, CardSuit.SPADE));
		highNumStraight.addCard(new Card(CardNumber.TEN, CardSuit.SPADE));
		
		wrapAroundFalseStraight.addCard(new Card(CardNumber.ACE, CardSuit.CLUB));
		wrapAroundFalseStraight.addCard(new Card(CardNumber.KING, CardSuit.DIAMOND));
		wrapAroundFalseStraight.addCard(new Card(CardNumber.QUEEN, CardSuit.HEART));
		wrapAroundFalseStraight.addCard(new Card(CardNumber.JACK, CardSuit.SPADE));
		wrapAroundFalseStraight.addCard(new Card(CardNumber.TWO, CardSuit.SPADE));
		
		notAStraight.addCard(new Card(CardNumber.ACE, CardSuit.CLUB));
		notAStraight.addCard(new Card(CardNumber.KING, CardSuit.DIAMOND));
		notAStraight.addCard(new Card(CardNumber.QUEEN, CardSuit.HEART));
		notAStraight.addCard(new Card(CardNumber.JACK, CardSuit.SPADE));
		notAStraight.addCard(new Card(CardNumber.EIGHT, CardSuit.SPADE));
		
		assertTrue("Ace as high not deemeed straight",r.hasStraight(highNumStraight));
		assertTrue("Ace as low not deemeed straight",r.hasStraight(lowNumStraight));
		assertFalse("Wrap around straight deemeed a straight",
				r.hasStraight(wrapAroundFalseStraight));
		assertFalse("Not a straight deemeed a straight",
				r.hasStraight(notAStraight));
	}
	
	//TODO override assert logic so that logging output is more verbose for better debugging.
	public void testHasThreeOfAKind(){
		FiveCardRanking r = new FiveCardRanking();
		ArrayList<Card> cards = new ArrayList<Card>();
		
		cards.add(new Card(CardNumber.ACE, CardSuit.CLUB));
		cards.add(new Card(CardNumber.ACE, CardSuit.DIAMOND));
		cards.add(new Card(CardNumber.FIVE, CardSuit.HEART));
		cards.add(new Card(CardNumber.FIVE, CardSuit.SPADE));
		cards.add(new Card(CardNumber.FOUR, CardSuit.SPADE));
		
		//Two Pair
		FiveCardHand hand = new FiveCardHand(cards);
		assertFalse("The Ranking System inaccurately said this had three of a kind"
				+hand,r.hasThreeOfAKind(hand));
		
		//One Pair
		hand.removeCard(new Card(CardNumber.ACE, CardSuit.CLUB));
		hand.addCard(new Card(CardNumber.TWO, CardSuit.CLUB));
		assertFalse("The Ranking System inaccurately said this had three of a kind"+hand,r.hasThreeOfAKind(hand));
		
		//Three of a kind  (because can have two matches across one)
		hand.removeCard(new Card(CardNumber.ACE, CardSuit.DIAMOND));
		hand.addCard(new Card(CardNumber.FIVE, CardSuit.DIAMOND));
		assertTrue("The Ranking System did not see three of a kind."+hand,r.hasThreeOfAKind(hand));

		//Having four of a kind also means you have three of a kind
		hand.removeCard(new Card(CardNumber.TWO, CardSuit.CLUB));
		hand.addCard(new Card(CardNumber.FIVE, CardSuit.CLUB));
		assertTrue("The Ranking System did not see three of a kind."+hand,r.hasThreeOfAKind(hand));
	}
	
	public void testHasTwoPair(){
		FiveCardRanking r = new FiveCardRanking();
		ArrayList<Card> cards = new ArrayList<Card>();
		
		cards.add(new Card(CardNumber.ACE, CardSuit.CLUB));
		cards.add(new Card(CardNumber.ACE, CardSuit.DIAMOND));
		cards.add(new Card(CardNumber.FIVE, CardSuit.HEART));
		cards.add(new Card(CardNumber.FIVE, CardSuit.SPADE));
		cards.add(new Card(CardNumber.FOUR, CardSuit.SPADE));
		
		//Two Pair
		FiveCardHand hand = new FiveCardHand(cards);
		assertTrue("The Ranking System inaccurately said this did not have two pairs"
				+hand,r.hasTwoPair(hand));
		
		//One Pair
		hand.removeCard(new Card(CardNumber.ACE, CardSuit.CLUB));
		hand.addCard(new Card(CardNumber.TWO, CardSuit.CLUB));
		assertFalse("The Ranking System inaccurately said this had two pairs"+hand,r.hasTwoPair(hand));
		
		//Three of a kind  (because can have two matches across one)
		hand.removeCard(new Card(CardNumber.ACE, CardSuit.DIAMOND));
		hand.addCard(new Card(CardNumber.FIVE, CardSuit.DIAMOND));
		assertFalse("The Ranking System inaccurately though 3 of a kind was two pair"+hand,r.hasTwoPair(hand));
	}
	
	public void testHasPair(){
		FiveCardRanking r = new FiveCardRanking();
		ArrayList<Card> cards = new ArrayList<Card>();
		
		cards.add(new Card(CardNumber.ACE, CardSuit.CLUB));
		cards.add(new Card(CardNumber.ACE, CardSuit.DIAMOND));
		cards.add(new Card(CardNumber.SEVEN, CardSuit.HEART));
		cards.add(new Card(CardNumber.FIVE, CardSuit.SPADE));
		cards.add(new Card(CardNumber.FOUR, CardSuit.SPADE));
		
		FiveCardHand hand = new FiveCardHand(cards);
		assertTrue("The Ranking System inaccurately said this did not have a pair: "+hand,r.hasPair(hand));
		
		hand.removeCard(new Card(CardNumber.ACE, CardSuit.CLUB));
		hand.addCard(new Card(CardNumber.TWO, CardSuit.CLUB));
		assertFalse("The Ranking System inaccurately said this had a pair"+hand,r.hasPair(hand));
	}
}
