package qbank.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class PaintUtil {
	/**
	 * 
	 * @param ans 答案字符串
	 * @param width 答案位置宽度
	 * @param height 答案位置高度
	 * @param offsetLeft 距离左边距离
	 * @param offsetBottom 距离底部距离
	 * @param BGColor 答案背景颜色
	 * @param TXTColor 答案颜色
	 * @param font 答案字体
	 * @return 产生的图片
	 */
	public static ImageIcon paintAns(String ans,int width,int height,int offsetLeft,int offsetBottom,Color BGColor,Color TXTColor,Font font){
		/*
		 * 绘制答案
		 */
		//第一步：创建一个内存映像（画布）
		BufferedImage image=new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		//第二步：获得画笔
		Graphics g=image.getGraphics();
		//第三部：设置画笔颜色
		g.setColor(BGColor);
		//第四步：设置画布背景色
		g.fillRect(0, 0, width, height);
		//第五步：将答案绘制到图片上
		g.setColor(TXTColor);
		g.setFont(font);
		g.drawString(ans, offsetLeft, height-offsetBottom);
		return new ImageIcon(image);
	}
}
