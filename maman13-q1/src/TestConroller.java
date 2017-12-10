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
		m_view.addResetListener(new ResetListener());
		m_view.addFinishListener(new FinishListener());

	}

	class ResetListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			m_model.reset();

		}
	}

	class FinishListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			boolean allAnswered = m_model.setAnswers(m_view);

			if (allAnswered == true) {
				JOptionPane.showMessageDialog(null, "Your Score is :" + m_model.finish() + "%");

			}

		}
	}

}
