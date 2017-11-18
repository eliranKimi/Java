import java.awt.Color;
import java.awt.Graphics;

public class MyRectangle extends MyBoundedShape {

	protected MyRectangle(int x1, int x2, int y1, int y2, Color color, boolean isFull) {
		super(x1, x2, y1, y2, color, isFull);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(this.getColor());
		g.drawRect(this.getX1(), this.getX2(), this.getY1(), this.getY1());

		if (this.getIsFull()) {
			g.fillRect(this.getX1(), this.getX2(), this.getY1(), this.getY1());
		}

	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof MyRectangle) {
			MyRectangle aRect = (MyRectangle) object;

			return (this.getX2() == aRect.getX2() && this.getY2() == aRect.getY2());

		}
		return false;
	}

	@Override
	public Object clone() {
		MyRectangle aRect = new MyRectangle(this.getX1(), this.getX2(), this.getY1(), this.getY2(), this.getColor(),
				this.getIsFull());
		return aRect;

	}
	
	@Override
	public void repaint() {
		super.repaint();
		

	}


}
