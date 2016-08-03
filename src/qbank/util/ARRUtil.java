package qbank.util;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
/**
 * 生成随机序列
 * @author KeHao
 *
 */
public class ARRUtil {
	public static int[] random_serial(int limit,int need){
		int[] temp=new int[limit];
		int[] result=new int[need];
		for(int i=0;i<limit;i++){
			temp[i]=i;
		}
		int w;
		Random rand=new Random();
		for(int i=0;i<need;i++){
			w=rand.nextInt(limit-i)+i;
			int t=temp[i];
			temp[i]=temp[w];
			temp[w]=t;
			result[i]=temp[i]+1;
		}
		System.out.println(Arrays.toString(result));
		LogUtil.WriteLog(Arrays.toString(result));
		
		
		return result;
	}
	
	public static int[] random_serial(int length){
		int[] temp=new int[length];
		int[] result=new int[length];
		for(int i=0;i<length;i++){
			temp[i]=i;
		}
		int w;
		Random rand=new Random();
		for(int i=0;i<length;i++){
			w=rand.nextInt(length-i)+i;
			int t=temp[i];
			temp[i]=temp[w];
			temp[w]=t;
			result[i]=temp[i]+1;
		}
		System.out.println(Arrays.toString(result));
		LogUtil.WriteLog(Arrays.toString(result));
		
		
		return result;
	}
	/**
	 * 测试序列生成
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("序列长度：");
		int length=scan.nextInt();
		System.out.print("随机序列如下：");
		random_serial(length);
		scan.close();
	}
}
