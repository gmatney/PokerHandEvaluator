package com.gmatney.playingcard.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;

import com.gmatney.playingcard.CardSuit;

public class CollectionHelper {
	private static Logger log = Logger.getLogger(CollectionHelper.class);
	
	/**
	 * Generic function from stack overflow
	 * http://stackoverflow.com/questions/740299/how-do-i-sort-a-set-to-a-list-in-java
	 * @param <T>
	 * @param c
	 * @return
	 */
	public static <T extends Comparable<? super T>> List<T> asSortedList(Collection<T> c) {
		List<T> list = new ArrayList<T>(c);
		java.util.Collections.sort(list);
		log.trace("Sorted List = "+list.toString());
		return list;
	}
	
	/**
	 *  Allows sorting of ENUMs by rules
	 * @param <T>
	 * @param c
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<? super T>> List<T> asSortedList(ArrayList<CardSuit> list) {
		ArrayList<CardSuitComparable> a = new ArrayList<CardSuitComparable>();
		for (CardSuit cs: list){
			a.add( new CardSuitComparable(cs));
		}
		
		java.util.Collections.sort(a);
		
		//Rebuild the list
		List<T> newlist = new ArrayList<T>();
		for (CardSuitComparable cs: a){
			newlist.add( (T)cs.getCardSuit());
		}
		
		
		log.trace("Sorted List = "+list.toString());
		return newlist;
	}
}
