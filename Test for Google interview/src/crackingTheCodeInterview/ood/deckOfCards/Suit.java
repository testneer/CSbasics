package crackingTheCodeInterview.ood.deckOfCards;

public enum Suit{
	DIAMOND (0),
	SPADES (1),
	HEART (2),
	CLUBS (3);
	private int value;
	public int getValue() {
		return value;
	}
	private Suit(int v){
		this.value = v;
	}
	public Suit getSuitbyNum(int number){
		switch (number) {
		case 0:
			return DIAMOND;
		case 1:
			return SPADES;
		case 2:
			return HEART;
		case 3:
			return CLUBS;

		default:
			return Suit.DIAMOND;
		}
	}
}