package qbank.bus.front;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import qbank.dao.FillingDAO;
import qbank.dao.Game_GuessDAO;
import qbank.dao.JudgeDAO;
import qbank.dao.SelectDAO;
import qbank.util.ARRUtil;
import qbank.util.LogUtil;

public class ManagerPage extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6222411944200278679L;
	JButton reset=new JButton(MainFrameF.reset);
	JButton create=new JButton(MainFrameF.restart);
	JButton read =new JButton(MainFrameF.read);
	
	JLabel selDes2=new JLabel("选择题题库长度");
	JTextField selectLength=new JTextField("1");
	
	JLabel judDes2=new JLabel("判断题题库长度");
	JTextField judgeLength=new JTextField("1");
	
	JLabel fillDes2=new JLabel("填空题题库长度");
	JTextField fillingLength=new JTextField("1");
	
	JLabel guessDes2=new JLabel("你画我猜题长度");
	JTextField guessLength=new JTextField("1");
	
	JLabel selectDDes2=new JLabel("多选题题库长度");
	JTextField selectDLength=new JTextField("1");
	
	JLabel m_20Des2=new JLabel("20分题题库长度");
	JTextField m_20Length=new JTextField("1");
	
	JLabel m_30Des2=new JLabel("30分题题库长度");
	JTextField m_30Length=new JTextField("1");
	
	JLabel m_50Des2=new JLabel("50分题题库长度");
	JTextField m_50Length=new JTextField("1");
	
	JLabel m_80Des2=new JLabel("80分题题库长度");
	JTextField m_80Length=new JTextField("1");
	
	JLabel guessDes3=new JLabel("题库长度大于1，否则无法随机");
	
	
	public ManagerPage() {
		this.setSize(1024, 735);
		this.setLayout(null);
		JLabel tip1=new JLabel("重置所有不可用标记");
		reset.setBounds(200, 50, 120,60);
		tip1.setBounds(50, 50, 120, 20);
		
//		selDes1.setBounds(50, 200, 120, 20);
//		selectConnt.setBounds(145, 200, 40, 20);
		selDes2.setBounds(50, 200, 120, 20);
		selectLength.setBounds(145, 200, 40, 20);
		
//		judDes1.setBounds(50, 230, 120, 20);
//		judgeConnt.setBounds(145, 230, 40, 20);
		judDes2.setBounds(50, 230, 120, 20);
		judgeLength.setBounds(145, 230, 40, 20);
		
//		fillDes1.setBounds(50, 260, 120, 20);
//		fillingConnt.setBounds(145, 260, 40, 20);
		fillDes2.setBounds(50, 260, 120, 20);
		fillingLength.setBounds(145, 260, 40, 20);
		
//		guessDes1.setBounds(50, 290, 120, 20);
//		guessConnt.setBounds(145, 290, 40, 20);
		guessDes2.setBounds(50, 290, 120, 20);
		guessLength.setBounds(145, 290, 40, 20);
		guessDes3.setBounds(550, 290, 300, 20);
		
		selectDDes2.setBounds(50, 320, 120, 20);
		selectDLength.setBounds(145, 320, 40, 20);
		
		m_20Des2.setBounds(230, 200, 120, 20);
		m_20Length.setBounds(325, 200, 40, 20);
		
		m_30Des2.setBounds(230, 230, 120, 20);
		m_30Length.setBounds(325, 230, 40, 20);
		
		m_50Des2.setBounds(230, 260, 120, 20);
		m_50Length.setBounds(325, 260, 40, 20);
		
		m_80Des2.setBounds(230, 290, 120, 20);
		m_80Length.setBounds(325, 290, 40, 20);
		
		
		create.setBounds(400, 220, 120,60);
		
		JLabel tip2=new JLabel("出现意外时读取上次记录");
		tip2.setBounds(400, 50, 160, 20);
		read.setBounds(570, 50, 120,60);
		
		
		this.add(reset);
		this.add(tip1);
//		this.add(selDes1);
//		this.add(selectConnt);
		this.add(selDes2);
		this.add(selectLength);
		
//		this.add(judDes1);
//		this.add(judgeConnt);
		this.add(judDes2);
		this.add(judgeLength);
		
//		this.add(fillDes1);
//		this.add(fillingConnt);
		this.add(fillDes2);
		this.add(fillingLength);
		
//		this.add(guessDes1);
//		this.add(guessConnt);
		this.add(guessDes2);
		this.add(guessLength);
		this.add(guessDes3);
		
		this.add(selectDDes2);
		this.add(selectDLength);
		
		this.add(m_20Des2);
		this.add(m_20Length);
		
		this.add(m_30Des2);
		this.add(m_30Length);
		
		this.add(m_50Des2);
		this.add(m_50Length);
		
		this.add(m_80Des2);
		this.add(m_80Length);
		
		this.add(create);
		this.add(read);
		this.add(tip2);
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
				if(t1&&t2&&t3&&t4){
					JOptionPane.showMessageDialog(null,"重置完成","提示",JOptionPane.PLAIN_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null,"重置失败","提示",JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		
		create.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GetSelect.index=-1;
				GetSelect.seqIndex=-1;
				GetJudge.index=-1;
				GetJudge.seqIndex=-1;
				GetFilling.index=-1;
				GetFilling.seqIndex=-1;
				
				GetGuess.index=0;
				GetGuess.seqIndex=0;
				GetGuess.i=0;
				
				GetSelectD.index=-1;
				GetSelectD.seqIndex=-1;
				Getm_20.index=-1;
				Getm_20.seqIndex=-1;
				Getm_30.index=-1;
				Getm_30.seqIndex=-1;
				Getm_50.index=-1;
				Getm_50.seqIndex=-1;
				Getm_80.index=-1;
				Getm_80.seqIndex=-1;
				GetSelect.selectSerial=ARRUtil.random_serial(Integer.parseInt(selectLength.getText()));
				GetJudge.judgeSerial=ARRUtil.random_serial(Integer.parseInt(judgeLength.getText()));
				GetFilling.fillingSerial=ARRUtil.random_serial(Integer.parseInt(fillingLength.getText()));
				GetGuess.guessSerial1=ARRUtil.random_serial(Integer.parseInt(guessLength.getText()));
				GetGuess.guessSerial2=ARRUtil.random_serial(Integer.parseInt(guessLength.getText()));
				GetSelectD.selectDSerial=ARRUtil.random_serial(Integer.parseInt(selectDLength.getText()));
				Getm_20.m_20Serial=ARRUtil.random_serial(Integer.parseInt(m_20Length.getText()));
				Getm_30.m_30Serial=ARRUtil.random_serial(Integer.parseInt(m_30Length.getText()));
				Getm_50.m_50Serial=ARRUtil.random_serial(Integer.parseInt(m_50Length.getText()));
				Getm_80.m_80Serial=ARRUtil.random_serial(Integer.parseInt(m_80Length.getText()));
				JOptionPane.showMessageDialog(null,"重启完成","提示",JOptionPane.PLAIN_MESSAGE);
			}
		});
		
		read.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				GetSelect.index=-1;
				GetSelect.seqIndex=-1;
				GetJudge.index=-1;
				GetJudge.seqIndex=-1;
				GetFilling.index=-1;
				GetFilling.seqIndex=-1;
				
				GetGuess.index=0;
				GetGuess.seqIndex=0;
				GetGuess.i=0;
				
				GetSelectD.index=-1;
				GetSelectD.seqIndex=-1;
				Getm_20.index=-1;
				Getm_20.seqIndex=-1;
				Getm_30.index=-1;
				Getm_30.seqIndex=-1;
				Getm_50.index=-1;
				Getm_50.seqIndex=-1;
				Getm_80.index=-1;
				Getm_80.seqIndex=-1;
				int [][] sers=null;
				try{
					sers=LogUtil.readLog();
					if(sers[0].length>0){
						JOptionPane.showMessageDialog(null,"读取完成","提示",JOptionPane.PLAIN_MESSAGE);
					}
				}catch(NullPointerException e1){
					JOptionPane.showMessageDialog(null,"检查日志文件是否存在","提示",JOptionPane.PLAIN_MESSAGE);
					return ;
				}
				GetSelect.selectSerial=sers[0];
				GetJudge.judgeSerial=sers[1];
				GetFilling.fillingSerial=sers[2];
				GetGuess.guessSerial1=sers[3];
				GetGuess.guessSerial2=sers[4];
				GetSelectD.selectDSerial=sers[5];
				Getm_20.m_20Serial=sers[6];
				Getm_30.m_30Serial=sers[7];
				Getm_50.m_50Serial=sers[8];
				Getm_80.m_80Serial=sers[9];
			}
		});
	}
}
