import javax.swing.JOptionPane;

public class GameOf21 {
	
	private DeckOfCards gameDeck;
	private DeckOfCards playerHand;
	private DeckOfCards computerHand;
	private static final boolean EMPTY = false;
	private static final boolean FULL = true;

	
	public GameOf21()
	{
		this.gameDeck= new DeckOfCards(FULL);
		this.playerHand = new DeckOfCards(EMPTY);
		this.computerHand = new DeckOfCards(EMPTY);
		
		this.startGame();
	}
	
	
	public void startGame()
	{
		JOptionPane.showConfirmDialog(null, "Would you like to start a new game?");
		
	}
	
	public int getCardValue(Card aCard)
	{
		return 0;
	}
	
	
}
