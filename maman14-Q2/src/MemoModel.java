
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MemoModel extends JFrame implements IMemoModel {

	private static final long serialVersionUID = 1L;

	private static final int MIN_MONTH = 1;
	private static final int MAX_MONTH = 12;
	private static final int MIN_DAY = 1;
	private static final int MAX_DAY = 31;
	private static final int YEAR_RANGE = 30;

	private Hashtable<MemoDate, String> memoHash;

	public MemoModel() {
		memoHash = new Hashtable<MemoDate, String>();

	}

	public boolean readMemosHashFromFile(String filePath) {

		ObjectInputStream writeFile = null;

		try {
			writeFile = new ObjectInputStream(new FileInputStream(filePath));
			memoHash = (Hashtable<MemoDate, String>) writeFile.readObject();
			writeFile.close();

			return true;

		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "Either file dont exists or wrong format!");

		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(this, "Class not found!");

		}
		return false;

	}

	public void writeMemosHashToFile(String filePath) {
		ObjectOutputStream writeFile = null;

		try {
			writeFile = new ObjectOutputStream(new FileOutputStream(filePath, false));
			writeFile.writeObject(memoHash);
			writeFile.close();

		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "IO Exception in writing file!");
		}

	}

	public String getMemo(MemoDate selectedDate, String fileName) {
		this.readMemosHashFromFile(fileName);

		if (this.memoHash.containsKey(selectedDate) == true) {
			return this.memoHash.get(selectedDate);
		}

		return "";

	}

	public void saveMemo(MemoDate selectedDate, String memoText, String fileName) {

		if (memoHash.get(selectedDate) != null) {
			memoHash.remove(selectedDate);

		}
		memoHash.put(selectedDate, memoText);

		this.writeMemosHashToFile(fileName);

	}

	public ArrayList<Integer> getDaysArray() {
		ArrayList<Integer> daysArray = new ArrayList<Integer>();
		for (int i = MIN_DAY; i <= MAX_DAY; i++) {
			daysArray.add(i);
		}

		return daysArray;
	}

	public ArrayList<Integer> getMonthsArray() {
		ArrayList<Integer> monthsArray = new ArrayList<Integer>();
		for (int i = MIN_MONTH; i <= MAX_MONTH; i++) {
			monthsArray.add(i);
		}

		return monthsArray;
	}

	public ArrayList<Integer> getYearsArray(int startingYear) {
		ArrayList<Integer> yearsArray = new ArrayList<Integer>();
		for (int i = startingYear; i <= startingYear + YEAR_RANGE; i++) {
			yearsArray.add(i);
		}

		return yearsArray;
	}

}
