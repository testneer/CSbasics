package crackingTheCodeInterview.ood.deckOfCards;

public abstract class Card {
	protected final Suit suit;
	protected final CardColour colour;
	protected final int number;
	protected int value;
	
	public enum CardColour{
		RED,
		BLACK;
	}
	
	public Card(Suit suit, CardColour colour, int number) {
		this.suit = suit;
		this.colour = colour;
		this.number = number;
	}
	
	public abstract int getValue(int value);
	
}
