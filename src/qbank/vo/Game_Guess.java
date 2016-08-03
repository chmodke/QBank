package qbank.vo;

public class Game_Guess {
	private String adj;
	private String noun;
	private int flag;
	
	public Game_Guess(){
		
	}
	public Game_Guess(String adj,String noum){
		this.adj=adj;
		this.noun=noum;
	}
	public String getAdj() {
		return adj;
	}
	public void setAdj(String adj) {
		this.adj = adj;
	}
	public String getNoun() {
		return noun;
	}
	public void setNoun(String noun) {
		this.noun = noun;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "Game_Guess [adj=" + adj + ", noun=" + noun + ", flag=" + flag
				+ "]";
	}
}
