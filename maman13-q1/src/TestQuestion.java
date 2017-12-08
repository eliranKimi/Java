
public class TestQuestion {

	private String q_content;
	private String []q_answers;


	public TestQuestion(String q_content, String[] q_answers) {
		super();
		this.q_content = q_content;
		this.q_answers= q_answers;

	}

	public TestQuestion(String q_content) {
		super();
		this.q_content = q_content;
	
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


}
