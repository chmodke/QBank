package qbank.copyright;

import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import qbank.util.LogUtil;

public class CopyRightPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Font font=new Font("微软雅黑",0,15);
	private static String ver=null;
	static{
		Properties prop=new Properties();
		try {
			prop.load(new FileInputStream("config.properties"));
			ver =prop.getProperty("version");
		} catch (FileNotFoundException e) {
			LogUtil.Error("配置文件不存在 "+e.getMessage());
			JOptionPane.showMessageDialog(null,"检查配置文件是否存在","提示",JOptionPane.PLAIN_MESSAGE);
//			e.printStackTrace();
		} catch (IOException e) {
			LogUtil.Error("copyright打开文件失败 "+e.getMessage());
			JOptionPane.showMessageDialog(null,"打开文件失败 配置文件失败","提示",JOptionPane.PLAIN_MESSAGE);
//			e.printStackTrace();
		}
	}
	public CopyRightPanel() {
		JLabel version =new JLabel("版本:v."+ver);
		JLabel tips=new JLabel("此系统开源，请勿作为商业用途");
		JLabel copy=new JLabel("Powered by KeHao   Email:kehao1158115@outlook.com");
		version.setFont(font);
		tips.setFont(font);
		copy.setFont(font);
		this.setLayout(null);
		version.setBounds(10, 688, 100, 20);
		tips.setBounds(110, 688, 240, 20);
		copy.setBounds(600, 688, 450, 20);
		this.add(version);
		this.add(copy);
		this.add(tips);
		this.setVisible(true);
	}
}