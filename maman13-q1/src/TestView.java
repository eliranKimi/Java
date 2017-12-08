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

	public TestView(TestModel model) {

		this.testModel = model;

		this.setQuestion();

	}

	private void setQuestion() {
		
		Container contentPane = getContentPane();
		
		TestQuestion aQuestion = testModel.getQuestion();
		String[] answers = aQuestion.getQ_answers();
		m_Question.setText(" Q: " + aQuestion.getQ_content());
		
		JPanel questionPanel = new JPanel();
		questionPanel.setLayout(new FlowLayout());
		questionPanel.add(m_Question);
		
		m_answer1.setText(answers[0]);
		m_answer1.setSelected(true);
		m_answer2.setText(answers[1]);
		m_answer3.setText(answers[2]);
		m_answer4.setText(answers[3]);
		
		JPanel answersPanel = new JPanel();
		answersPanel.setLayout(new FlowLayout());
		answersPanel.add(m_answer1);
		answersPanel.add(m_answer2);
		answersPanel.add(m_answer3);
		answersPanel.add(m_answer4);
		
		
		JPanel btnsPanel = new JPanel();
		btnsPanel.setLayout(new FlowLayout());
		btnsPanel.add(m_resetBtn);
		btnsPanel.add(m_nextBtn);
		btnsPanel.add(m_FinishBtn);
		
		contentPane.add(questionPanel);
		contentPane.add(answersPanel);
		contentPane.add(btnsPanel);
		
		this.setContentPane(contentPane);
		this.pack();
		this.setTitle("Test");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

		
	}
	
	
	

}
