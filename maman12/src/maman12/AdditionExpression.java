package maman12;

public class AdditionExpression extends CompoundExpression {

	public AdditionExpression(Expression firstOperand, Expression secondOperand) {
		super(firstOperand, secondOperand);
	}

	@Override
	public double calcualte() {
		return (firstOperand.calcualte() + secondOperand.calcualte());
	}

	@Override
	public String toString() {
		return firstOperand + " + " + secondOperand + " = " + this.calcualte();
	}

}
