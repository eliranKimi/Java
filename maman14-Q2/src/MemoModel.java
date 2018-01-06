import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;
import java.util.Scanner;

public class MemoModel {

	private Hashtable<MemoDate, String> memoHash;

	public MemoModel() {
		memoHash = new Hashtable<MemoDate, String>();

	}

	public void readMemosHashFromFile(String filePath) throws ClassNotFoundException, IOException {

		ObjectInputStream writeFile = null;

		try {
			writeFile = new ObjectInputStream(new FileInputStream(filePath));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	//	if (writeFile != null && writeFile.readObject() instanceof Hashtable<?, ?>) {
			memoHash = (Hashtable<MemoDate, String>) writeFile.readObject();
	//	}

		writeFile.close();


	}

	public void writeMemosHashToFile(String filePath) throws IOException {
		ObjectOutputStream writeFile = null;

		try {
			writeFile = new ObjectOutputStream(new FileOutputStream(filePath, false));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (writeFile != null) {
			writeFile.writeObject(memoHash);
		}

		writeFile.close();

	}

	public String getMemo(MemoDate selectedDate, String fileName) {

		try {
			this.readMemosHashFromFile(fileName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (this.memoHash.containsKey(selectedDate) == true) {
			return this.memoHash.get(selectedDate);
		}

		return "";

	}

	public void openFile() {
		// TODO Auto-generated method stub

	}

	public void saveMemo(MemoDate selectedDate, String memoText, String fileName) {

		if (memoHash.get(selectedDate) != null) {
			memoHash.remove(selectedDate);

		}
		memoHash.put(selectedDate, memoText);

		try {
			this.writeMemosHashToFile(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
