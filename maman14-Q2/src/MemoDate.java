
public class MemoDate {

	private String day;
	private String month;
	private String year;

	public MemoDate(String day, String month, String year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MemoDate) {
			MemoDate objDate = (MemoDate) obj;

			if (this.day.equals(objDate.getDay()) == true && this.month.equals(objDate.getMonth()) == true
					&& this.year.equals(objDate.getYear()) == true) {

				return true;

			}

		}
		return false;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override

	public String toString() {
		return "[" + day + "/" + month + "/" + year + "]";
	}

}
