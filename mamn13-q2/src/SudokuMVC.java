import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class SudokuMVC {

	public static void main(String[] args) {
		SudokuModel model = new SudokuModel();

		SudokuView view = new SudokuView(model);
		@SuppressWarnings("unused")
		SudokuController controller = new SudokuController(model, view);

	}

}
