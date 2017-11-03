
public class Program {

	public static void main(String[] args) {

		DeckOfCards deck = new DeckOfCards(true);

		deck.shuffle();

		System.out.println(deck.dealCard());

	}
}
