import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class SudokuView extends JFrame implements ISudokuView {

	private JButton m_setBtn = new JButton("Set");
	private JButton m_clearBtn = new JButton("Clear");
	private SudokuModel m_model;

	private final static int NUMBER_OF_RAWS = 3;
	private final static int NUMBER_OF_COLUMNS = 3;
	
	
	public SudokuView(SudokuModel model) {
		this.m_model = model;

		JPanel btnPanel = new JPanel();
		JPanel sudokuPanel = new JPanel();
		JPanel mainPanel = new JPanel();

		Block[][] aMat = m_model.getBlocksMat();

		for (int i = 0; i < NUMBER_OF_RAWS; i++) {
			for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
				sudokuPanel.add(aMat[i][j]);
			}
		}
		sudokuPanel.setLayout(new GridLayout(NUMBER_OF_RAWS, NUMBER_OF_COLUMNS));

		btnPanel.add(m_clearBtn);
		btnPanel.add(m_setBtn);

		mainPanel.add(sudokuPanel);
		mainPanel.add(btnPanel);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		this.setContentPane(mainPanel);
		this.setTitle("Sudoku");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setResizable(false);

	}

	public void showError(String errMessage) {
		JOptionPane.showMessageDialog(this, errMessage);
	}

	@Override
	public void addSetListener(ActionListener setListener) {

		m_setBtn.addActionListener(setListener);

	}

	@Override
	public void addClearListener(ActionListener clearListener) {

		m_clearBtn.addActionListener(clearListener);

	}

	public void cellNotLegalAction(JTextField temp) {

		temp.setText("");
		this.showError("Enter 1-9 only! ");

	}

	public void disableSet() {

		m_setBtn.setEnabled(false);

	}

	public void enableSet() {

		m_setBtn.setEnabled(true);

	}

}
