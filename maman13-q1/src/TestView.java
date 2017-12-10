import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.util.LinkedList;

public class TestView extends JFrame {

	private static final long serialVersionUID = 1L;
	// ... Components
	
	private JButton m_resetBtn = new JButton("Reset");
	private JButton m_FinishBtn = new JButton("Finish");
	private TestModel testModel;
	
	public TestView(TestModel model) {

		this.testModel = model;
		//JScrollPane mainScroll2 = new JScrollPane();
		JPanel mainScroll = new JPanel();
		JPanel questionPanel = new JPanel();

		LinkedList<TestQuestion> questions = testModel.getArrayOfQuestions();
		
		for ( int i = 0 ; i < questions.size(); i ++)
		{
			JPanel test= questions.get(i);
			questionPanel.add(test);
			
		}
		questionPanel.setLayout(new BoxLayout(questionPanel,BoxLayout.Y_AXIS));
		mainScroll.setLayout(new BoxLayout(mainScroll,BoxLayout.Y_AXIS));
		questionPanel.setVisible(true);


		JPanel btnsPanel = new JPanel();
		btnsPanel.setLayout(new FlowLayout());
		btnsPanel.add(m_resetBtn);
		btnsPanel.add(m_FinishBtn);
		
		mainScroll.add(questionPanel);
		mainScroll.add(btnsPanel);
		
		this.setContentPane(mainScroll);
		//this.pack();
		this.setTitle("Test");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(400,400);


	}

//	public void setQuestion(TestQuestion aQuestion) {
//
//		String[] answers = aQuestion.getQ_answers();
//		m_Question.setText(" Q: " + aQuestion.getQ_content());
//
//		m_answer1.setText(answers[0]);
//		m_answer1.setSelected(true);
//		m_answer2.setText(answers[1]);
//		m_answer3.setText(answers[2]);
//		m_answer4.setText(answers[3]);
//
//	}
//	


	
	public void addResetListener(ActionListener resetListener) {
		m_resetBtn.addActionListener(resetListener);
		
	}
	
	public void addFinishListener(ActionListener finishListener) {
		m_FinishBtn.addActionListener(finishListener);
		
	}
	
    public void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }

	public void enableFinish() {
		m_FinishBtn.setEnabled(true);
		
	}
	
	
	public boolean setAnswers(LinkedList<TestQuestion> aList) {

		try {

			for (int i = 0; i < aList.size(); i++) {
				aList.get(i).setTestAnswer();

			}
		} catch (Exception e) {
			this.showError("Please answer all of the questions!");
			return false;
		}

		return true;

	}






}
