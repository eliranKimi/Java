import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.util.LinkedList;

@SuppressWarnings("serial")

public class TestView extends JFrame implements ITestView {

	// ... Components
	private static final int WIDTH = 500;
	private static final int HEIGHT = 500;
	private JButton m_resetBtn = new JButton("Reset");
	private JButton m_FinishBtn = new JButton("Finish");
	private TestModel testModel;

	public TestView(TestModel model) {

		this.testModel = model;

		JPanel btnsPanel = new JPanel();
		JPanel questionPanel = new JPanel();
		JPanel mainPanel = new JPanel();
		mainPanel.add(questionPanel);
		mainPanel.add(btnsPanel);
		JScrollPane mainScroll = new JScrollPane(mainPanel);
		LinkedList<TestQuestion> questions = testModel.getListOfQuestions();

		for (int i = 0; i < questions.size(); i++) {
			JPanel test = questions.get(i);
			questionPanel.add(test);

		}
		questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.Y_AXIS));
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		questionPanel.setVisible(true);

		btnsPanel.setLayout(new FlowLayout());
		btnsPanel.add(m_resetBtn);
		btnsPanel.add(m_FinishBtn);
		mainScroll.setAutoscrolls(true);

		add(mainScroll);

		this.setSize(WIDTH, HEIGHT);
		this.setTitle("Test");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	public void addResetListener(ActionListener resetListener) {
		m_resetBtn.addActionListener(resetListener);

	}

	public void addFinishListener(ActionListener finishListener) {
		m_FinishBtn.addActionListener(finishListener);

	}

	public void showError(String errMessage) {
		JOptionPane.showMessageDialog(this, errMessage);
	}

}
