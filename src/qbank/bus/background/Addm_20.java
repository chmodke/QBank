package qbank.bus.background;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import qbank.dao.SelectDAO;
import qbank.dao.m_20DAO;

public class Addm_20 extends JPanel {
	JTextArea question=new JTextArea();
	JTextArea answerA=new JTextArea();
	JTextArea answerB=new JTextArea();
	JTextArea answerC=new JTextArea();
	JTextArea answerD=new JTextArea();
	
	ButtonGroup answer =new ButtonGroup();
	JRadioButton ansA=new JRadioButton("A",true);
	JRadioButton ansB=new JRadioButton("B");
	JRadioButton ansC=new JRadioButton("C");
	JRadioButton ansD=new JRadioButton("D");
	JButton add=new JButton(MainFrameB.add);
	public Addm_20() {
		this.setSize(1024, 735);
		
		JLabel q=new JLabel("题目");
		JLabel a=new JLabel("A");
		JLabel b=new JLabel("B");
		JLabel c=new JLabel("C");
		JLabel d=new JLabel("D");
		JLabel t=new JLabel("正确答案");
		
		
		answer.add(ansA);
		answer.add(ansB);
		answer.add(ansC);
		answer.add(ansD);
		
		
		this.setLayout(null);
		question.setBounds(70, 20, 890, 200);
		answerA.setBounds(60, 250, 900, 60);
		answerB.setBounds(60, 320, 900, 60);
		answerC.setBounds(60, 390, 900, 60);
		answerD.setBounds(60, 460, 900, 60);
		
		question.setBackground(MainFrameB.contColor);
		answerA.setBackground(MainFrameB.contColor);
		answerB.setBackground(MainFrameB.contColor);
		answerC.setBackground(MainFrameB.contColor);
		answerD.setBackground(MainFrameB.contColor);
		
		question.setLineWrap(true);
		answerA.setLineWrap(true);
		answerB.setLineWrap(true);
		answerC.setLineWrap(true);
		answerD.setLineWrap(true);
		
		q.setBounds(30, 50, 50, 20);
		a.setBounds(40, 260, 50, 20);
		b.setBounds(40, 330, 50, 20);
		c.setBounds(40, 400, 50, 20);
		d.setBounds(40, 470, 50, 20);
		t.setBounds(10, 525, 120, 20);

		ansA.setBounds(100, 525, 80, 35);
		ansB.setBounds(200, 525, 80, 35);
		ansC.setBounds(100, 575, 80, 35);
		ansD.setBounds(200, 575, 80, 35);
		
		
		question.setFont(MainFrameB.fontCont);
		answerA.setFont(MainFrameB.fontCont);
		answerB.setFont(MainFrameB.fontCont);
		answerC.setFont(MainFrameB.fontCont);
		answerD.setFont(MainFrameB.fontCont);
		
		q.setFont(MainFrameB.font);
		a.setFont(MainFrameB.font);
		b.setFont(MainFrameB.font);
		c.setFont(MainFrameB.font);
		d.setFont(MainFrameB.font);
		t.setFont(MainFrameB.font);
		
		ansA.setFont(MainFrameB.fontCont);
		ansB.setFont(MainFrameB.fontCont);
		ansC.setFont(MainFrameB.fontCont);
		ansD.setFont(MainFrameB.fontCont);
		
		
		add.setBounds(this.getWidth()/2, this.getHeight()-200, 120,60);
		
		
		this.add(question);
		this.add(answerA);
		this.add(answerB);
		this.add(answerC);
		this.add(answerD);
		this.add(q);
		this.add(a);
		this.add(b);
		this.add(c);
		this.add(d);
		this.add(t);
		this.add(ansA);
		this.add(ansB);
		this.add(ansC);
		this.add(ansD);
		this.add(add);
		
		this.setVisible(true);
	}
	public void action(){
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String questionT=question.getText();
				String answerAT=answerA.getText();
				String answerBT=answerB.getText();
				String answerCT=answerC.getText();
				String answerDT=answerD.getText();
				String answerT=null;
				if(ansA.isSelected()){
					answerT="A";
				}else if(ansB.isSelected()){
					answerT="B";
				}else if(ansC.isSelected()){
					answerT="C";
				}else if(ansD.isSelected()){
					answerT="D";
				}
				boolean t=m_20DAO.addQuestion(questionT, answerAT, answerBT, answerCT, answerDT, answerT);
				if(t){
					question.setText("");
					answerA.setText("");
					answerB.setText("");
					answerC.setText("");
					answerD.setText("");
					ansA.setSelected(true);
					JOptionPane.showMessageDialog(null,"添加成功","提示",JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
	}
}
