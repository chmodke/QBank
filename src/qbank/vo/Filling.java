package qbank.vo;
/**
 * 填空题
 * question 问题；answer 答案； flag 可用标记
 * @author KeHao
 *
 */
public class Filling {
	private String question;
	private String answer;
	private int flag;
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
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
		return "Filling [question=" + question + ", answer=" + answer
				+ ", flag=" + flag + "]";
	}
	
}
