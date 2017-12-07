
public class TestQuestion {

	private String q_content;
	private String q_answer1;
	private String q_answer2;
	private String q_answer3;
	private String q_answer4;
	private int q_correctAnswerIndex;

	public TestQuestion(String q_content, String q_answer1, String q_answer2, String q_answer3, String q_answer4,
			int q_correctAnswerIndex) {
		super();
		this.q_content = q_content;
		this.q_answer1 = q_answer1;
		this.q_answer2 = q_answer2;
		this.q_answer3 = q_answer3;
		this.q_answer4 = q_answer4;
		this.q_correctAnswerIndex = q_correctAnswerIndex;
	}

	public TestQuestion(String q_content) {
		super();
		this.q_content = q_content;
	
	}
	
//	public String[] getAnswers()
//	{
//		String 
//		
//	}

	public String getQ_content() {
		return q_content;
	}

	public void setQ_content(String q_content) {
		this.q_content = q_content;
	}

	public String getQ_answer1() {
		return q_answer1;
	}

	public void setQ_answer1(String q_answer1) {
		this.q_answer1 = q_answer1;
	}

	public String getQ_answer2() {
		return q_answer2;
	}

	public void setQ_answer2(String q_answer2) {
		this.q_answer2 = q_answer2;
	}

	public String getQ_answer3() {
		return q_answer3;
	}

	public void setQ_answer3(String q_answer3) {
		this.q_answer3 = q_answer3;
	}

	public String getQ_answer4() {
		return q_answer4;
	}

	public void setQ_answer4(String q_answer4) {
		this.q_answer4 = q_answer4;
	}

	public int getQ_correctAnswerIndex() {
		return q_correctAnswerIndex;
	}

	public void setQ_correctAnswerIndex(int q_correctAnswerIndex) {
		this.q_correctAnswerIndex = q_correctAnswerIndex;
	}

}
