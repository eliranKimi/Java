import javax.swing.JOptionPane;

public class Player21 {

	private DeckOfCards playerHand;
	private boolean human;
	private boolean gotAce;
	private int totalHandValue;
	private static final boolean EMPTY = false;
	private static final boolean FULL = true;
	private static final int HITME = 0;

	public Player21(boolean isHuman) {
		this.playerHand = new DeckOfCards(EMPTY);
		this.human = isHuman;
		this.totalHandValue = 0;
		this.gotAce = false;

	}

	public boolean play(Card aCard, int cardValue) {
		if (human == true) {
			if (JOptionPane.showConfirmDialog(null, "Your hand is : " + this.playerHand.toString()
					+ System.lineSeparator() + "Would you like me to HIT you?") == HITME) {
				this.playerHand.addCard(aCard);
				this.gotAce = isItAce(aCard);
				this.totalHandValue = this.totalHandValue + cardValue;
				return true;

			}
		} else {
			return this.computerStrategy(aCard, cardValue);
		}

		return false;

	}

	public boolean computerStrategy(Card aCard, int cardValue) {
		
		if ( this.totalHandValue <= 17)
		{
			this.playerHand.addCard(aCard);
			this.gotAce = isItAce(aCard);
			this.totalHandValue = this.totalHandValue + cardValue;
			return true;
			
		}
		return false;
		
	}
	
	private boolean isItAce(Card aCard)
	{
		return (aCard.getFace().equals("Ace"));
	}

	public int getTotalHand() {
		if (this.gotAce == true && this.totalHandValue + 10 <= 21) {
			return this.totalHandValue + 10;
		} else {
			return this.totalHandValue;
		}
	}

	public String getHand() {
		// TODO Auto-generated method stub
		return this.playerHand.toString();
	}

}
