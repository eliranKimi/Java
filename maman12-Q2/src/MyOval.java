import java.awt.Color;
import java.awt.Graphics;

public class MyOval extends MyBoundedShape {

	protected MyOval(int x1, int x2, int y1, int y2, Color color, boolean isFull) {
		super(x1, x2, y1, y2, color, isFull);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(this.getColor());
		g.drawOval(this.getX1(), this.getX2(), this.getY1(), this.getY1());
		if (this.getIsFull()) {
			g.fillOval(this.getX1(), this.getX2(), this.getY1(), this.getY1());
		}

	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof MyOval) {
			MyOval aOval = (MyOval) object;

			return (this.getX2() == aOval.getX2() && this.getY2() == aOval.getY2());

		}
		return false;
	}

	@Override
	public Object clone() {
		MyOval anOval = new MyOval(this.getX1(), this.getX2(), this.getY1(), this.getY2(), this.getColor(),
				this.getIsFull());
		return anOval;

	}

}
