import java.awt.Color;

public abstract class MyBoundedShape extends MyShape {
	private boolean isFull;


	protected MyBoundedShape(int x1, int x2, int y1, int y2, Color color) {
		super(x1, x2, y1, y2, color);
		// TODO Auto-generated constructor stub
	}

	public boolean isFull() {
		return isFull;
	}

	public void setFull(boolean isFull) {
		this.isFull = isFull;
	}
}
