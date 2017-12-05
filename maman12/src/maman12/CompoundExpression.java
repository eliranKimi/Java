package maman12;

public abstract class CompoundExpression extends Expression {

	protected Expression firstOperand;
	protected Expression secondOperand;

	@Override
	public abstract double calcualte();

	public CompoundExpression(Expression firstOperand, Expression secondOperand) {
		super();
		this.firstOperand = firstOperand;
		this.secondOperand = secondOperand;
	}

}
