package maman12;

public class SubtractionExpression extends CompoundExpression {

	public SubtractionExpression(Expression firstOperand, Expression secondOperand) {
		super(firstOperand, secondOperand);
	}

	@Override
	public double calcualte() {
		return (firstOperand.calcualte() - firstOperand.calcualte());
	}

	@Override
	public String toString() {
		return firstOperand + "-" + secondOperand + "=" + this.calcualte();
	}

}
