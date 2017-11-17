import java.awt.Color;
import java.awt.Graphics;

public class MyLine extends MyShape {

	public MyLine(int x1, int x2, int y1, int y2, Color color) {
		super(x1, x2, y1, y2, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint(Graphics g) {
		g.drawLine(this.getX1(), this.getX2(), this.getY1(), this.getY1());

	}

	@Override
	public boolean equals(Object object) {
		
		if (object instanceof MyLine)
		{
			
			
			
		}
		// TODO Auto-generated method stub
		return false;
	}

}
