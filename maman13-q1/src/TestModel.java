import java.io.File;
import java.io.FileNotFoundException;
import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.Scanner;

public class TestModel {

	// RANDOM NUMBERS GENERATOR CONSTANT
	private static final SecureRandom randomNumbers = new SecureRandom();

	public static final int NUMBER_OF_ANSWERS = 4;
	private LinkedList<TestQuestion> arrayOfQuestions;
	private int currentQuestion;
	

	public TestModel() {

		arrayOfQuestions = this.readFile();
		currentQuestion = 0;


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

			TestQuestion aQuestion = new TestQuestion(inputList.getFirst());
			inputList.removeFirst();

			while (i < NUMBER_OF_ANSWERS & !inputList.isEmpty()) {
				answers[i] = inputList.getFirst();
				inputList.removeFirst();
				i++;

			}
			aQuestion.setQ_answers(answers);
			aQuestion.setTheAnswer(answers[0]);

			aList.add(aQuestion);

		}

		return aList;

	}

	public String[] getRandomAnswers(TestQuestion q) {
		String[] originalAnswers = q.getQ_answers();
		String[] randomAnswers = new String[originalAnswers.length];
		System.arraycopy(originalAnswers, 0, randomAnswers, 0, originalAnswers.length);

		for (int i = originalAnswers.length - 1; i > 0; i--) {
			swap(randomAnswers, i, randomNumbers.nextInt(i + 1));

			// randomAnswers[i] = originalAnswers[randomNumbers.nextInt(i + 1)];

		}

		return randomAnswers;

	}
	


	public <T> void swap(T[] arr, int i, int j) {
		T tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public TestQuestion getNextQuestion() {

		if (currentQuestion < arrayOfQuestions.size()-1)
		{
			currentQuestion++;
		TestQuestion aQuestion = this.getCurrentQuestion();
		aQuestion.setQ_answers(this.getRandomAnswers(aQuestion));

		return aQuestion;
		}
		
		return null;

	}

	public void reset() {
		currentQuestion = 0;

		for (int i = 0; i < arrayOfQuestions.size(); i++) {
			arrayOfQuestions.get(i).resetCorrectAnswer();
		}

	}

	public TestQuestion getCurrentQuestion() {
		
	
		
		return arrayOfQuestions.get(currentQuestion);
	}

	public float finish() {

		if (currentQuestion == arrayOfQuestions.size()-1) {
			int count = this.getNumberOfCurrect();
			int size = arrayOfQuestions.size();
			float total = ((float)count / (float)size) * 100;
			
			return total;


		}

		return -1;

		// TODO Auto-generated method stub

	}

	private int getNumberOfCurrect() {
		int count = 0;
		for (int i = 0; i < arrayOfQuestions.size(); i++) {
			if (arrayOfQuestions.get(i).getCorrectAnswer() == true) {
				count++;
			}

		}

		return count;

	}

}
