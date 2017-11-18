import java.awt.Color;
import java.awt.Graphics;

public class MyLine extends MyShape {

	private static final int POW_FOR_DISTANCE = 2;

	public MyLine(int x1, int x2, int y1, int y2, Color color) {
		super(x1, x2, y1, y2, color);

	}

	@Override
	public void paint(Graphics g) {
		g.setColor(this.getColor());
		g.drawLine(this.getX1(), this.getX2(), this.getY1(), this.getY1());

	}

	// To calculate line's distance, this function is using the distance between 2 points formula 
	public double distance() {
		return Math.sqrt(Math.pow(this.getX1() - this.getX2(), POW_FOR_DISTANCE)
				+ Math.pow(this.getY1() - this.getY2(), POW_FOR_DISTANCE));
	}

	@Override
	public boolean equals(Object object) {

		if (object instanceof MyLine) {
			MyLine aLine = (MyLine) object;
			return (this.distance() == aLine.distance());

		}
		return false;
	}

	@Override
	public Object clone() {
		MyLine aLine = new MyLine(this.getX1(), this.getX2(), this.getY1(), this.getY2(), this.getColor());
		return aLine;

	}

}
