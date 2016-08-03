package qbank.bus.front;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import qbank.dao.SelectDAO;
import qbank.dao.m_20DAO;
import qbank.vo.Select;
import qbank.vo.m_20;

public class Getm_20 extends JPanel {
	public static int[]m_20Serial=null;
	public static int index=-1;//序号
	public static int seqIndex=-1;//题目号
	m_20 sel=null;
	JTextArea question=new JTextArea();
	JTextArea answerA=new JTextArea();
	JTextArea answerB=new JTextArea();
	JTextArea answerC=new JTextArea();
	JTextArea answerD=new JTextArea();
	JLabel answer=new JLabel();
	JLabel seq=new JLabel("1-0");
	JButton getAns=new JButton(MainFrameF.ans);
	JButton getNext=new JButton(MainFrameF.next);
	JButton getBack=new JButton(MainFrameF.back);
	public Getm_20() {
		this.setSize(1024, 735);
		
		JLabel q=new JLabel("题目");
		JLabel a=new JLabel("A");
		JLabel b=new JLabel("B");
		JLabel c=new JLabel("C");
		JLabel d=new JLabel("D");
		JLabel t=new JLabel("正确答案");
		
		t.setFont(MainFrameF.font);
		q.setFont(MainFrameF.font);
		a.setFont(MainFrameF.font);
		b.setFont(MainFrameF.font);
		c.setFont(MainFrameF.font);
		d.setFont(MainFrameF.font);
		seq.setFont(MainFrameF.font);
		
		this.setLayout(null);
		question.setBounds(70, 20, 890, 200);
		answerA.setBounds(60, 250, 900, 60);
		answerB.setBounds(60, 320, 900, 60);
		answerC.setBounds(60, 390, 900, 60);
		answerD.setBounds(60, 460, 900, 60);
		answer.setBounds(100, 525, 250, 130);
		///////////////////////////////////////////////////////////////
		
		question.setLineWrap(true);
		answerA.setLineWrap(true);
		answerB.setLineWrap(true);
		answerC.setLineWrap(true);
		answerD.setLineWrap(true);
		
		question.setFont(MainFrameF.fontCont);
		answerA.setFont(MainFrameF.fontCont);
		answerB.setFont(MainFrameF.fontCont);
		answerC.setFont(MainFrameF.fontCont);
		answerD.setFont(MainFrameF.fontCont);
		
		question.setBackground(MainFrameF.contColor);
		answerA.setBackground(MainFrameF.contColor);
		answerB.setBackground(MainFrameF.contColor);
		answerC.setBackground(MainFrameF.contColor);
		answerD.setBackground(MainFrameF.contColor);
		answer.setBackground(MainFrameF.contColor);
		
		question.setEditable(false);
		answerA.setEditable(false);
		answerB.setEditable(false);
		answerC.setEditable(false);
		answerD.setEditable(false);
		
		q.setBounds(30, 50, 50, 20);
		a.setBounds(40, 260, 50, 20);
		b.setBounds(40, 330, 50, 20);
		c.setBounds(40, 400, 50, 20);
		d.setBounds(40, 470, 50, 20);
		t.setBounds(10, 525, 120, 20);
		seq.setBounds(20, 70, 70, 20);
		getAns.setBounds(this.getWidth()/2, this.getHeight()-200, 120,60);
		getNext.setBounds(this.getWidth()/2+150, this.getHeight()-200, 120,60);
		getBack.setBounds(this.getWidth()/2-150, this.getHeight()-200, 120,60);
		
		this.add(question);
		this.add(answerA);
		this.add(answerB);
		this.add(answerC);
		this.add(answerD);
		this.add(answer);
		this.add(q);
		this.add(a);
		this.add(b);
		this.add(c);
		this.add(d);
		this.add(t);
		this.add(seq);
		this.add(getAns);
		this.add(getNext);
		this.add(getBack);
		
		this.setVisible(true);
	}
	public void action(){
		getBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(index>0){
//					do{
						--index;
						int id=m_20Serial[index];
//						System.out.println(id);
						sel=m_20DAO.getQuestion(id);
//					}while(sel.getFlag()==1);
					question.setText(sel.getQuestion());
					answerA.setText(sel.getAnswerA());
					answerB.setText(sel.getAnswerB());
					answerC.setText(sel.getAnswerC());
					answerD.setText(sel.getAnswerD());
					answer.setIcon(MainFrameF.NU);
					--seqIndex;
					seq.setText((seqIndex/10+1)+"-"+(seqIndex%10+1));
					
				}else{
					sel=null;//释放sel对象，使结束后无法获取上次的答案
					question.setText("没有了");
					answerA.setText("");
					answerB.setText("");
					answerC.setText("");
					answerD.setText("");
					answer.setIcon(MainFrameF.NU);
				}
			}
		});
		getNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(index<m_20Serial.length-1){
//					do{
					++index;	
					int id=m_20Serial[index];
//						System.out.println(id);
						sel=m_20DAO.getQuestion(id);
//					}while(sel.getFlag()==1);
					question.setText(sel.getQuestion());
					answerA.setText(sel.getAnswerA());
					answerB.setText(sel.getAnswerB());
					answerC.setText(sel.getAnswerC());
					answerD.setText(sel.getAnswerD());
					answer.setIcon(MainFrameF.NU);
					++seqIndex;
					seq.setText((seqIndex/10+1)+"-"+(seqIndex%10+1));
					
				}else{
					sel=null;//释放sel对象，使结束后无法获取上次的答案
					question.setText("没有了");
					answerA.setText("");
					answerB.setText("");
					answerC.setText("");
					answerD.setText("");
					answer.setIcon(MainFrameF.NU);
				}
			}
		});
		getAns.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch(sel.getAnswer().toUpperCase()){
				case "A":
					answer.setIcon(MainFrameF.A);
					break;
				case "B":
					answer.setIcon(MainFrameF.B);
					break;
				case "C":
					answer.setIcon(MainFrameF.C);
					break;
				case "D":
					answer.setIcon(MainFrameF.D);
					break;
				case "AB":
					answer.setIcon(MainFrameF.AB);
					break;
				case "AC":
					answer.setIcon(MainFrameF.AC);
					break;
				case "AD":
					answer.setIcon(MainFrameF.AD);
					break;
				case "BC":
					answer.setIcon(MainFrameF.BC);
					break;
				case "BD":
					answer.setIcon(MainFrameF.BD);
					break;
				case "CD":
					answer.setIcon(MainFrameF.CD);
					break;
				case "ABC":
					answer.setIcon(MainFrameF.ABC);
					break;
				case "ABD":
					answer.setIcon(MainFrameF.ABD);
					break;
				case "ACD":
					answer.setIcon(MainFrameF.ACD);
					break;
				case "BCD":
					answer.setIcon(MainFrameF.BCD);
					break;
				case "ABCD":
					answer.setIcon(MainFrameF.ABCD);
					break;
				default:
					answer.setIcon(MainFrameF.NU);
				}
			}
		});
	}
}
