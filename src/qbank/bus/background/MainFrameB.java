package qbank.bus.background;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import qbank.copyright.CopyRightPanel;

public class MainFrameB extends JFrame {
	public static CopyRightPanel copy;
	public static ImageIcon logo;
	public static ImageIcon add;
	public static ImageIcon reset;
	public static ImageIcon query;
	public static Font font;
	public static Font fontCont;
	public static Color contColor;
	static{
		contColor=new Color(0xDEE8F2);
		Color bgColor=new Color(0x00ff00);
		Color txtColor=new Color(0xffffff);
		Font picFont=new Font(null,Font.BOLD,30);
		copy=new CopyRightPanel();
		logo=qbank.util.PaintUtil.paintAns("题",64,64,3,12,Color.blue,txtColor,new Font(null,Font.BOLD,60));
		add=qbank.util.PaintUtil.paintAns("   Add",120,60,10,15,bgColor,txtColor,picFont);
		reset=qbank.util.PaintUtil.paintAns(" Reset",120,60,10,15,Color.red,txtColor,picFont);
		query=qbank.util.PaintUtil.paintAns("  Query",120,60,5,15,Color.red,txtColor,picFont);
		font=new Font("微软雅黑",0,20);
		fontCont=new Font("宋体",0,26);
	}
	public static void main(String[] args) {
		JFrame frame =new MainFrameB();
		frame.setSize(1024, 735);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(logo.getImage());
		frame.setTitle("题库系统后台");
		
		JTabbedPane JTP=new JTabbedPane();//选项卡
		JTP.setSize(frame.getWidth(), frame.getHeight()-50);
		
		AddSelect selectP=new AddSelect();
		selectP.action();
		AddJudge judgeP=new AddJudge();
		judgeP.action();
		AddFilling fillingP=new AddFilling();
		fillingP.action();
		AddGuess guess=new AddGuess();
		guess.action();
		ManagerPage admin=new ManagerPage();
		admin.action();
		
		AddSelectD selectD =new AddSelectD();
		selectD.action();
		
		Addm_20 m_20 =new Addm_20();
		m_20.action();
		Addm_30 m_30 =new Addm_30();
		m_30.action();
		Addm_50 m_50 =new Addm_50();
		m_50.action();
		Addm_80 m_80 =new Addm_80();
		m_80.action();
		
		
		JTP.add("选择题",selectP);
		JTP.add("判断题",judgeP);
		JTP.add("填空题",fillingP);
		JTP.add("多选题",selectD);
		JTP.add("你画我猜",guess);
		JTP.add("附加1",m_20);
		JTP.add("附加2",m_30);
		JTP.add("附加3",m_50);
		JTP.add("附加4",m_80);
		JTP.add("管理员",admin);
		
		frame.add(JTP);
		frame.add(copy);
//		frame.setAlwaysOnTop(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
