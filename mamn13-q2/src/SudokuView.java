import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class SudokuView extends JFrame implements ISudokuView {

	
	
	public void showError(String errMessage) {
		JOptionPane.showMessageDialog(this, errMessage);
	}
}
