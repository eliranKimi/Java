import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class TestConroller {

	private TestModel m_model;
	private TestView m_view;

	public TestConroller(TestModel model, TestView view) {
		this.m_model = model;
		this.m_view = view;

		// ... Add listeners to the view.
		// m_view.addNextListener(new NextListener());
		 m_view.addResetListener(new ResetListener());
		m_view.addFinishListener(new FinishListener());

	}

	//
	// class NextListener implements ActionListener {
	// public void actionPerformed(ActionEvent e) {
	// TestQuestion aQuestion;
	//
	// TestQuestion aQuestionTemp = m_model.getCurrentQuestion();
	//
	//
	// String theAnswerIs = m_view.getSelectedAnswer();
	// aQuestionTemp.setTestAnswer(theAnswerIs);
	//
	// aQuestion = m_model.getNextQuestion();
	// if (aQuestion != null) {
	// m_view.setQuestion(aQuestion);
	// }
	// else
	// {
	// m_view.showFinish();
	// m_view.hideNext();
	//
	// }
	//
	// // aQuestion = m_model.getNextQuestion();
	//
	// // TODO Auto-generated catch block
	//
	//
	// }
	// }
	//
	 class ResetListener implements ActionListener {
	 public void actionPerformed(ActionEvent e) {
	
		 m_model.reset();


	 }
	 }
	
	class FinishListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			boolean allAnswered = m_view.setAnswers(m_model.getArrayOfQuestions());

			if (allAnswered == true) {
				JOptionPane.showMessageDialog(null, "Your Score is :"+m_model.finish() +"%");
				
			}
			
			

		}
	}

}
