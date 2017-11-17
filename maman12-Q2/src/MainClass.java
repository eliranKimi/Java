import java.awt.Color;

public class MainClass {

	public static void main(String[] args) {
		MyJFrame frame = new MyJFrame();
//		MyFirstPanel m = new MyFirstPanel();
		MyOval oval = new MyOval(300, 300, 100, 300,Color.BLUE);

		frame.add(oval);

	}

}
