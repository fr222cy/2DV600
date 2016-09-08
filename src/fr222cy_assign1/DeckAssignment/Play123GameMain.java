package fr222cy_assign1.DeckAssignment;
/**
 * @author Filip Rydberg
 *
 */
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Play123GameMain {

	public static void main(String[] args) {
		int wins = 0;
		int losses = 0;
		final int plays = 10000;
		
		for(int i = 0; i < plays; i++){
			
			Deck deck = new Deck();
		    deck.ShuffleDeck(); 
			int counter = 1;
			if(play123(counter,deck)){
				wins++;
			}
			else{
				losses++;
			}
			
		}
		
		double probability = ((double)wins / plays) *100;
		DecimalFormat df = new DecimalFormat("#.##");
		System.out.println("Wins: "+wins);
		System.out.println("Losses: "+losses);
		System.out.println("The probability of winning is: "+df.format(probability)+"%");

	}
	
	static boolean play123(int counter, Deck deck){
		for(int y = 0; y < 52; y++){
			if(counter > 3){
				counter = 1;
			}
			
			Card card = deck.handOutNextCard();
			
			if(card.getValue() == counter){
			
				return false;
			}
			counter++;
		}	
		return true;
	}
	
	

}
