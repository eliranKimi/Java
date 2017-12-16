import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SudokuController implements ISudokuController {

	private SudokuModel m_model;
	private SudokuView m_view;

	public SudokuController(SudokuModel model, SudokuView view) {
		this.m_model = model;
		this.m_view = view;

		// ... Add listeners to the view.
		m_view.addSetListener(new SetListener());
		m_view.addClearListener(new ClearListener());

	}

	class ClearListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			m_model.resetAllBlocks();
			m_view.enableSet();

		}
	}

	class SetListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			m_model.lockBoardEnteredNumbers();
			m_view.disableSet();

		}
	}

}
