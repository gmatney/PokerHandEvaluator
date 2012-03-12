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
import com.gmatney.poker.hand.FiveCardSamples;

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
	
	public void testHasStraightFlush(){
		FiveCardRanking r = new FiveCardRanking();

	}	
	public void testHasFourOfAKind(){
		FiveCardRanking r = new FiveCardRanking();
		assertFalse("This was not a FourOfAKind: "
				,r.hasFourOfAKind(FiveCardSamples.getTwoPairAA55()));
		assertFalse("This was not a FourOfAKind: "
				,r.hasFourOfAKind(FiveCardSamples.getThreeOfAKind7()));
		assertFalse("This was not a FourOfAKind: "
				,r.hasFourOfAKind(FiveCardSamples.getFullHouseLow()));
		assertTrue("This was a FourOfAKind: "
				,r.hasFourOfAKind(FiveCardSamples.getFourOfAKindAceSequentialHavingKing()));
	}
	
	public void testHasFullHouse(){
		FiveCardRanking r = new FiveCardRanking();		
		assertFalse("This was not a FullHouse: ",
				r.hasFullHouse(FiveCardSamples.getThreeOfAKindNotFullHouse()));
		assertFalse("This was not a FullHouse: ",
				r.hasFullHouse(FiveCardSamples.getTwoPairNoHouse()));
		assertTrue("This was a FullHouse: "
				,r.hasFullHouse(FiveCardSamples.getFullHouseHigh()));
		assertTrue("This was a FullHouse: "
				,r.hasFullHouse(FiveCardSamples.getFullHouseLow()));
	}
	
	public void testHasFlush(){
		FiveCardRanking r = new FiveCardRanking();
		assertFalse("This was not a flush"
				,r.hasFlush(FiveCardSamples.getThreeOfAKind7()));
		assertFalse("This was not a flush"
				,r.hasFlush(FiveCardSamples.getPairOfAces()));
		assertTrue("This was a flush of diamonds"
				,r.hasFlush(FiveCardSamples.getFlushDiamondNotStraight()));
		assertTrue("This was a flush of heart"
				,r.hasFlush(FiveCardSamples.getFlushHeartNotStraight()));
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
		assertTrue("Ace as high not deemeed straight"
				,r.hasStraight(FiveCardSamples.getStraightHighNum()));
		assertTrue("Ace as low not deemeed straight"
				,r.hasStraight(FiveCardSamples.getStraightHighNum()));
		assertFalse("Wrap around straight deemeed a straight"
				,r.hasStraight(FiveCardSamples.getStraightNOTWrapAroundFalse()));
		assertFalse("Not a straight deemeed a straight"
				,r.hasStraight(FiveCardSamples.getFourOfAKindAceSequentialHavingKing()));
	}
	
	//TODO override assert logic so that logging output is more verbose for better debugging.
	public void testHasThreeOfAKind(){
		FiveCardRanking r = new FiveCardRanking();
		assertFalse("The Ranking System inaccurately said this had three of a kind"
				,r.hasThreeOfAKind(FiveCardSamples.getTwoPairAA55()));
		assertFalse("The Ranking System inaccurately said this had three of a kind"
				,r.hasThreeOfAKind(FiveCardSamples.getPairOfAces()));
		assertTrue("The Ranking System did not see three of a kind."
				,r.hasThreeOfAKind(FiveCardSamples.getThreeOfAKind7()));
		//Having four of a kind also means you have three of a kind
		assertTrue("The Ranking System did not see three of a kind."
				,r.hasThreeOfAKind(FiveCardSamples.getFourOfAKindAceSequentialHavingKing()));
	}
	
	public void testHasTwoPair(){
		FiveCardRanking r = new FiveCardRanking();
		assertTrue("The Ranking System inaccurately said this did not have two pairs"
				,r.hasTwoPair(FiveCardSamples.getTwoPairAA55()));
		assertFalse("The Ranking System inaccurately said this had two pairs"
				,r.hasTwoPair(FiveCardSamples.getPairOfAces()));
		assertFalse("The Ranking System inaccurately though 3 of a kind was two pair"
				,r.hasTwoPair(FiveCardSamples.getThreeOfAKind7()));
	}
	
	public void testHasPair(){
		FiveCardRanking r = new FiveCardRanking();
		assertTrue("The Ranking System inaccurately said this did not have a pair: "
				,r.hasPair(FiveCardSamples.getPairOfAces()));
		assertFalse("The Ranking System inaccurately said this had a pair"
				,r.hasPair(FiveCardSamples.getEightHigh()));
	}
}
