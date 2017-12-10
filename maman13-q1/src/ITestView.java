import java.awt.event.ActionListener;

public interface ITestView {

	public void addResetListener(ActionListener resetListener);

	public void addFinishListener(ActionListener finishListener);

	public void showError(String errMessage);

}
