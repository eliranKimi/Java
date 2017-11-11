package maman12;

public class AtomicExpression extends Expression{
	
	protected int operand;

	public AtomicExpression(int operand) {
		super();
		this.operand = operand;
	}

	public int getOperand() {
		return operand;
	}

	public void setOperand(int operand) {
		this.operand = operand;
	}

	@Override
	public double calcualte() {
		
		return this.operand;
	}

	@Override
	public String toString() {
		return "" + operand;
	}

}
