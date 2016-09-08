package fr222cy_assign1.DeckAssignment;
/**
 * @author Filip Rydberg
 *
 */
public class PlayCardsMain {

	public static void main(String[] args) {
		Deck deck = new Deck();
		
		System.out.println(deck.deckSize());
		deck.ShuffleDeck();
				
		for (int i = 1; i < 11; i++){
			Card card = deck.handOutNextCard();
			System.out.println("Card "+i+": "+ card.getRank() + " " + card.getSuite()+ " " + card.getValue());
		}
		System.out.println("Cards in deck:"+deck.deckSize());
	}

}
