import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Block extends JPanel {

	private final static int NUMBER_OF_RAWS = 3;
	private final static int NUMBER_OF_COLUMNS = 3;
	private final Dimension fieldDimension = new Dimension(40, 40);
	private final Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
	private JTextField[][] cellsMat;

	public Block() {
		this.cellsMat = new JTextField[NUMBER_OF_RAWS][NUMBER_OF_COLUMNS];
		this.initMat(this.cellsMat);

		this.setLayout(new GridLayout(3, 3));
		this.setBorder(border);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				this.add(cellsMat[i][j]);
			}
		}
	}

	public void clearMat() {
		for (int i = 0; i < NUMBER_OF_RAWS; i++) {
			for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
				cellsMat[i][j].setText("");
				cellsMat[i][j].setEnabled(true);

			}
		}

	}

	public void initMat(JTextField[][] acellsMat) {
		for (int i = 0; i < NUMBER_OF_RAWS; i++) {
			for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
				acellsMat[i][j] = new JTextField();
				acellsMat[i][j].setPreferredSize(fieldDimension);

			}
		}

	}

	public void setCell(int raw, int column, int value)

	{
		if (raw <= NUMBER_OF_RAWS && column <= NUMBER_OF_COLUMNS) {
			this.cellsMat[raw][column].setText("" + value);
		}
	}

	public int getCell(int raw, int column) {
		if (raw <= NUMBER_OF_RAWS && column <= NUMBER_OF_COLUMNS) {
			return Integer.parseInt(this.cellsMat[raw][column].getText());
		}
		return -1;
	}

	public boolean checkLine(int raw, int column, int value) {
		for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
			if (j != column && Integer.parseInt(this.cellsMat[raw][j].getText()) == value) {
				return true;

			}
		}

		return false;
	}

	public boolean checkColumn(int raw, int column, int value) {
		for (int i = 0; i < NUMBER_OF_RAWS; i++) {
			if (i != raw && Integer.parseInt(this.cellsMat[i][column].getText()) == value) {
				return true;

			}
		}

		return false;
	}

	public void disableFilledCells() {

		for (int i = 0; i < NUMBER_OF_RAWS; i++) {
			for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
				if (!this.cellsMat[i][j].getText().equals("")) {
					this.cellsMat[i][j].setEnabled(false);
					this.cellsMat[i][j].setDisabledTextColor(Color.RED);
					

				}

			}
		}

	}

	public void addActionListener(ActionListener cellListener) {

		for (int i = 0; i < NUMBER_OF_RAWS; i++) {
			for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {

				this.cellsMat[i][j].addActionListener(cellListener);
			}
		}

	}

}
