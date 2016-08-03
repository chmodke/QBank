package qbank.bus.background;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import qbank.dao.FillingDAO;
import qbank.dao.m_80DAO;

public class Addm_80 extends JPanel {
	JTextArea question=new JTextArea();
	JTextArea answer=new JTextArea();
	JButton add=new JButton(MainFrameB.add);
	public Addm_80() {
		this.setSize(1024, 735);
		
		JLabel q=new JLabel("题目");
		JLabel t=new JLabel("正确答案");
		
		this.setLayout(null);
		question.setBounds(100, 50, 800, 250);
		answer.setBounds(100, 350, 800, 150);
		
		question.setBackground(MainFrameB.contColor);
		answer.setBackground(MainFrameB.contColor);
		
		question.setLineWrap(true);
		answer.setLineWrap(true);
		
		q.setBounds(50, 50, 50, 20);
		t.setBounds(10, 350, 80, 20);
		
		question.setFont(MainFrameB.fontCont);
		answer.setFont(MainFrameB.fontCont);
		
		q.setFont(MainFrameB.font);
		t.setFont(MainFrameB.font);
		
		
		add.setBounds(this.getWidth()/2, this.getHeight()-200, 120,60);
		this.add(question);
		this.add(answer);
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
				String answerT=answer.getText();
				boolean t=m_80DAO.addQuestion(questionT, answerT);
				if(t){
					question.setText("");
					answer.setText("");
					JOptionPane.showMessageDialog(null,"添加成功","提示",JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
	}
}
