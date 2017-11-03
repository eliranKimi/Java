
public class Program {

	public static void main(String[] args) {

		DeckOfCards deck = new DeckOfCards();

		deck.shuffle();

		System.out.println(deck.dealCard());

	}
}
