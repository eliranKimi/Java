
public interface ISudokuModel {
	
	public void lockBoardEnteredNumbers();
	public void resetAllBlocks();
	public boolean checkInput(int value);
	public boolean checkLineOnBlocks(int lineToCheck, int lineOfBlock, int value);
	public boolean columnLineOnBlocks(int columnToCheck, int columnOfBlock, int value);
	

}
