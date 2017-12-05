import java.awt.Color;

public abstract class MyBoundedShape extends MyShape {

	private boolean isFull;

	protected MyBoundedShape(int x1, int x2, int y1, int y2, Color color, boolean isFull) {
		super(x1, x2, y1, y2, color);
		this.isFull = isFull;
	}

	public boolean getIsFull() {
		return isFull;
	}

	public void setFull(boolean isFull) {
		this.isFull = isFull;
	}
}
