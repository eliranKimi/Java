
public class Rational {

	private int deno; // Denominator
	private int num; // Numerator

	// CONSTRUCTER WILL GENERATE 0 IN CASE AN ILGEAL RATIONAL NUMBER IS PASSED (AS
	// ASKED)
	public Rational(int num, int den) {
		super();
		if (den > 0) {
			this.deno = den;
			this.num = num;
		} else {
			this.deno = 0;
			this.num = 0;
		}
	}

	public int getDenominator() {
		return deno;
	}

	public void setDenominatoro(int deno) {
		this.deno = deno;
	}

	public int getNumerator() {
		return num;
	}

	public void setNumerator(int num) {
		this.num = num;
	}

	public Boolean greaterThan(Rational number) {
		if (this.getNumerator() * number.getDenominator() > this.getDenominator() * number.getNumerator()) {
			return true;
		}

		return false;

	}

	@Override
	public boolean equals(Object number) {
		if (number instanceof Rational) {
			if (this.getNumerator() * ((Rational) number).getDenominator() == this.getDenominator()
					* ((Rational) number).getNumerator()) {
				return true;
			}
			return false;
		} else {
			System.out.println("ERR: Object is not a Rational number! ");
			return false;
		}
	}

	public Rational plus(Rational number) {
		Rational sumResult;
		int den;
		int num;

		den = this.getDenominator() + number.getDenominator();
		num = this.getNumerator() * number.getDenominator() + this.getDenominator() * number.getNumerator();
		sumResult = new Rational(den, num);
		return sumResult;
	}

	public Rational minus(Rational number) {
		Rational sumResult;
		int den;
		int num;

		den = this.getDenominator() + number.getDenominator();
		num = this.getNumerator() * number.getDenominator() - this.getDenominator() * number.getNumerator();
		sumResult = new Rational(den, num);
		return sumResult;
	}

	public Rational multiply(Rational number) {
		Rational result;
		int num = this.getNumerator() * number.getNumerator();
		int den = this.getDenominator() * number.getDenominator();
		result = new Rational(den, num);
		return result;
	}

	@Override
	public String toString() {
		return this.getNumerator() + "/" + this.getDenominator();
	}

	// USED THE ECULIDUS ALGORITHEM AS DESCRIBED AT THE QUESTION
	private int gcd(int x, int y) {
		if (y != 0) {
			return this.gcd(y, x % y);
		} else {
			return x;
		}
	}

	public Rational reduce() {
		Rational number;
		int divider = this.gcd(this.getDenominator(), this.getNumerator());
		number = new Rational(this.getDenominator() / divider, this.getNumerator() / divider);
		return number;
	}

	public Boolean isZeroed() {
		if (this.getNumerator() == 0 && this.getDenominator() == 0) {
			return true;
		} else {
			return false;
		}

	}
}
