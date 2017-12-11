
public class SudokuModel implements ISudokuModel {

	private final static int NUMBER_OF_RAWS = 3;
	private final static int NUMBER_OF_COLUMNS = 3;

	private Block[][] blocksMat;

	public SudokuModel() {
		this.blocksMat = new Block[NUMBER_OF_RAWS][NUMBER_OF_COLUMNS];
		this.resetAllBlocks();

	}

	@Override
	public void lockBoardEnteredNumbers() {

	}

	@Override
	public void resetAllBlocks() {

		for (int i = 0; i < NUMBER_OF_RAWS; i++) {
			for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
				blocksMat[i][j] = new Block();
			}
		}
	}

	@Override
	public boolean checkInput(int value) {
		
		if ( value < 1 || value > 9 )
		{
			return false;
		}

		return false;
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
