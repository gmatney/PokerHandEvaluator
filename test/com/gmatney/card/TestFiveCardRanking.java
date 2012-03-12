/**
 * 
 */
package com.gmatney.card;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import com.gmatney.playingcard.Card;
import com.gmatney.playingcard.CardNumber;
import com.gmatney.playingcard.CardSuit;
import com.gmatney.poker.hand.FiveCardHand;
import com.gmatney.poker.hand.FiveCardRanking;
import com.gmatney.poker.hand.Rank;

/**
 * @author gmatney
 *
 */
public class TestFiveCardRanking extends TestCase{
	private static Logger log = Logger.getLogger(TestFiveCardRanking.class);
	
	private static FiveCardRanking ranker;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		log.info("# Setting FiveCardRanking ranker to NULL");
		ranker = null;
	}

	@Before
	public void setUp() throws Exception {
		log.info("##############################################################");
		log.info("# setUp() called "+this.getName());
		log.info("##############################################################");
		log.info("# Initializing FiveCardRanking ranker");
		ranker = new FiveCardRanking();
	}

	@After
	public void tearDown() throws Exception {
		log.info("# tearDown "+this.getName()+"\n\n");
		
	}
	
	/**
	 * MAIN
	 * The purpose of this Exercise
	 */
	public void testGetHandRank(){
		assertTrue("Royal Flush incorrectly identified",
				ranker.getHandRank(FiveCardSamples.getRoyalFlushHearts())
				.equals(Rank.ROYAL_FLUSH));
		assertTrue(" incorrectly identified",
				ranker.getHandRank(FiveCardSamples.getStraightFlushLowestClub())
				.equals(Rank.STRAIGHT_FLUSH));
		assertTrue(" incorrectly identified",
				ranker.getHandRank(FiveCardSamples.getFourOfAKindAceSequentialHavingKing())
				.equals(Rank.FOUR_OF_A_KIND));
		assertTrue(" incorrectly identified",
				ranker.getHandRank(FiveCardSamples.getFullHouseHigh())
				.equals(Rank.FULL_HOUSE));
		assertTrue(" incorrectly identified",
				ranker.getHandRank(FiveCardSamples.getFullHouseLow())
				.equals(Rank.FULL_HOUSE));
		assertTrue(" incorrectly identified",
				ranker.getHandRank(FiveCardSamples.getFlushDiamondNotStraight())
				.equals(Rank.FLUSH));
		assertTrue(" incorrectly identified",
				ranker.getHandRank(FiveCardSamples.getFlushHeartNotStraight())
				.equals(Rank.FLUSH));
		assertTrue(" incorrectly identified",
				ranker.getHandRank(FiveCardSamples.getStraightHighNum())
				.equals(Rank.STRAIGHT));
		assertTrue(" incorrectly identified",
				ranker.getHandRank(FiveCardSamples.getStraightLowNum())
				.equals(Rank.STRAIGHT));
		assertTrue(" incorrectly identified",
				ranker.getHandRank(FiveCardSamples.getThreeOfAKindNotFullHouse())
				.equals(Rank.THREE_OF_A_KIND));
		assertTrue(" incorrectly identified",
				ranker.getHandRank(FiveCardSamples.getThreeOfAKind7())
				.equals(Rank.THREE_OF_A_KIND));
		assertTrue(" incorrectly identified",
				ranker.getHandRank(FiveCardSamples.getTwoPairAA55())
				.equals(Rank.TWO_PAIR));
		assertTrue(" incorrectly identified",
				ranker.getHandRank(FiveCardSamples.getTwoPairNoHouse())
				.equals(Rank.TWO_PAIR));
		assertTrue(" incorrectly identified",
				ranker.getHandRank(FiveCardSamples.getPairOfAces())
				.equals(Rank.PAIR));
		assertTrue(" incorrectly identified",
				ranker.getHandRank(FiveCardSamples.getHighEight())
				.equals(Rank.HIGH_CARD));
	}
	
	public void testHasRoyalFlush(){
		assertFalse("Two pair is not a RoyalFlush: "
				,ranker.hasRoyalFlush(FiveCardSamples.getTwoPairAA55()));
		assertFalse("Wheel is not a RoyalFlush: "
				,ranker.hasRoyalFlush(FiveCardSamples.getStraightFlushNOTisWheel()));
		assertFalse("This was not a RoyalFlush: "
				,ranker.hasRoyalFlush(FiveCardSamples.getStraightNOTWrapAroundFalse()));
		assertFalse("This was a RoyalFlush: "
				,ranker.hasRoyalFlush(FiveCardSamples.getStraightFlushLowestClub()));
		assertTrue("This was a RoyalFlush: "
				,ranker.hasRoyalFlush(FiveCardSamples.getRoyalFlushHearts()));
	}
	
	public void testHasStraightFlush(){
		assertFalse("This was not a StraightFlush: "
				,ranker.hasStraightFlush(FiveCardSamples.getTwoPairAA55()));
		assertFalse("This was not a StraightFlush: "
				,ranker.hasStraightFlush(FiveCardSamples.getStraightFlushNOTisWheel()));
		assertFalse("This was not a StraightFlush: "
				,ranker.hasStraightFlush(FiveCardSamples.getStraightNOTWrapAroundFalse()));
		assertTrue("This was a StraightFlush: "
				,ranker.hasStraightFlush(FiveCardSamples.getStraightFlushLowestClub()));

	}	
	public void testHasFourOfAKind(){
		assertFalse("This was not a FourOfAKind: "
				,ranker.hasFourOfAKind(FiveCardSamples.getTwoPairAA55()));
		assertFalse("This was not a FourOfAKind: "
				,ranker.hasFourOfAKind(FiveCardSamples.getThreeOfAKind7()));
		assertFalse("This was not a FourOfAKind: "
				,ranker.hasFourOfAKind(FiveCardSamples.getFullHouseLow()));
		assertTrue("This was a FourOfAKind: "
				,ranker.hasFourOfAKind(FiveCardSamples.getFourOfAKindAceSequentialHavingKing()));
	}
	
	public void testHasFullHouse(){
		assertFalse("This was not a FullHouse: ",
				ranker.hasFullHouse(FiveCardSamples.getThreeOfAKindNotFullHouse()));
		assertFalse("This was not a FullHouse: ",
				ranker.hasFullHouse(FiveCardSamples.getTwoPairNoHouse()));
		assertTrue("This was a FullHouse: "
				,ranker.hasFullHouse(FiveCardSamples.getFullHouseHigh()));
		assertTrue("This was a FullHouse: "
				,ranker.hasFullHouse(FiveCardSamples.getFullHouseLow()));
	}
	
	public void testHasFlush(){
		assertFalse("This was not a flush"
				,ranker.hasFlush(FiveCardSamples.getThreeOfAKind7()));
		assertFalse("This was not a flush"
				,ranker.hasFlush(FiveCardSamples.getPairOfAces()));
		assertTrue("This was a flush of diamonds"
				,ranker.hasFlush(FiveCardSamples.getFlushDiamondNotStraight()));
		assertTrue("This was a flush of heart"
				,ranker.hasFlush(FiveCardSamples.getFlushHeartNotStraight()));
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
		assertTrue("Ace as high not deemeed straight"
				,ranker.hasStraight(FiveCardSamples.getStraightHighNum()));
		assertTrue("Ace as low not deemeed straight"
				,ranker.hasStraight(FiveCardSamples.getStraightHighNum()));
		assertFalse("Wrap around straight deemeed a straight"
				,ranker.hasStraight(FiveCardSamples.getStraightNOTWrapAroundFalse()));
		assertFalse("Not a straight deemeed a straight"
				,ranker.hasStraight(FiveCardSamples.getFourOfAKindAceSequentialHavingKing()));
	}
	
	//TODO override assert logic so that logging output is more verbose for better debugging.
	public void testHasThreeOfAKind(){
		assertFalse("The Ranking System inaccurately said this had three of a kind"
				,ranker.hasThreeOfAKind(FiveCardSamples.getTwoPairAA55()));
		assertFalse("The Ranking System inaccurately said this had three of a kind"
				,ranker.hasThreeOfAKind(FiveCardSamples.getPairOfAces()));
		assertTrue("The Ranking System did not see three of a kind."
				,ranker.hasThreeOfAKind(FiveCardSamples.getThreeOfAKind7()));
		//Having four of a kind also means you have three of a kind
		assertTrue("The Ranking System did not see three of a kind."
				,ranker.hasThreeOfAKind(FiveCardSamples.getFourOfAKindAceSequentialHavingKing()));
	}
	
	public void testHasTwoPair(){
		assertTrue("The Ranking System inaccurately said this did not have two pairs"
				,ranker.hasTwoPair(FiveCardSamples.getTwoPairAA55()));
		assertFalse("The Ranking System inaccurately said this had two pairs"
				,ranker.hasTwoPair(FiveCardSamples.getPairOfAces()));
		assertFalse("The Ranking System inaccurately though 3 of a kind was two pair"
				,ranker.hasTwoPair(FiveCardSamples.getThreeOfAKind7()));
	}
	
	public void testHasPair(){
		assertTrue("The Ranking System inaccurately said this did not have a pair: "
				,ranker.hasPair(FiveCardSamples.getPairOfAces()));
		assertFalse("The Ranking System inaccurately said this had a pair"
				,ranker.hasPair(FiveCardSamples.getHighEight()));
	}
}
