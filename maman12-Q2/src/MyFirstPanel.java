import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;


public class MyFirstPanel extends JPanel {


	@Override
	 public void paint(Graphics g)
	 {
		super.paint(g);
		  MyOval oval = new MyOval(300, 300, 100, 300,Color.BLUE);
		  oval.paint(g);
//	    
//  	    g.setColor(Color.red);
//  	    g.drawLine(0, 0, 100, 100);
//  	    g.setColor(Color.BLUE);
//  	    g.drawRect(100, 100, 200, 200);
//  	    g.drawOval(300, 300, 100, 300);
//  	    g.fillRect(500, 500, 100, 100);
//  	  
 
	 }
	 
	@Override
	public void repaint() {
		super.repaint();
		
	
		
		
	}
	

}
