import javax.swing.JOptionPane;

public class GameOf21 {

	private DeckOfCards gameDeck;

	
	
	//DECK CONSTANTS
	private static final boolean EMPTY = false;
	private static final boolean FULL = true;
	
	//CARDS VALUES CONSTANTS
	private static final int NONE_VALUE = 0;
	private static final int ACE_VALUE = 1;
	private static final int DEUCE_VALUE = 2;
	private static final int THREE_VALUE = 3;
	private static final int FOUR_VALUE = 4;
	private static final int FIVE_VALUE = 5;
	private static final int SIX_VALUE = 6;
	private static final int SEVEN_VALUE = 7;
	private static final int EIGHT_VALUE = 8;
	private static final int NINE_VALUE = 9;
	private static final int TEN_VALUE = 10;
	
	//GAME START CONSTANT
	private static final int START = 0;
	
	//GAME SUMMARY CONSTANTS
	private static final int BOTH_WON = 3;
	private static final int PLAYER1_WON = 1;
	private static final int PLAYER2_WON = 2;
	private static final int NONE_WON = 4;

	public GameOf21() {
		this.startGame();
	}

	public void startGame() {

		Player21 player1 = new Player21(true);
		Player21 player2 = new Player21(false);

		while (JOptionPane.showConfirmDialog(null,
				"Welcome to the OpenU Casino, Would you like to start a new  21 game?") == START) {
			boolean player1InGame = true;
			boolean player2InGame = true;
			this.gameDeck = new DeckOfCards(FULL);
			this.gameDeck.shuffle();

			while (player1InGame == true || player2InGame == true) {
				Card dealtCard = this.gameDeck.dealCard();

				if (player1InGame == true) 
				{
					player1InGame = player1.play(dealtCard, this.getCardValue(dealtCard));

					if (player1InGame == true)
						dealtCard = this.gameDeck.dealCard();
				}
					player2InGame = player2.play(dealtCard, this.getCardValue(dealtCard));

				

			}
			

			this.gameResult(player1, player2);

		}

	}

	public void gameResult(Player21 player1, Player21 player2) {
		int player1Hand = player1.getTotalHand();
		int player2Hand = player2.getTotalHand();

		if (player2Hand == 21 && player1Hand == 21)
			this.winner(BOTH_WON, player1.getHand(), player2.getHand());
		else if (player2Hand > 21 && player1Hand > 21)
			this.winner(NONE_WON, player1.getHand(), player2.getHand());
		else if (player1Hand == 21 || (player2Hand > 21 && player1Hand < 21) || player1Hand > player2Hand)
			this.winner(PLAYER1_WON, player1.getHand(), player2.getHand());
		else if (player2Hand == 21 || (player1Hand > 21 && player2Hand < 21) || player2Hand > player1Hand)
			this.winner(PLAYER2_WON, player1.getHand(), player2.getHand());

	}

	public void winner(int whoWon, String player1Deck, String player2Deck) {

		if (whoWon == NONE_WON)
			JOptionPane.showMessageDialog(null, "No One won! " + System.lineSeparator() + "Player1 Hand was :"
					+ player1Deck + System.lineSeparator() + "Player2 Hand was: " + player2Deck);
		else if (whoWon == BOTH_WON)
			JOptionPane.showMessageDialog(null, "Both players won! " + System.lineSeparator() + "Player1 Hand was :"
					+ player1Deck + System.lineSeparator() + "Player2 Hand was: " + player2Deck);
		else

		if (whoWon == PLAYER1_WON)
			JOptionPane.showMessageDialog(null, "Player1 won! " + System.lineSeparator() + "Player1 Hand was :"
					+ player1Deck + System.lineSeparator() + "Player2 Hand was: " + player2Deck);
		else

		if (whoWon == PLAYER2_WON)
			JOptionPane.showMessageDialog(null, "Player2 won! " + System.lineSeparator() + "Player1 Hand was :"
					+ player1Deck + System.lineSeparator() + "Player2 Hand was: " + player2Deck);

	}

	// This method is placed inside GameOf21 class and not Card class , since the
	// value of
	// the card is relevant for the rules of this specific game - and are not
	// universal for every card game.
	public int getCardValue(Card aCard) {

		if (aCard != null) {

			String cardFace = aCard.getFace();

			if (cardFace.equals("Ace")) {
				return ACE_VALUE;
			}
			if (cardFace.equals("Deuce")) {
				return DEUCE_VALUE;
			}
			if (cardFace.equals("Three")) {
				return THREE_VALUE;
			}
			if (cardFace.equals("Four")) {
				return FOUR_VALUE;
			}
			if (cardFace.equals("Five")) {
				return FIVE_VALUE;
			}
			if (cardFace.equals("Six")) {
				return SIX_VALUE;
			}
			if (cardFace.equals("Seven")) {
				return SEVEN_VALUE;
			}
			if (cardFace.equals("Eight")) {
				return EIGHT_VALUE;
			}
			if (cardFace.equals("Nine")) {
				return NINE_VALUE;
			}
			if (cardFace.equals("Ten") || cardFace.equals("Jack") || cardFace.equals("Queen")
					|| cardFace.equals("King")) {
				return TEN_VALUE;
			}

		}
		return NONE_VALUE;
	}

}
