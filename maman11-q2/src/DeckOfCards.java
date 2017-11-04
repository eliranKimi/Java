import java.security.SecureRandom;
import java.util.ArrayList;

//THE BASE OF THE CLASS IS COPIED FROM SECTION 7.6 FROM THE BOOK
public class DeckOfCards {

	private ArrayList<Card> deck;
	private int currentCard;
	private static final int NUMBER_OF_CARDS = 52;
	private static final SecureRandom randomNumbers = new SecureRandom();
	private static final int NUMBER_OF_FACES = 13;

	public DeckOfCards(boolean full) {
		String[] faces = { "Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack",
				"Queen", "King" };

		String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };

		this.deck = new ArrayList<Card>();

		if (full == true) {

			this.currentCard = 0;

			for (int count = 0; count < NUMBER_OF_CARDS; count++) {
				this.deck.add(new Card(faces[count % NUMBER_OF_FACES], suits[count / NUMBER_OF_FACES]));

			}

		}
	}

	public void shuffle() {

		this.currentCard = 0;

		for (int first = 0; first < deck.size(); first++) {
			int second = randomNumbers.nextInt(NUMBER_OF_CARDS);

			Card temp = deck.get(first);
			deck.set(first, deck.get(second));
			deck.set(second, temp);

		}
	}

	public Card dealCard() {
		if (currentCard < deck.size())
			return deck.get(currentCard++);
		else
			return null;

	}

	public void addCard(Card newCard) {
		if (newCard != null) {
			this.deck.add(newCard);
		} else {
			System.out.println("ERR: EMPTY Card object!");
		}

	}

	@Override
	public String toString() {
		return this.deck.toString();

	}

}
