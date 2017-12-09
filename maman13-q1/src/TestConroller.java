import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestConroller {

	private TestModel m_model;
	private TestView m_view;

	public TestConroller(TestModel model, TestView view) {
		this.m_model = model;
		this.m_view = view;

		// ... Add listeners to the view.
		m_view.addNextListener(new NextListener());
		m_view.addResetListener(new ResetListener());
		m_view.addFinishListener(new FinishListener());

	}

	class NextListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			TestQuestion aQuestion;

			TestQuestion aQuestionTemp = m_model.getCurrentQuestion();

			
				String theAnswerIs = m_view.getSelectedAnswer();
				aQuestionTemp.setTestAnswer(theAnswerIs);
				
				aQuestion = m_model.getNextQuestion();
				if (aQuestion != null) {
				m_view.setQuestion(aQuestion);
			}
			else
			{
				m_view.showFinish();
				m_view.hideNext();
				
			}

			// aQuestion = m_model.getNextQuestion();

			// TODO Auto-generated catch block
			

		}
	}

	class ResetListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			TestQuestion aQuestion;

			try {
				m_model.reset();
				aQuestion = m_model.getNextQuestion();
				m_view.setQuestion(aQuestion);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				m_view.showError("No more questions");
			}
		}
	}
 $ISIS537
 
	class FinishListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			try {
				System.out.println(m_model.finish());
			} catch (Exception e1) {
				m_view.showError("You didnt reach the final question yet!");
			}
		}
	}

}
