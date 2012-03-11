package com.gmatney.playingcard;

import com.gmatney.playingcard.util.CardName;
import com.gmatney.playingcard.util.CardUtil;

public class Card implements Comparable<Card>{
	private CardNumber number;
	private CardSuit suit;
	private CardColor color;
	private String alternativeName;
	
	/**
	 * @param number
	 * @param suit
	 * @param color
	 * @param alternativeName
	 */
	public Card(CardNumber number, CardSuit suit, CardColor color,
			String alternativeName) {
		super();
		this.number = number;
		this.suit = suit;
		this.color = color;
		this.alternativeName = alternativeName;
	}
	
	/**
	 * @param number
	 * @param suit
	 */
	public Card(CardNumber number, CardSuit suit) {
		super();
		this.number = number;
		this.suit = suit;
	}

	/**
	 * @return the color
	 */
	public CardColor getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(CardColor color) {
		this.color = color;
	}
	/**
	 * @return the alternativeName
	 */
	public String getAlternativeName() {
		return alternativeName;
	}
	/**
	 * @param alternativeName the alternativeName to set
	 */
	public void setAlternativeName(String alternativeName) {
		this.alternativeName = alternativeName;
	}
	/**
	 * @return the number
	 */
	public CardNumber getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(CardNumber number) {
		this.number = number;
	}
	/**
	 * @return the suit
	 */
	public CardSuit getSuit() {
		return suit;
	}
	/**
	 * @param suit the suit to set
	 */
	public void setSuit(CardSuit suit) {
		this.suit = suit;
	}

	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((alternativeName == null) ? 0 : alternativeName.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (alternativeName == null) {
			if (other.alternativeName != null)
				return false;
		} else if (!alternativeName.equals(other.alternativeName))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (suit == null) {
			if (other.suit != null)
				return false;
		} else if (!suit.equals(other.suit))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return number + " of " + suit + "s";
	}
	
	
	
	
	public String getShortName(){
		return CardName.getShortName(this);
	}

	@Override
	public int compareTo(Card card) {
		
		if(this.equals(card)){
			return 0;
		}
		if(CardUtil.isCardRankedLessThanSecondCard(this.getNumber(),card.getNumber())){
			return -1;
		}
		return 1;

	}
	
	
}
