package com.gmatney.playingcard;

import com.gmatney.playingcard.util.CardName;
import com.gmatney.playingcard.util.CardUtil;

public class Card implements Comparable<Card>{
	private CardNumber number;
	private CardSuit suit;
	private CardColor color;
	private String alternativeName;
	
	public Card(CardNumber number, CardSuit suit, CardColor color,
			String alternativeName) {
		super();
		this.number = number;
		this.suit = suit;
		this.color = color;
		this.alternativeName = alternativeName;
	}
	
	public Card(CardNumber number, CardSuit suit) {
		super();
		this.number = number;
		this.suit = suit;
	}

	public CardColor getColor() {
		return color;
	}

	public void setColor(CardColor color) {
		this.color = color;
	}

	public String getAlternativeName() {
		return alternativeName;
	}

	public void setAlternativeName(String alternativeName) {
		this.alternativeName = alternativeName;
	}

	public CardNumber getNumber() {
		return number;
	}

	public void setNumber(CardNumber number) {
		this.number = number;
	}

	public CardSuit getSuit() {
		return suit;
	}

	public void setSuit(CardSuit suit) {
		this.suit = suit;
	}

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
