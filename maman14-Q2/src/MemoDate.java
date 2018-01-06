import java.io.Serializable;

public class MemoDate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int day;
	private int month;
	private int year;

	public MemoDate(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MemoDate) {
			MemoDate objDate = (MemoDate) obj;

			if (this.day == objDate.getDay() == true && this.month == objDate.getMonth() == true
					&& this.year == objDate.getYear() == true) {

				return true;

			}

		}
		return false;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override

	public String toString() {
		return "[" + day + "/" + month + "/" + year + "]";
	}

}
