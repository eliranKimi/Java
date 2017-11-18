import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public abstract class MyShape implements Cloneable {

	private int x1;
	private int x2;
	private int y1;
	private int y2;
	Color color;

	protected MyShape(int x1, int x2, int y1, int y2, Color color) {
		super();
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public abstract void paint(Graphics g);

	@Override
	public abstract boolean equals(Object object);
	
	@Override
	public abstract Object clone();
}
