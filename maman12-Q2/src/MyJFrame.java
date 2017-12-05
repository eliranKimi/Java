import javax.swing.JFrame;

public class MyJFrame extends JFrame {

	private static final int WIDTH = 400;
	private static final int HEIGHT = 400;

	public MyJFrame() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		setVisible(true);
	}
	
}
