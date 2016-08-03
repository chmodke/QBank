package qbank.bus.front;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import qbank.dao.Game_GuessDAO;
import qbank.vo.Game_Guess;

public class GetGuess extends JPanel {
	public static int[]guessSerial1=null;//形容词控制序列
	public static int[]guessSerial2=null;//名词控制序列
	private static List<Game_Guess> guess_base;//从数据库中取出全部数据，待使用
	public static int index=0;//序号
	public static int seqIndex=0;//题目号计数器
	public static int i=0;//已取出题目数量
	private Game_Guess guess=null;//临时取出的题目
	private boolean ss=false;//停止死循环的标志
	private Random rand=new Random();
	Timer timer=null;//随机效果定时器
	Font font=new Font("微软雅黑",0,60);
	
	JTextArea adj=new JTextArea();
	JTextArea noun=new JTextArea();
	JLabel seq=new JLabel("1-0");
	JButton start=new JButton(MainFrameF.start);
	JButton stop=new JButton(MainFrameF.stop);
	JLabel t=new JLabel("的");
	public GetGuess() {
		this.setSize(1024, 735);
		
		JLabel q=new JLabel("题目");
		JLabel t=new JLabel("的");
		
		adj.setBackground(MainFrameF.contColor);
		noun.setBackground(MainFrameF.contColor);
		
		adj.setLineWrap(true);
		noun.setLineWrap(true);
		
		adj.setEditable(false);
		noun.setEditable(false);
		
		this.setLayout(null);
		adj.setBounds(100, 50, 300, 250);
		noun.setBounds(500, 50, 300, 250);
		q.setBounds(30, 50, 50, 20);
		t.setBounds(420, 120, 80, 80);
		seq.setBounds(20, 70, 70, 20);
		
		adj.setFont(font);
		noun.setFont(font);
		q.setFont(MainFrameF.font);
		t.setFont(font);
		seq.setFont(MainFrameF.font);
		
		start.setBounds(this.getWidth()/2, this.getHeight()-200, 120,60);
		stop.setBounds(this.getWidth()/2+150, this.getHeight()-200, 120,60);
		this.add(adj);
		this.add(noun);
		this.add(start);
		this.add(stop);
		this.add(q);
		this.add(t);
		this.add(seq);
		this.setVisible(true);
		guess_base =Game_GuessDAO.getGuessBase();//取题库
	}
	public void action(){
		start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					ss=true;
					timer=new Timer();
					timer.schedule(new TimerTask(){
						@Override
						public void run() {
							if(ss&&i<guessSerial1.length){
								int id=rand.nextInt(guess_base.size());
								guess=guess_base.get(id);
								adj.setText(guess.getAdj());
								noun.setText(guess.getNoun());
							}else{
								adj.setText("不好意思");
								noun.setText("没有了");
							}
						}
					},200,50);
			}
		});
		stop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				i++;
				ss=false;
				if(timer!=null){
					timer.cancel();
				}
				int id1=guessSerial1[index];
				guess=Game_GuessDAO.getGuessUN(id1);
				adj.setText(guess.getAdj());
				
				int id2=guessSerial2[index++];
				guess=Game_GuessDAO.getGuessUN(id2);
				noun.setText(guess.getNoun());
				
				seq.setText((seqIndex/10+1)+"-"+(seqIndex%10+1));
				seqIndex++;
			}
		});
	}
}
