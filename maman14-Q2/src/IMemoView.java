import java.awt.event.ActionListener;

public interface IMemoView {
	
	public void addSaveListener(ActionListener saveListener);
	
	public void addGetMemoListener(ActionListener getMemoListener);
	
	public void showError(String errMessage);

	public MemoDate getSelectedDate();
	
	public String getMemoText();
	
	public String getFileName();
	
	public void setMemoText(String memo);
	
	public boolean dateIsLegal();
}
