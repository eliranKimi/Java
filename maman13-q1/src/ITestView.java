import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JPanel;

public interface ITestView {

	public void addResetListener(ActionListener resetListener);

	public void addFinishListener(ActionListener finishListener);

	public void showError(String errMessage);
	
	public void addQuestionsToPanel(LinkedList<TestQuestion> questions, JPanel questionPanel);

}
