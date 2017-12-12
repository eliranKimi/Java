
public interface ISudokuModel {

	public void lockBoardEnteredNumbers();

	public void resetAllBlocks();

	public boolean checkLineOnBlocks(int lineToCheck, int lineOfBlock, int value);

	public boolean columnLineOnBlocks(int columnToCheck, int columnOfBlock, int value);

	void checkInput(String input) throws Exception;

}
