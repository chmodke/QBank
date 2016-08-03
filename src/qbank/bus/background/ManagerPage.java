package qbank.bus.background;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import qbank.dao.FillingDAO;
import qbank.dao.Game_GuessDAO;
import qbank.dao.JudgeDAO;
import qbank.dao.SelectDAO;
import qbank.dao.Select_DDAO;
import qbank.dao.m_20DAO;
import qbank.dao.m_30DAO;
import qbank.dao.m_50DAO;
import qbank.dao.m_80DAO;

public class ManagerPage extends JPanel {
	JButton reset=new JButton(MainFrameB.reset);
	JButton state=new JButton(MainFrameB.query);
	
	JLabel selectDes=new JLabel("选择");
	JLabel judgeDes=new JLabel("判断");
	JLabel fillingDes=new JLabel("填空");
	JLabel guessDes=new JLabel("画猜");
	JLabel selectDDes=new JLabel("多选");
	JLabel m_20Des=new JLabel("20分");
	JLabel m_30Des=new JLabel("30分");
	JLabel m_50Des=new JLabel("50分");
	JLabel m_80Des=new JLabel("80分");
	
	JLabel select=new JLabel("");
	JLabel judge=new JLabel("");
	JLabel filling=new JLabel("");
	JLabel guess=new JLabel("");
	JLabel selectD=new JLabel("");
	JLabel m_20=new JLabel("");
	JLabel m_30=new JLabel("");
	JLabel m_50=new JLabel("");
	JLabel m_80=new JLabel("");
	
	public ManagerPage() {
		this.setSize(1024, 735);
		this.setLayout(null);
		JLabel tip1=new JLabel("重置所有不可用标记");
		JLabel tip2=new JLabel("查询题库状况");
		reset.setBounds(200, 50, 120,60);
		state.setBounds(400, 130, 120,60);
		tip1.setBounds(20, 50, 120, 20);
		tip2.setBounds(20, 120, 120, 20);
		
//		selectDes.setBounds(20, 140, 60, 20);
//		select.setBounds(80, 140, 60, 20);
//		judgeDes.setBounds(20, 170, 60, 20);
//		judge.setBounds(80, 170, 60, 20);
//		fillingDes.setBounds(20, 200, 60, 20);
//		filling.setBounds(80, 200, 60, 20);
//		guessDes.setBounds(20, 230, 60, 20);
//		guess.setBounds(80, 230, 60, 20);
//		selectDDes.setBounds(20, 260, 60, 20);
//		selectD.setBounds(80, 260, 60, 20);
		
		selectDes.setBounds(20, 140, 60, 20);
		select.setBounds(80, 140, 60, 20);
		judgeDes.setBounds(20, 170, 60, 20);
		judge.setBounds(80, 170, 60, 20);
		fillingDes.setBounds(20, 200, 60, 20);
		filling.setBounds(80, 200, 60, 20);
		guessDes.setBounds(20, 230, 60, 20);
		guess.setBounds(80, 230, 60, 20);
		selectDDes.setBounds(20, 260, 60, 20);
		selectD.setBounds(80, 260, 60, 20);
		
		m_20Des.setBounds(150, 140, 60, 20);
		m_20.setBounds(210, 140, 60, 20);
		m_30Des.setBounds(150, 170, 60, 20);
		m_30.setBounds(210, 170, 60, 20);
		m_50Des.setBounds(150, 200, 60, 20);
		m_50.setBounds(210, 200, 60, 20);
		m_80Des.setBounds(150, 230, 60, 20);
		m_80.setBounds(210, 230, 60, 20);
		
		this.add(reset);
		this.add(state);
		this.add(tip1);
		this.add(tip2);
		this.add(selectDes);
		this.add(select);
		this.add(judgeDes);
		this.add(judge);
		this.add(fillingDes);
		this.add(filling);
		this.add(guessDes);
		this.add(guess);
		this.add(selectDDes);
		this.add(selectD);
		this.add(m_20Des);
		this.add(m_20);
		this.add(m_30Des);
		this.add(m_30);
		this.add(m_50Des);
		this.add(m_50);
		this.add(m_80Des);
		this.add(m_80);
		this.setVisible(true);
	}
	public void action(){
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean t1=SelectDAO.resetFlag();
				boolean t2=JudgeDAO.resetFlag();
				boolean t3=FillingDAO.resetFlag();
				boolean t4=Game_GuessDAO.resetFlag();
				boolean t5=Select_DDAO.resetFlag();
				boolean t6=m_20DAO.resetFlag();
				boolean t7=m_30DAO.resetFlag();
				boolean t8=m_50DAO.resetFlag();
				boolean t9=m_80DAO.resetFlag();
				if(t1&&t2&&t3&&t4&&t5&&t6&&t7&&t8&&t9){
					JOptionPane.showMessageDialog(null,"重置完成","提示",JOptionPane.PLAIN_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null,"重置失败","提示",JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		state.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				select.setText(SelectDAO.getCount()+"");
				judge.setText(JudgeDAO.getCount()+"");
				filling.setText(FillingDAO.getCount()+"");
				guess.setText(Game_GuessDAO.getCount()+"");
				selectD.setText(Select_DDAO.getCount()+"");
				m_20.setText(m_20DAO.getCount()+"");
				m_30.setText(m_30DAO.getCount()+"");
				m_50.setText(m_50DAO.getCount()+"");
				m_80.setText(m_80DAO.getCount()+"");
			}
		});
	}
}
