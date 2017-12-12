import java.awt.event.ActionListener;

public interface ISudokuView {
	
	public void addSetListener(ActionListener setListener);
	
	public void addClearListener(ActionListener clearListener);
	
	public void showError(String errMessage);

}
