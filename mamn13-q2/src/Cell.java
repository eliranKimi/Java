import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Cell extends JPanel implements ActionListener {

	private final Dimension fieldDimension = new Dimension(40, 40);
	private final static int NUMBER_OF_RAWS = 3;
	private final static int NUMBER_OF_COLUMNS = 3;
	private final static int MIN_LEGAL_NUM = 1;
	private final static int MAX_LEGAL_NUM = 9;

	private JTextField cellField;

	private int raw;
	private int column;

	private int blockRaw;
	private int blockColumn;

	private Block[][] blocksMat;

	public Cell(int raw, int column, int blockRaw, int blockColumn, Block[][] aBlocksMat) {
		super();
		this.cellField = new JTextField();
		this.cellField.addActionListener(this);
		this.cellField.setPreferredSize(fieldDimension);

		this.raw = raw;
		this.column = column;
		this.blockRaw = blockRaw;
		this.blockColumn = blockColumn;
		this.blocksMat = aBlocksMat;
	}

	public void setCellField(int value) {
		this.cellField.setText("" + value);
	}

	public String getText() {
		return this.cellField.getText();
	}

	public JTextField getField() {
		return this.cellField;
	}

	public void reset() {
		this.cellField.setText("");
		this.cellField.setEnabled(true);
	}

	public void disable() {
		this.cellField.setEnabled(false);
		this.cellField.setDisabledTextColor(Color.RED);
	}

	public boolean checkSelfBlock(int value) {
		return this.blocksMat[this.blockRaw][this.blockColumn].checkSelf(this.raw, this.column);
	}

	public boolean checkLineOnBlocks(int value) {

		for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
			if (j != this.blockColumn && this.blocksMat[this.blockRaw][j].checkLine(this.raw, j, value) == true) {
				return true;
			}
		}
		return false;
	}

	public boolean checkColumnOnBlocks(int value) {

		for (int i = 0; i < NUMBER_OF_RAWS; i++) {
			if (i != blockRaw && this.blocksMat[i][this.blockColumn].checkColumn(i, this.column, value) == true) {
				return true;

			}
		}
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String input = this.cellField.getText();
		this.checkInput(input);
	}

	public void checkInput(String input) {
		try {
			if (this.isLegalNumeric(input) == false) {
				JOptionPane.showMessageDialog(null, "Not a legal number! enter a new number");
				this.cellField.setText("");

			} else {

				if (this.checkLineOnBlocks(Integer.parseInt(input)) == true
						|| this.checkColumnOnBlocks(Integer.parseInt(input)) == true
						|| this.checkSelfBlock(Integer.parseInt(input)) == true) {
					JOptionPane.showMessageDialog(null, "Not a legal number Sudoku! enter a new number");
					this.cellField.setText("");

				}

			}

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Not a  number ! enter a number");
			this.cellField.setText("");
		}

	}

	public boolean isLegalNumeric(String str) throws Exception {

		int temp = Integer.valueOf(str);
		if (temp < MIN_LEGAL_NUM || temp > MAX_LEGAL_NUM)
			return false;

		return true;

	}

}
