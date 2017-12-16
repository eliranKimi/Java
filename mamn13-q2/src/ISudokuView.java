import java.awt.event.ActionListener;

import javax.swing.JTextField;

public interface ISudokuView {
	
	public void addSetListener(ActionListener setListener);
	
	public void addClearListener(ActionListener clearListener);
	
	public void showError(String errMessage);
	
	public void cellNotLegalAction(JTextField temp);
	
	public void disableSet();
	
	public void enableSet();

}
