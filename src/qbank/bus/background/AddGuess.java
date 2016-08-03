package qbank.bus.background;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import qbank.dao.Game_GuessDAO;

public class AddGuess extends JPanel {
	JTextArea adj=new JTextArea();
	JTextArea noun=new JTextArea();
	JButton add=new JButton(MainFrameB.add);
	public AddGuess() {
		this.setSize(1024, 735);
		
		JLabel q=new JLabel("题目");
		JLabel t=new JLabel("的");
		
		this.setLayout(null);
		adj.setBounds(100, 50, 300, 250);
		noun.setBounds(500, 50, 300, 250);
		
		adj.setBackground(MainFrameB.contColor);
		noun.setBackground(MainFrameB.contColor);
		
		adj.setLineWrap(true);
		noun.setLineWrap(true);
		
		q.setBounds(50, 50, 50, 20);
		t.setBounds(420, 120, 80, 80);
		
		adj.setFont(MainFrameB.fontCont);
		noun.setFont(MainFrameB.fontCont);
		
		q.setFont(MainFrameB.font);
		t.setFont(new Font("微软雅黑",0,50));
		
		
		add.setBounds(this.getWidth()/2, this.getHeight()-200, 120,60);
		this.add(adj);
		this.add(noun);
		this.add(add);
		this.add(q);
		this.add(t);
		this.setVisible(true);
	}
	public void action(){
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String ajdT=adj.getText();
				String nounT=noun.getText();
				boolean t=Game_GuessDAO.addGuess(ajdT, nounT);
				if(t){
					adj.setText("");
					noun.setText("");
					JOptionPane.showMessageDialog(null,"添加成功","提示",JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
	}
}
