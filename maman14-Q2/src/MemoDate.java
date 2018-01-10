import java.io.Serializable;

public class MemoDate implements Serializable {

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + day;
		result = prime * result + month;
		result = prime * result + year;
		return result;
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

	public boolean isLegal() {

		int leap = 0;
		boolean legal = false;

		if (this.year % 400 == 0 || (this.year % 100 != 0 && this.year % 4 == 0)) {
			leap = 1;
		}

		if (this.month == 1 || this.month == 3 || this.month == 5 || this.month == 7 || this.month == 8
				|| this.month == 10 || this.month == 12) {
			if (this.day <= 31) {
				legal = true;
			}
		} else if (this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11) {
			if (this.day <= 30) {
				legal = true;
			}
		} else {
			if (leap == 1) {
				if (this.day <= 29) {
					legal = true;
				}
			}
			if (leap == 0) {
				{
					if (this.day <= 28)
						legal = true;
				}
			}
		}

		return legal;

	}

}
