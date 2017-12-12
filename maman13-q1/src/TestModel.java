import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class TestModel implements ITestModel {

	public static final int NUMBER_OF_ANSWERS = 4;
	public static final double PRECENT_BASE = 100.0;

	public final String dir = System.getProperty("user.dir");
	private LinkedList<TestQuestion> listOfQuestions;

	public LinkedList<TestQuestion> getListOfQuestions() {
		return listOfQuestions;
	}

	public void setListOfQuestions(LinkedList<TestQuestion> listOfQuestions) {
		this.listOfQuestions = listOfQuestions;
	}

	public TestModel() {

		listOfQuestions = this.readFile();

	}

	public LinkedList<TestQuestion> readFile() {
		LinkedList<TestQuestion> aList = new LinkedList<TestQuestion>();
		LinkedList<String> inputList = new LinkedList<String>();

		try {
			Scanner input = new Scanner(new File("exam.txt"));

			while (input.hasNext()) {
				String st = input.nextLine();
				inputList.add(st);
			}

			input.close();
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "File at: " + dir + "/exam.txt not found!");
			System.exit(0);

		}

		while (!inputList.isEmpty()) {
			int i = 0;
			String answers[] = new String[NUMBER_OF_ANSWERS];
			String aQuestionContent = inputList.getFirst();
			inputList.removeFirst();

			while (i < NUMBER_OF_ANSWERS & !inputList.isEmpty()) {
				answers[i] = inputList.getFirst();
				inputList.removeFirst();
				i++;

			}
			TestQuestion aQuestion = new TestQuestion(aQuestionContent, answers);

			aList.add(aQuestion);

		}

		return aList;

	}

	public void markAnswers() {
		for (int i = 0; i < listOfQuestions.size(); i++) {
			TestQuestion aQuestion = listOfQuestions.get(i);
			aQuestion.markSelectedAnswer(aQuestion.getTestAnswer());

		}

	}

	public void reset() {

		for (int i = 0; i < listOfQuestions.size(); i++) {
			listOfQuestions.get(i).resetQuestion();
		}

	}

	public double finish() {

		int count = this.getNumberOfCorrectAnswers();
		int size = listOfQuestions.size();
		double total = ((double) count / (double) size) * PRECENT_BASE;
		total = Double.parseDouble(new DecimalFormat("###.##").format(total));

		this.disableAllRadio();
		this.markAnswers();
		return total;

	}

	public int getNumberOfCorrectAnswers() {
		int count = 0;
		for (int i = 0; i < listOfQuestions.size(); i++) {
			if (listOfQuestions.get(i).getTestAnswer() == true) {
				count++;
			}

		}

		return count;

	}

	public void disableAllRadio() {
		for (int i = 0; i < listOfQuestions.size(); i++) {
			listOfQuestions.get(i).disableButtons();
		}
	}

	public boolean setAnswers(TestView m_view) {

		try {

			for (int i = 0; i < listOfQuestions.size(); i++) {
				listOfQuestions.get(i).setTestAnswer();

			}
		} catch (Exception e) {
			m_view.showError("Please answer all of the questions!");
			return false;
		}

		return true;

	}
}
