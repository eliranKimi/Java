
public class SudokuModel implements ISudokuModel {

	private final static int NUMBER_OF_RAWS = 3;
	private final static int NUMBER_OF_COLUMNS = 3;

	private Block[][] blocksMat;

	public Block[][] getBlocksMat() {
		return blocksMat;
	}

	public void setBlocksMat(Block[][] blocksMat) {
		this.blocksMat = blocksMat;
	}

	public SudokuModel() {
		this.blocksMat = new Block[NUMBER_OF_RAWS][NUMBER_OF_COLUMNS];
		this.setAllBlocks();

	}

	public void isLegalNumeric(String str) throws Exception {

		int temp = Integer.valueOf(str);
		if (temp < 1 || temp > 9)
			throw new Exception();

	}

	@Override
	public void lockBoardEnteredNumbers() {
		for (int i = 0; i < NUMBER_OF_RAWS; i++) {
			for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
				blocksMat[i][j].disableFilledCells();
			}
		}

	}

	public void setAllBlocks() {

		for (int i = 0; i < NUMBER_OF_RAWS; i++) {
			for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
				blocksMat[i][j] = new Block();
			}
		}
	}

	public void resetAllBlocks() {
		for (int i = 0; i < NUMBER_OF_RAWS; i++) {
			for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
				blocksMat[i][j].clearMat();
			}
		}
	}

	@Override
	public void checkInput(String temp2) throws Exception {

		this.isLegalNumeric(temp2);

	}

	@Override
	public boolean checkLineOnBlocks(int raw, int column, int value) {

		for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
			if (j != column && this.blocksMat[raw][j].checkLine(raw, column, value) == true) {
				return true;

			}
		}
		return false;
	}

	@Override
	public boolean columnLineOnBlocks(int raw, int column, int value) {

		for (int i = 0; i < NUMBER_OF_RAWS; i++) {
			if (i != column && this.blocksMat[i][column].checkColumn(raw, column, value) == true) {
				return true;

			}
		}
		return false;
	}

}
