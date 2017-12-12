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

	public SudokuView(SudokuModel model) {
		this.m_model = model;

		JPanel btnPanel = new JPanel();
		JPanel sudokuPanel = new JPanel();
		JPanel mainPanel = new JPanel();

		Block[][] aMat = m_model.getBlocksMat();

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				sudokuPanel.add(aMat[i][j]);
			}
		}
		sudokuPanel.setLayout(new GridLayout(3, 3));

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

	public void addCellsListener(ActionListener cellListener) {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				Block[][] aMat = m_model.getBlocksMat();
				aMat[i][j].addActionListener(cellListener);
			}
		}

	}

	@Override
	public void addClearListener(ActionListener clearListener) {

		m_clearBtn.addActionListener(clearListener);

	}

	public void cellNotLegalAction(JTextField temp) {

		temp.setText("");
		this.showError("Enter 1-9 only! ");

	}

}
