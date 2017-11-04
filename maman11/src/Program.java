
import java.util.Scanner;

public class Program {

	public Program() {
		Rational number1 = this.getRational();
		Rational number2 = this.getRational();

		if (number1.equals(number2)) {
			System.out.println("Rational number1 & Rational number2 are equals!");
		} else {
			System.out.println("Rational number1 & Rational number2 are not equals!");
		}

		System.out.println(number1 + "+" + number2 + "=" + number1.plus(number2).reduce());
		System.out.println(number1 + "-" + number2 + "=" + number1.minus(number2).reduce());
		System.out.println(number1 + "*" + number2 + "=" + number1.multiply(number2).reduce());

	}

	public Rational getRational() {
		Rational result;
		Scanner scanner = new Scanner(System.in);
		int den;
		int num;

		System.out.println("Enter Rational number Numerator:");
		num = scanner.nextInt();
		System.out.println("Enter Rational number Denominator:");
		den = scanner.nextInt();
		while (den == 0) {
			System.out.println("Denominator cannot be zero, please enter another number:");
			den = scanner.nextInt();

		}

		result = new Rational(num, den);

		return result;

	}

}
