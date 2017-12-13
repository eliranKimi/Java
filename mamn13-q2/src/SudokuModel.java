
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
				blocksMat[i][j] = new Block(blocksMat,i,j);
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





}
