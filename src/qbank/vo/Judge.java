package qbank.vo;
/**
 * 判断题
 * question 问题；answer 答案 0/1；flag 可用标记
 * @author KeHao
 *
 */
public class Judge {
	private String question;
	private int answer;
	private int flag;
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int answer) {
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
		return "Judge [question=" + question + ", answer=" + answer + ", flag="
				+ flag + "]";
	}
	
}
