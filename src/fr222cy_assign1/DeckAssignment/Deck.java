package fr222cy_assign1.DeckAssignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr222cy_assign1.DeckAssignment.Card.Rank;
import fr222cy_assign1.DeckAssignment.Card.Suite;

public class Deck {
	private List<Card> deck = new ArrayList<>(); 
	
	public Deck(){
		
		  for (Card.Suite suite: Card.Suite.values())
	        {
			  	int value = 1;
	            for (Card.Rank rank: Card.Rank.values())
	            {
	                deck.add(new Card(suite, rank, value));
	                value++;
	            }
	        }			
	}
	
	public void ShuffleDeck(){
		if(deck.size() == 52){
			Collections.shuffle(deck);
			return;
		}
		System.out.println("Can't shuffle deck, since it not contains 52 cards");
	}
	
	public Card handOutNextCard(){
		
		Card handOut = deck.get(0);
		deck.remove(0);
		return handOut;
	}
	
	public int deckSize(){
		return deck.size();
	}
	
}
