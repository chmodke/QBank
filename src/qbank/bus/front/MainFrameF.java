package qbank.bus.front;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import qbank.copyright.CopyRightPanel;
import qbank.util.PaintUtil;
/**
 * 题库系统前台
 * @author KeHao
 *
 */
public class MainFrameF extends JFrame {
	public static CopyRightPanel copy;
	public static ImageIcon logo;
	public static ImageIcon ans;
	public static ImageIcon next;
	public static ImageIcon back;
	public static ImageIcon start;
	public static ImageIcon stop;
	public static ImageIcon reset;
	public static ImageIcon restart;
	public static ImageIcon read;
	public static ImageIcon A;
	public static ImageIcon B;
	public static ImageIcon C;
	public static ImageIcon D;
	public static ImageIcon AB;
	public static ImageIcon AC;
	public static ImageIcon AD;
	public static ImageIcon BC;
	public static ImageIcon BD;
	public static ImageIcon CD;
	public static ImageIcon ABC;
	public static ImageIcon ABD;
	public static ImageIcon ACD;
	public static ImageIcon BCD;
	public static ImageIcon ABCD;
	public static ImageIcon T;
	public static ImageIcon F;
	public static ImageIcon NU;
	
	public static Font font;
	public static Font fontCont;
	public static Color contColor;
	static{
		contColor=new Color(0xB9DA17);//文本框背景色
		Color bgColor=new Color(0x00ff00);
		Color txtColor=new Color(0xffffff);
		Font txtFont =new Font(null,Font.BOLD,80);
		Font picFont=new Font(null,Font.BOLD,30);
		copy=new CopyRightPanel();
		logo=PaintUtil.paintAns("题",64,64,3,12,Color.blue,txtColor,new Font(null,Font.BOLD,60));
		ans=PaintUtil.paintAns("Answer",120,60,5,15,bgColor,txtColor,picFont);
		next=PaintUtil.paintAns("  Next",120,60,10,15,bgColor,txtColor,picFont);
		back=PaintUtil.paintAns("  Back",120,60,10,15,Color.yellow,Color.green,picFont);
		start=PaintUtil.paintAns("  Start",120,60,10,15,new Color(0x009944),txtColor,picFont);
		stop=PaintUtil.paintAns("  Stop",120,60,10,15,new Color(0xA40000),txtColor,picFont);
		reset=PaintUtil.paintAns(" Reset",120,60,10,15,Color.red,txtColor,picFont);
		restart=PaintUtil.paintAns("Restart",120,60,5,15,Color.red,txtColor,picFont);
		read=PaintUtil.paintAns("Read",120,60,20,15,Color.red,txtColor,picFont);
		A=PaintUtil.paintAns(" A",250,130,10,30,bgColor,txtColor,txtFont);
		B=PaintUtil.paintAns(" B",250,130,10,30,bgColor,txtColor,txtFont);
		C=PaintUtil.paintAns(" C",250,130,10,30,bgColor,txtColor,txtFont);
		D=PaintUtil.paintAns(" D",250,130,10,30,bgColor,txtColor,txtFont);
		AB=PaintUtil.paintAns(" AB",250,130,10,30,bgColor,txtColor,txtFont);
		AC=PaintUtil.paintAns(" AC",250,130,10,30,bgColor,txtColor,txtFont);
		AD=PaintUtil.paintAns(" AD",250,130,10,30,bgColor,txtColor,txtFont);
		BC=PaintUtil.paintAns(" BC",250,130,10,30,bgColor,txtColor,txtFont);
		BD=PaintUtil.paintAns(" BD",250,130,10,30,bgColor,txtColor,txtFont);
		CD=PaintUtil.paintAns(" CD",250,130,10,30,bgColor,txtColor,txtFont);
		ABC=PaintUtil.paintAns(" ABC",250,130,10,30,bgColor,txtColor,txtFont);
		ABD=PaintUtil.paintAns(" ABD",250,130,10,30,bgColor,txtColor,txtFont);
		ACD=PaintUtil.paintAns(" ACD",250,130,10,30,bgColor,txtColor,txtFont);
		BCD=PaintUtil.paintAns(" BCD",250,130,10,30,bgColor,txtColor,txtFont);
		ABCD=PaintUtil.paintAns("ABCD",250,130,10,30,bgColor,txtColor,txtFont);
		T=PaintUtil.paintAns(" √",190,130,10,30,bgColor,txtColor,txtFont);
		F=PaintUtil.paintAns(" X",190,130,10,30,bgColor,txtColor,txtFont);
		NU=PaintUtil.paintAns("    ",250,130,0,0,new Color(0xeeeeee),txtColor,txtFont);
		font=new Font("微软雅黑",0,20);
		fontCont=new Font("宋体",Font.BOLD,26);
	}
	
	
	public static void main(String[] args) {
		JFrame frame =new MainFrameF();
		frame.setSize(1024, 735);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(logo.getImage());
		frame.setTitle("题库系统前台");
		
		JTabbedPane JTP=new JTabbedPane();//选项卡
		JTP.setSize(frame.getWidth(), frame.getHeight()-50);
		JTP.setBorder(null);
		
		Welcome wel =new Welcome();
		GetSelect selectP=new GetSelect();
		selectP.action();
		GetJudge judgeP=new GetJudge();
		judgeP.action();
		GetFilling fillingP=new GetFilling();
		fillingP.action();
		GetGuess guessP=new GetGuess();
		guessP.action();
		
		GetSelectD selDP=new GetSelectD();
		selDP.action();
		Getm_20 m_20P=new Getm_20();
		m_20P.action();
		Getm_30 m_30P=new Getm_30();
		m_30P.action();
		Getm_50 m_50P=new Getm_50();
		m_50P.action();
		Getm_80 m_80P=new Getm_80();
		m_80P.action();
		
		ManagerPage admin=new ManagerPage();
		admin.action();
		
		
		JTP.add("欢迎",wel);
		JTP.add("选择题",selectP);
		JTP.add("判断题",judgeP);
		JTP.add("填空题",fillingP);
		JTP.add("多选题",selDP);
		JTP.add("你画我猜",guessP);
		JTP.add("附加1",m_20P);
		JTP.add("附加2",m_30P);
		JTP.add("附加3",m_50P);
		JTP.add("附加4",m_80P);
		JTP.add("管理员",admin);
		frame.getContentPane().setBackground(new Color(0x00ffff));//设置frame的背景色
		frame.add(JTP);
		frame.add(copy);
//		frame.setAlwaysOnTop(true);
		frame.setResizable(false);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

