//This class exists for the soul purpose of hiding any logic from the main function
public class Program {
	
	public Program()
	{
		MyJFrame frame = new MyJFrame();
		ShapesPanel aPanel = new ShapesPanel();
		frame.add(aPanel);
		frame.setVisible(true);	
		
	}

}
