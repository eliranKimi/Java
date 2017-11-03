
public class Card {
	
	private final String face;
	private final String suit;
	private int value;
	
	public Card(String cardFace, String cardSuit, int value)
	{
		this.face = cardFace;
		this.suit = cardSuit;
		this.value=value;
	}
	
	
	 
	public String toString()
	{
		return face +  " of " + suit + " Value=" + value;
	}
	

}
