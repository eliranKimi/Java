import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TestView extends JFrame {

	// ... Constants
	private static final String INITIAL_VALUE = "1";

	// ... Components
	private JLabel m_Question = new JLabel();
	private JRadioButton m_answer1 = new JRadioButton();
	private JRadioButton m_answer2 = new JRadioButton();
	private JRadioButton m_answer3 = new JRadioButton();
	private JRadioButton m_answer4 = new JRadioButton();
	private JButton m_resetBtn = new JButton("Reset");
	private JButton m_nextBtn = new JButton("Next");
	private JButton m_FinishBtn = new JButton("Finish");

	public TestView() {

	}

}
