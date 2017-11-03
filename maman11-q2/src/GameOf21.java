import javax.swing.JOptionPane;

public class GameOf21 {

	private DeckOfCards gameDeck;
	// private DeckOfCards playerHand;
	// private DeckOfCards computerHand;
	private static final boolean EMPTY = false;
	private static final boolean FULL = true;
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
	private static final int START = 0;

	public GameOf21() {
		// this.gameDeck = new DeckOfCards(FULL);
		// this.playerHand = new DeckOfCards(EMPTY);
		// this.computerHand = new DeckOfCards(EMPTY);

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

				if (player1.play(dealtCard, this.getCardValue(dealtCard)) == false) {
					player1InGame = false;
					player2InGame = player2.play(dealtCard, this.getCardValue(dealtCard));

				}

			}
			
			

		}

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
