package maman12;

import java.util.ArrayList;
import java.security.SecureRandom;

public class Program {

	private static final SecureRandom randomNumbers = new SecureRandom();
	private static final int RANGE_OF_NUMBERS = 52;
	private static final int RANDOM_GEN_NUM = 5;
	private ArrayList<Expression> expressions;

	public Program() {
		super();
		this.expressions = new ArrayList<Expression>();
		this.addRandomExpressions();
		this.printExpressions();
	}

	private void printExpressions() {

		for (int i = 0; i < expressions.size(); i++) {

			Expression expression = expressions.get(i);

			System.out.println("Expression " + i + ": " + expression + " and it the fact that he has an equal is "
					+ checkEquel(expression, i));

		}

	}

	private void addRandomExpressions() {
		for (int i = 0; i < RANDOM_GEN_NUM; i++) {
			Expression ex1 = new AtomicExpression(randomNumbers.nextInt(RANGE_OF_NUMBERS));
			Expression ex2 = new AtomicExpression(randomNumbers.nextInt(RANGE_OF_NUMBERS));
			expressions.add(ex1);
			expressions.add(new SubtractionExpression(ex1, ex2));
			expressions.add(new AdditionExpression(ex1, ex2));
		}
	}

	private boolean checkEquel(Expression expression, int givenIndex) {

		for (int j = 0; j < expressions.size(); j++) {
			if (j != givenIndex && expressions.get(givenIndex).equals(expressions.get(j)) == true) {
				return true;

			}
		}

		return false;

	}

}
