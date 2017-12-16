import java.awt.Color;
import java.security.SecureRandom;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class TestQuestion extends JPanel {

	// RANDOM NUMBERS GENERATOR CONSTANT
	private static final SecureRandom randomNumbers = new SecureRandom();

	
	// An array of answers
	private String[] q_answers;
	
	// The correct answer for the question
	private String correctAnswer;
	
	
	// Boolean variable - represents the answer from the test
	private boolean testAnswer;

	
	
	// Visual Components 
	private JLabel q_label = new JLabel();
	private JRadioButton q_answer1 = new JRadioButton();
	private JRadioButton q_answer2 = new JRadioButton();
	private JRadioButton q_answer3 = new JRadioButton();
	private JRadioButton q_answer4 = new JRadioButton();
	private ButtonGroup answerGroup = new ButtonGroup();

	public TestQuestion(String content, String[] answers) {
		super();

		
		this.q_label.setText(content);
		this.correctAnswer = answers[0];
		this.testAnswer = false;
		this.q_answers = answers;

		this.setRadioButtons(randomAnswersArray(answers));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createLineBorder(Color.black));


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

	
	// Set text to radio buttons lables
	private void setRadioButtons(String[] randomAnswersArray) {

		q_answer1.setText(randomAnswersArray[0]);
		q_answer2.setText(randomAnswersArray[1]);
		q_answer3.setText(randomAnswersArray[2]);
		q_answer4.setText(randomAnswersArray[3]);

	}
	
	
	// Return a random array of answers

	public String[] randomAnswersArray(String[] originalAnswers) {
		String[] randomAnswers = new String[originalAnswers.length];
		System.arraycopy(originalAnswers, 0, randomAnswers, 0, originalAnswers.length);

		for (int i = originalAnswers.length - 1; i > 0; i--) {
			swap(randomAnswers, i, randomNumbers.nextInt(i + 1));
		}

		return randomAnswers;

	}

	
	// General swap function- used on randomAnswersArray function
	public <T> void swap(T[] arr, int i, int j) {
		T tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	
	// Reset all question's variables.
	public void resetQuestion() {
		this.testAnswer = false;
		this.resetRadioButtons();
		this.setRadioButtons(randomAnswersArray(this.q_answers));

	}

	
	// Disable all questions radio buttons
	public void disableButtons() {
		this.q_answer1.setEnabled(false);
		this.q_answer2.setEnabled(false);
		this.q_answer3.setEnabled(false);
		this.q_answer4.setEnabled(false);

	}

	
	// Reset radio buttons - background&enabled
	private void resetRadioButtons() {
		
		// Clear selected answer
		answerGroup.clearSelection();
		
		// Clear radio buttons background
		this.q_answer1.setBackground(null);
		this.q_answer2.setBackground(null);
		this.q_answer3.setBackground(null);
		this.q_answer4.setBackground(null);

		// Enable radio buttons 
		this.q_answer1.setEnabled(true);
		this.q_answer2.setEnabled(true);
		this.q_answer3.setEnabled(true);
		this.q_answer4.setEnabled(true);

	}

	
	// Set testAnswer in a question - throws an execption if no answer was selected
	public boolean setTestAnswer() throws Exception {
		String answer = this.getSelectedAnswer();
		if (answer != null) {
			if (this.correctAnswer == answer) {
				testAnswer = true;
			}
		} else {
			throw new Exception("Answer was not selected");
		}

		return true;

	}

	
	// Get selected answer text
	public String getSelectedAnswer() {
		if (q_answer1.isSelected())
			return q_answer1.getText();
		if (q_answer2.isSelected())
			return q_answer2.getText();
		if (q_answer3.isSelected())
			return q_answer3.getText();
		if (q_answer4.isSelected())
			return q_answer4.getText();

		return null;

	}
	
	//Mark an answer in green if the selected answer is true, otherwise mark it as red.

	public void markSelectedAnswer(boolean isCorrect) {

		if (isCorrect == true) {
			if (q_answer1.isSelected())
				q_answer1.setBackground(Color.GREEN);
			if (q_answer2.isSelected())
				q_answer2.setBackground(Color.GREEN);
			if (q_answer3.isSelected())
				q_answer3.setBackground(Color.GREEN);
			if (q_answer4.isSelected())
				q_answer4.setBackground(Color.GREEN);

		} else {
			if (q_answer1.isSelected())
				q_answer1.setBackground(Color.RED);
			if (q_answer2.isSelected())
				q_answer2.setBackground(Color.RED);
			if (q_answer3.isSelected())
				q_answer3.setBackground(Color.RED);
			if (q_answer4.isSelected())
				q_answer4.setBackground(Color.RED);

		}

	}

	
	// Return test answer
	public boolean getTestAnswer() {
		// TODO Auto-generated method stub
		return testAnswer;
	}

}
