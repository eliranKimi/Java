import java.util.ArrayList;

public interface IMemoModel {
	
	public boolean readMemosHashFromFile(String filePath);
	
	public void writeMemosHashToFile(String filePath);
	
	public String getMemo(MemoDate selectedDate, String fileName);
	
	public void saveMemo(MemoDate selectedDate, String memoText, String fileName);
	
	public ArrayList<Integer> getDaysArray();

	public ArrayList<Integer> getMonthsArray();
	
	public ArrayList<Integer> getYearsArray(int startingYear);
}
