package fr222cy_assign1.DeckAssignment;

public class Card {
	
	public enum Suite  {
		Heart, Spades, Diamonds, Clubs;
	}
	
	public enum Rank {
		Ace, Two, Three, Four, Five, Six, Seven,
		Eight, Nine, Ten, Jack, Queen, King;
	}
	
	private Suite _suite;
	private Rank _rank;
	private int _value;
	
	public Card(Suite suite, Rank rank, int value){
		
		_suite = suite;
		_rank = rank;
		_value = value;
	}
	
	public Suite getSuite(){
		return _suite;
	}
	
	public Rank getRank(){
		return _rank;
	}
	
	public int getValue(){
		return _value;
	}
	
}
