package com.gmatney.poker.hand;

import java.util.ArrayList;
import com.gmatney.playingcard.Card;
import com.gmatney.playingcard.CardNumber;
import com.gmatney.playingcard.CardSuit;

public interface Hand {
	public ArrayList<Card> getCards();
	
	/**
	 * 
	 * @return
	 */
	public int getHandValue();
	public Rank getHandRank();
	public boolean isHandValid();
	public void setCards(ArrayList<Card> cards);
	public ArrayList<CardNumber> getNumberValues();
	public ArrayList<CardSuit> getSuitValues();
	

	
}
