package qbank.bus.front;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import qbank.dao.JudgeDAO;
import qbank.vo.Judge;

public class GetJudge extends JPanel{
	public static int[]judgeSerial=null;
	public static int index=-1;//序号
	public static int seqIndex=-1;//题目号
	
	Judge judge=null;
	JTextArea question=new JTextArea();
	JLabel answer=new JLabel();
	JLabel seq=new JLabel("1-0");
	JButton getAns=new JButton(MainFrameF.ans);
	JButton getNext=new JButton(MainFrameF.next);
	JButton getBack=new JButton(MainFrameF.back);
	public GetJudge() {
		this.setSize(1024, 735);
		
		JLabel q=new JLabel("题目");
		JLabel t=new JLabel("正确答案");
		
		q.setFont(MainFrameF.font);
		t.setFont(MainFrameF.font);
		seq.setFont(MainFrameF.font);
		
		this.setLayout(null);
		question.setBounds(100, 50, 800, 250);
		answer.setBounds(100, 350, 190, 130);
		
		question.setBackground(MainFrameF.contColor);
		answer.setBackground(MainFrameF.contColor);
		
		question.setFont(MainFrameF.fontCont);
		question.setLineWrap(true);
		
		question.setEditable(false);
		
		q.setBounds(30, 50, 50, 20);
		t.setBounds(10, 350, 120, 20);
		seq.setBounds(20, 70, 70, 20);
		
		getAns.setBounds(this.getWidth()/2, this.getHeight()-200, 120,60);
		getNext.setBounds(this.getWidth()/2+150, this.getHeight()-200, 120,60);
		getBack.setBounds(this.getWidth()/2-150, this.getHeight()-200, 120,60);
		
		this.add(question);
		this.add(answer);
		this.add(getAns);
		this.add(getNext);
		this.add(getBack);
		this.add(q);
		this.add(t);
		this.add(seq);
		this.setVisible(true);
	}

	public void action(){
		getBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(index>0){
//					do{
						--index;
						int id=judgeSerial[index];
						judge=JudgeDAO.getQuestion(id);
//					}while(judge.getFlag()==1);
					question.setText(judge.getQuestion());
					answer.setIcon(MainFrameF.NU);
					--seqIndex;
					seq.setText((seqIndex/10+1)+"-"+(seqIndex%10+1));
				}else{
					judge=null;
					question.setText("没有了");
					answer.setIcon(MainFrameF.NU);
				}
			}
		});
		getNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(index<judgeSerial.length-1){
//					do{
						++index;
						int id=judgeSerial[index];
						judge=JudgeDAO.getQuestion(id);
//					}while(judge.getFlag()==1);
					question.setText(judge.getQuestion());
					answer.setIcon(MainFrameF.NU);
					++seqIndex;
					seq.setText((seqIndex/10+1)+"-"+(seqIndex%10+1));
				}else{
					judge=null;
					question.setText("没有了");
					answer.setIcon(MainFrameF.NU);
				}
			}
		});
		getAns.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch(judge.getAnswer()){
				case 1:
					answer.setIcon(MainFrameF.T);
					break;
				case 0:
					answer.setIcon(MainFrameF.F);
					break;
				default:
					answer.setIcon(MainFrameF.NU);
				}
			}
		});
	}
}
