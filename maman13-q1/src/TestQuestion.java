
public class TestQuestion {

	private String q_content;
	private String []q_answers;
	private String theAnswer;
	private boolean testAnswer;


	public TestQuestion(String q_content, String[] q_answers,String theAnswer) {
		super();
		this.q_content = q_content;
		this.q_answers= q_answers;
		this.theAnswer = theAnswer;
		this.resetCorrectAnswer();
	}
	
	public String getTheAnswer() {
		return theAnswer;
	}

	public void setTheAnswer(String theAnswer) {
		this.theAnswer = theAnswer;
	}

	public void resetCorrectAnswer()
	{
		this.testAnswer = false;

	}

	public TestQuestion(String q_content) {
		super();
		this.q_content = q_content;
	
	}
	
	public void setTestAnswer(String answer)
	{
		if (this.theAnswer == answer)
		{
			testAnswer = true;
			
		}

	}
	

	
	public String getQ_content() {
		return q_content;
	}

	public void setQ_content(String q_content) {
		this.q_content = q_content;
	}

	public String[] getQ_answers() {
		return q_answers;
	}

	public void setQ_answers(String[] q_answers) {
		this.q_answers = q_answers;
	}

	public boolean getCorrectAnswer() {
		// TODO Auto-generated method stub
		return testAnswer;
	}

	public TestQuestion cloneQuestion() {
		TestQuestion q = new TestQuestion(this.getQ_content(),this.copyOfAnswers(),this.copyOfAnswers()[0]);
		return q;
	}

	private String[] copyOfAnswers() {
		String []q_answers_cpy = new String[q_answers.length];
		
		System.arraycopy(q_answers, 0, q_answers_cpy, 0, q_answers.length);
		
		return q_answers_cpy;
	}


}
