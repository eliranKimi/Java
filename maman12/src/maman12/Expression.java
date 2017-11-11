package maman12;

public abstract class Expression {

	public abstract double calcualte();

	@Override
	public boolean equals(Object anExpression) {
		if (anExpression instanceof Expression) {
			return (this.calcualte() == ((Expression) anExpression).calcualte());
		} else {
			return false;
		}

	}

}
