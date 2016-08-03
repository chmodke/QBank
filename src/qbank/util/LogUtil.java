package qbank.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 用来写入读取日志（序列）
 * @author kehao
 *
 */
public class LogUtil {
	/**
	 * 写出日志
	 * @param context
	 * @return
	 */
	public static boolean WriteLog(String context){
		boolean flag=false;
		Date time=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String temp=sdf.format(time)+" "+context+'\n';
		PrintWriter pw=null;
		try {
			File file=new File(".log.x");
			if(!file.exists()){
				file.createNewFile();
			}
			FileOutputStream out=new FileOutputStream(file,true);
			OutputStreamWriter osw =new OutputStreamWriter(out,"utf-8");
			pw=new PrintWriter(osw,true);
			pw.print(temp);
			temp=null;
			flag=true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			pw.close();
		}
		return flag;
	}
	/**
	 * 读取日志，解析日志
	 * @return
	 */
	public static int[][] readLog(){
		int [][] log=new int[10][];
		File file=new File(".log.x");
		if(!file.exists()){
			return null;
		}
		BufferedReader br=null;
		//--------------读取日志
		String [] logs=new String [10];
		try {
			FileInputStream in=new FileInputStream(file);
			InputStreamReader isr=new InputStreamReader(in,"utf-8");
			br=new BufferedReader(isr);
			do{
				logs[0]=br.readLine();
				logs[1]=br.readLine();
				logs[2]=br.readLine();
				logs[3]=br.readLine();
				logs[4]=br.readLine();
				logs[5]=br.readLine();
				logs[6]=br.readLine();
				logs[7]=br.readLine();
				logs[8]=br.readLine();
				logs[9]=br.readLine();
			}while(br.read()>0);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
//		System.out.println(Arrays.toString(logs));
		
		//-------------------解析日志
		log[0]=strToInt((logs[0].substring(logs[0].indexOf("[")+1,logs[0].indexOf("]"))).split(", "));
		log[1]=strToInt((logs[1].substring(logs[1].indexOf("[")+1,logs[1].indexOf("]"))).split(", "));
		log[2]=strToInt((logs[2].substring(logs[2].indexOf("[")+1,logs[2].indexOf("]"))).split(", "));
		log[3]=strToInt((logs[3].substring(logs[3].indexOf("[")+1,logs[3].indexOf("]"))).split(", "));
		log[4]=strToInt((logs[4].substring(logs[4].indexOf("[")+1,logs[4].indexOf("]"))).split(", "));
		log[5]=strToInt((logs[5].substring(logs[5].indexOf("[")+1,logs[5].indexOf("]"))).split(", "));
		log[6]=strToInt((logs[6].substring(logs[6].indexOf("[")+1,logs[6].indexOf("]"))).split(", "));
		log[7]=strToInt((logs[7].substring(logs[7].indexOf("[")+1,logs[7].indexOf("]"))).split(", "));
		log[8]=strToInt((logs[8].substring(logs[8].indexOf("[")+1,logs[8].indexOf("]"))).split(", "));
		log[9]=strToInt((logs[9].substring(logs[9].indexOf("[")+1,logs[9].indexOf("]"))).split(", "));
		
		logs=null;
		return log;
	}
	/**
	 * 字符串数组转整型数组
	 * @param str
	 * @return
	 */
	private static int[] strToInt(String [] str){
		int [] arr=new int[str.length];
		for(int i=0;i<str.length;i++){
			arr[i]=Integer.parseInt(str[i]);
		}
		return arr;
	}
	
	public static void Error(String context){
		Date time=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String temp=sdf.format(time)+" "+context+'\n';
		PrintWriter pw=null;
		try {
			File file=new File(".error.x");
			if(!file.exists()){
				file.createNewFile();
			}
			FileOutputStream out=new FileOutputStream(file,true);
			OutputStreamWriter osw =new OutputStreamWriter(out,"utf-8");
			pw=new PrintWriter(osw,true);
			pw.print(temp);
			temp=null;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			pw.close();
		}
	}
}
