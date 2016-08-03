package qbank.bus.background;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import qbank.dao.JudgeDAO;

public class AddJudge extends JPanel{
	JTextArea question=new JTextArea();
	ButtonGroup answer =new ButtonGroup();
	JRadioButton ansA=new JRadioButton("正确",true);
	JRadioButton ansB=new JRadioButton("错误");
	JButton add=new JButton(MainFrameB.add);
	public AddJudge() {
		this.setSize(1024, 735);
		
		JLabel q=new JLabel("题目");
		JLabel t=new JLabel("正确答案");
		
		this.setLayout(null);
		question.setBounds(100, 50, 800, 250);
		ansA.setBounds(100, 350, 90, 35);
		ansB.setBounds(200, 350, 90, 35);
		
		ansA.setFont(MainFrameB.fontCont);
		ansB.setFont(MainFrameB.fontCont);
		
		question.setBackground(MainFrameB.contColor);
//		answer.setBackground(MainFrameB.contColor);
		
		question.setLineWrap(true);
		
		q.setBounds(50, 50, 50, 20);
		t.setBounds(10, 350, 80, 20);
		
		question.setFont(MainFrameB.fontCont);
		
		q.setFont(MainFrameB.font);
		t.setFont(MainFrameB.font);
		
		
		add.setBounds(this.getWidth()/2, this.getHeight()-200, 120,60);
		
		answer.add(ansA);
		answer.add(ansB);
		
		this.add(question);
		this.add(ansA);
		this.add(ansB);
		this.add(add);
		this.add(q);
		this.add(t);
		this.setVisible(true);
	}
	public void action(){
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String questionT=question.getText();
				int answerT=0;
				if(ansA.isSelected()){
					answerT=1;
				}else if(ansB.isSelected()){
					answerT=0;
				}
				boolean t=JudgeDAO.addQuestion(questionT, answerT);
				if(t){
					question.setText("");
					ansA.setSelected(true);
					JOptionPane.showMessageDialog(null,"添加成功","提示",JOptionPane.PLAIN_MESSAGE); 
				}
			}
		});
	}
}
