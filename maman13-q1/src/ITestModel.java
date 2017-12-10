import java.util.LinkedList;

public interface ITestModel {

	public void setListOfQuestions(LinkedList<TestQuestion> listOfQuestions);

	public LinkedList<TestQuestion> readFile();

	public void markAnswers();

	public void reset();

	public double finish();

	public int getNumberOfCorrectAnswers();

	public void disableAllRadio();

	public boolean setAnswers(TestView m_view);

}
