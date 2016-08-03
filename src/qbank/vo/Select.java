package qbank.vo;
/**
 * 单项选择题
 * question 问题；answerA；answerB；answerC；answerD；answer 正确选项A/B/C/D；flag 可用标记
 * @author KeHao
 *
 */
public class Select {
	private String question;
	private String answerA;
	private String answerB;
	private String answerC;
	private String answerD;
	private String answer;
	private int flag;
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswerA() {
		return answerA;
	}
	public void setAnswerA(String answerA) {
		this.answerA = answerA;
	}
	public String getAnswerB() {
		return answerB;
	}
	public void setAnswerB(String answerB) {
		this.answerB = answerB;
	}
	public String getAnswerC() {
		return answerC;
	}
	public void setAnswerC(String answerC) {
		this.answerC = answerC;
	}
	public String getAnswerD() {
		return answerD;
	}
	public void setAnswerD(String answerD) {
		this.answerD = answerD;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "S_Select [question=" + question + ", answerA=" + answerA
				+ ", answerB=" + answerB + ", answerC=" + answerC
				+ ", answerD=" + answerD + ", answer=" + answer + ", flag="
				+ flag + "]";
	}
	
}
