import java.awt.Color;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import javax.swing.border.Border;

@SuppressWarnings("serial")
public class Block extends JPanel {

	private final static int NUMBER_OF_RAWS = 3;
	private final static int NUMBER_OF_COLUMNS = 3;
	private final Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
	private Cell[][] cellsMat; // Block cells

	// aMat is the blocks mat of the Sudoku , blockRaw & BlockColumn are the
	// position of the current block
	public Block(Block[][] aMat, int blockRaw, int blockColumn) {
		this.cellsMat = new Cell[NUMBER_OF_RAWS][NUMBER_OF_COLUMNS];
		this.initMat(this.cellsMat, blockRaw, blockColumn, aMat);

		this.setLayout(new GridLayout(NUMBER_OF_RAWS, NUMBER_OF_COLUMNS));
		this.setBorder(border);

		// Adding all Cell to block's panel
		for (int i = 0; i < NUMBER_OF_RAWS; i++) {
			for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
				this.add(cellsMat[i][j].getField());
			}
		}
	}

	// Clear Block mat
	public void clearMat() {
		for (int i = 0; i < NUMBER_OF_RAWS; i++) {
			for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
				cellsMat[i][j].reset();
			}
		}

	}

	// Initialize cell's mat
	public void initMat(Cell[][] aCellsMat, int blockRaw, int blockColumn, Block[][] aMat) {
		for (int i = 0; i < NUMBER_OF_RAWS; i++) {
			for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
				aCellsMat[i][j] = new Cell(i, j, blockRaw, blockColumn, aMat);

			}
		}

	}

	// Check if a value exists in Block's line
	public boolean checkLine(int raw, int column, int value) {
		for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
			int checkValue = 0;
			String fieldText = this.cellsMat[raw][j].getText();
			if (fieldText.equals("") != true)
				checkValue = Integer.parseInt(this.cellsMat[raw][j].getText());

			if (checkValue == value) {
				return true;

			}
		}

		return false;
	}

	// Check if a value exists in the block
	public boolean checkSelf(int raw, int column) {
		String value = this.cellsMat[raw][column].getText();
		for (int i = 0; i < NUMBER_OF_RAWS; i++) {
			for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {

				if ((i != raw || j != column) && value.equals(this.cellsMat[i][j].getText())) {
					return true;
				}

			}

		}

		return false;
	}

	// Check if a value exists in in Block's column
	public boolean checkColumn(int raw, int column, int value) {
		for (int i = 0; i < NUMBER_OF_RAWS; i++) {
			int checkValue = 0;
			String fieldText = this.cellsMat[i][column].getText();
			if (fieldText.equals("") != true)
				checkValue = Integer.parseInt(this.cellsMat[i][column].getText());
			if (checkValue == value) {
				return true;

			}
		}

		return false;
	}

	// Disable filled cells
	public void disableFilledCells() {

		for (int i = 0; i < NUMBER_OF_RAWS; i++) {
			for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
				if (!this.cellsMat[i][j].getText().equals("")) {
					this.cellsMat[i][j].disable();
				}

			}
		}

	}

}
