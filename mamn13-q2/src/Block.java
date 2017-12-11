
public class Block {

	private final static int NUMBER_OF_RAWS = 3;
	private final static int NUMBER_OF_COLUMNS = 3;

	private int[][] cellsMat;

	public Block() {
		this.cellsMat = new int[NUMBER_OF_RAWS][NUMBER_OF_COLUMNS];
		this.initMat(this.cellsMat);
	}

	public void initMat(int[][] acellsMat) {
		for (int i = 0; i < NUMBER_OF_RAWS; i++) {
			for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
				acellsMat[i][j] = 0;
			}
		}

	}

	public void setCell(int raw, int column, int value)

	{
		if (raw <= NUMBER_OF_RAWS && column <= NUMBER_OF_COLUMNS) {
			this.cellsMat[raw][column] = value;
		}
	}

	public int getCell(int raw, int column) {
		if (raw <= NUMBER_OF_RAWS && column <= NUMBER_OF_COLUMNS) {
			return this.cellsMat[raw][column];
		}
		return -1;
	}

	public boolean checkLine(int raw, int column, int value) {
		for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
			if (j != column && this.cellsMat[raw][j] == value) {
				return true;

			}
		}

		return false;
	}

	public boolean checkColumn(int raw, int column, int value) {
		for (int i = 0; i < NUMBER_OF_RAWS; i++) {
			if (i != raw && this.cellsMat[i][column] == value) {
				return true;

			}
		}

		return false;
	}

}
