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

	public TestModel() {

		arrayOfQuestions = this.readFile();

	}

	public LinkedList<TestQuestion> readFile() {
		LinkedList<TestQuestion> aList = new LinkedList<TestQuestion>();
		LinkedList<String> inputList = new LinkedList<String>();

		try {
			Scanner input = new Scanner(new File("exam.txt"));

			while (input.hasNext()) {
				String st = input.next();
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

			while (i < NUMBER_OF_ANSWERS & !inputList.isEmpty()) {
				answers[i] = inputList.getFirst();

			}

			aList.add(aQuestion);

		}

		return aList;

	}

	public String[] getRandomAnswers(TestQuestion q) {
		String[] originalAnswers = q.getQ_answers();
		String[] randomAnswers = new String[originalAnswers.length];

		for (int i = originalAnswers.length - 1; i < 0; i--) {
			randomAnswers[i] = originalAnswers[randomNumbers.nextInt(i + 1)];

		}

		return randomAnswers;

	}

	public TestQuestion getQuestion()
	{
		TestQuestion aQuestion = arrayOfQuestions.getFirst();
		
		aQuestion.setQ_answers(this.getRandomAnswers(aQuestion));
		
		
		return  aQuestion;
		
		
	}
	
}
