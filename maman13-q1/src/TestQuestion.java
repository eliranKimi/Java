import java.security.SecureRandom;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class TestQuestion extends JPanel {

	
	// RANDOM NUMBERS GENERATOR CONSTANT
	private static final SecureRandom randomNumbers = new SecureRandom();
	
	private String []q_answers;
	private String correctAnswer;
	private boolean testAnswer;

	
	
	private JLabel q_label = new JLabel();
	private JRadioButton q_answer1 = new JRadioButton();
	private JRadioButton q_answer2 = new JRadioButton();
	private JRadioButton q_answer3 = new JRadioButton();
	private JRadioButton q_answer4 = new JRadioButton();
	
	public TestQuestion(String content,String[] answers) {
		super();
			
		this.q_label.setText(content);
		
		this.correctAnswer = answers[0];
		this.testAnswer = false;
		
		this.setRadioButtons(randomAnswersArray(answers));
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		ButtonGroup answerGroup = new ButtonGroup();
		answerGroup.add(q_answer1);
		answerGroup.add(q_answer2);
		answerGroup.add(q_answer3);
		answerGroup.add(q_answer4);
		
		
		this.add(q_label);
		this.add(q_answer1);
		this.add(q_answer2);
		this.add(q_answer3);
		this.add(q_answer4);
	
	}
	
	
	private void setRadioButtons(String[] randomAnswersArray) {
		
		q_answer1.setText(randomAnswersArray[0]);
		q_answer2.setText(randomAnswersArray[1]);
		q_answer3.setText(randomAnswersArray[2]);
		q_answer4.setText(randomAnswersArray[3]);
		
	}


	public String[] randomAnswersArray(String[] originalAnswers) {
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

//	public TestQuestion(String q_content, String[] q_answers,String theAnswer) {
//		super();
//		this.q_content = q_content;
//		this.q_answers= q_answers;
//		this.theAnswer = theAnswer;
//		this.resetCorrectAnswer();
//	}
//	
//	public String getTheAnswer() {
//		return theAnswer;
//	}
//
//	public void setTheAnswer(String theAnswer) {
//		this.theAnswer = theAnswer;
//	}
//
//	public void resetCorrectAnswer()
//	{
//		this.testAnswer = false;
//
//	}
//
//	public TestQuestion(String q_content) {
//		super();
//		this.q_content = q_content;
//	
//	}
//	
//	public void setTestAnswer(String answer)
//	{
//		if (this.theAnswer == answer)
//		{
//			testAnswer = true;
//			
//		}
//
//	}
//	
//
//	
//	public String getQ_content() {
//		return q_content;
//	}
//
//	public void setQ_content(String q_content) {
//		this.q_content = q_content;
//	}
//
//	public String[] getQ_answers() {
//		return q_answers;
//	}
//
//	public void setQ_answers(String[] q_answers) {
//		this.q_answers = q_answers;
//	}
//
//	public boolean getCorrectAnswer() {
//		// TODO Auto-generated method stub
//		return testAnswer;
//	}
//
//	public TestQuestion cloneQuestion() {
//		TestQuestion q = new TestQuestion(this.getQ_content(),this.copyOfAnswers(),this.copyOfAnswers()[0]);
//		return q;
//	}
//
//	private String[] copyOfAnswers() {
//		String []q_answers_cpy = new String[q_answers.length];
//		
//		System.arraycopy(q_answers, 0, q_answers_cpy, 0, q_answers.length);
//		
//		return q_answers_cpy;
//	}
//

}
