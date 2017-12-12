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
		m_view.addCellsListener(new CellListener());

	}

	class ClearListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			m_model.resetAllBlocks();

		}
	}

	class SetListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			m_model.lockBoardEnteredNumbers();

		}
	}

	class CellListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			JTextField temp = (JTextField) m_view.getFocusOwner();

			try {
				
				m_model.checkInput(temp.getText());

		

			} catch (Exception e1) {
				m_view.cellNotLegalAction(temp);

			}

		}
	}

}
