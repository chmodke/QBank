package qbank.bus.front;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import qbank.util.LogUtil;

public class Welcome extends JPanel {
	public static ImageIcon welcome;
	static{
		Properties prop=new Properties();
		try {
			prop.load(new FileInputStream("config.properties"));
			String path=prop.getProperty("path");
			welcome=new ImageIcon(path);
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
	public Welcome() {
		this.setSize(1024, 735);
		JLabel bg=new JLabel(welcome);
		this.setLayout(null);
		bg.setBounds(0, -40, this.getWidth(), this.getHeight());
		this.add(bg);
		this.setVisible(true);
	}
}
