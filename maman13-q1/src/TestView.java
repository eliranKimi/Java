import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class TestView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// ... Components
	private JLabel m_Question = new JLabel();
	private JRadioButton m_answer1 = new JRadioButton();
	private JRadioButton m_answer2 = new JRadioButton();
	private JRadioButton m_answer3 = new JRadioButton();
	private JRadioButton m_answer4 = new JRadioButton();
	private JButton m_resetBtn = new JButton("Reset");
	private JButton m_nextBtn = new JButton("Next");
	private JButton m_FinishBtn = new JButton("Finish");
	private TestModel testModel;
	private ButtonGroup answerGroup;

	public TestView(TestModel model) {

		this.testModel = model;
		Container contentPane = getContentPane();

		JPanel questionPanel = new JPanel();
		questionPanel.setLayout(new FlowLayout());
		questionPanel.add(m_Question);

		answerGroup = new ButtonGroup();
		answerGroup.add(m_answer1);
		answerGroup.add(m_answer2);
		answerGroup.add(m_answer3);
		answerGroup.add(m_answer4);

		JPanel answersPanel = new JPanel();
		answersPanel.setLayout(new BoxLayout(answersPanel,BoxLayout.Y_AXIS));
		answersPanel.add(m_answer1);
		answersPanel.add(m_answer2);
		answersPanel.add(m_answer3);
		answersPanel.add(m_answer4);

		JPanel btnsPanel = new JPanel();
		btnsPanel.setLayout(new FlowLayout());
		btnsPanel.add(m_resetBtn);
		btnsPanel.add(m_nextBtn);
		m_FinishBtn.setVisible(false);

		btnsPanel.add(m_FinishBtn);
		contentPane.setLayout(new BoxLayout(contentPane,BoxLayout.Y_AXIS));
		contentPane.add(questionPanel);
		contentPane.add(answersPanel);
		contentPane.add(btnsPanel);

		this.setContentPane(contentPane);
		this.pack();
		this.setTitle("Test");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		this.setQuestion(model.getCurrentQuestion());

	}

	public void setQuestion(TestQuestion aQuestion) {

		String[] answers = aQuestion.getQ_answers();
		m_Question.setText(" Q: " + aQuestion.getQ_content());

		m_answer1.setText(answers[0]);
		m_answer1.setSelected(true);
		m_answer2.setText(answers[1]);
		m_answer3.setText(answers[2]);
		m_answer4.setText(answers[3]);

	}
	
	public String getSelectedAnswer()
	{
		if (m_answer1.isSelected())
			return m_answer1.getText();
		if (m_answer2.isSelected())
			return m_answer2.getText();
		if (m_answer3.isSelected())
			return m_answer3.getText();
		if (m_answer4.isSelected())
			return m_answer4.getText();
		
		return null;
		
	}

	public void addNextListener(ActionListener nextListener) {
		m_nextBtn.addActionListener(nextListener);

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

	public void showFinish() {
		m_FinishBtn.setVisible(true);
		
	}

	public void hideNext() {
		m_nextBtn.setVisible(false);
		
	}



}
