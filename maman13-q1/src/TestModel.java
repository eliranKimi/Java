import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
public class TestModel {

	// RANDOM NUMBERS GENERATOR CONSTANT

	public static final int NUMBER_OF_ANSWERS = 4;
	private LinkedList<TestQuestion> arrayOfQuestions;

	public LinkedList<TestQuestion> getArrayOfQuestions() {
		return arrayOfQuestions;
	}

	public void setArrayOfQuestions(LinkedList<TestQuestion> arrayOfQuestions) {
		this.arrayOfQuestions = arrayOfQuestions;
	}

	public TestModel() {

		arrayOfQuestions = this.readFile();

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
			System.out.println("GOddamn");

		}

		while (!inputList.isEmpty()) {
			int i = 0;
			String answers[] = new String[NUMBER_OF_ANSWERS];
			String aQuestionContent = inputList.getFirst();

			// TestQuestion aQuestion = new TestQuestion(inputList.getFirst(),null);
			inputList.removeFirst();

			while (i < NUMBER_OF_ANSWERS & !inputList.isEmpty()) {
				answers[i] = inputList.getFirst();
				inputList.removeFirst();
				i++;

			}
			TestQuestion aQuestion = new TestQuestion(aQuestionContent, answers);
			// aQuestion.setQ_answers(answers);
			// aQuestion.setTheAnswer(answers[0]);

			aList.add(aQuestion);

		}

		return aList;

	}

	public void markAnswers() {
		for (int i = 0; i < arrayOfQuestions.size(); i++) {
			TestQuestion aQuestion = arrayOfQuestions.get(i);
			aQuestion.markSelectedAnswer(aQuestion.getTestAnswer());

		}

	}

	public void reset() {

		for (int i = 0; i < arrayOfQuestions.size(); i++) {
			arrayOfQuestions.get(i).resetCorrectAnswer();
		}

	}

	public float finish() {

		int count = this.getNumberOfCorrect();
		int size = arrayOfQuestions.size();
		float total = ((float) count / (float) size) * 100;

		this.disableAllRadio();
		this.markAnswers();
		return total;

	}

	private int getNumberOfCorrect() {
		int count = 0;
		for (int i = 0; i < arrayOfQuestions.size(); i++) {
			if (arrayOfQuestions.get(i).getTestAnswer() == true) {
				count++;
			}

		}

		return count;

	}

	public void disableAllRadio() {
		for (int i = 0; i < arrayOfQuestions.size(); i++) {
			arrayOfQuestions.get(i).disableButtons();
		}
	}

}
