package qbank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import qbank.util.DBUtil;
import qbank.util.LogUtil;
import qbank.vo.Filling;

public class FillingDAO {
	/**
	 * 获取判断题目
	 * @param id
	 * @return
	 */
	public static Filling getQuestion(int id){
		Filling fill=null;
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="SELECT question,answer,flag "
				+ "FROM filling WHERE id=?";
		try {
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			fill=new Filling();
			while(rs.next()){
				fill.setQuestion(rs.getString("question"));
				fill.setAnswer(rs.getString("answer"));
				fill.setFlag(rs.getInt("flag"));
			}
			//使用过的题目标志后面不在使用
			if(!setFlag(id)){
				throw new Exception();
			}
		} catch (SQLException e) {
			LogUtil.Error("FillingDAO中获取题目不成 "+e.getMessage());
			JOptionPane.showMessageDialog(null,"检查数据库连接","提示",JOptionPane.PLAIN_MESSAGE);
		} catch (Exception e) {
			LogUtil.Error("FillingDAO中获取题目不成 "+e.getMessage());
			JOptionPane.showMessageDialog(null,"检查数据库连接","提示",JOptionPane.PLAIN_MESSAGE);
		}finally{
			DBUtil.closeConnection(conn);
		}
		return fill;
	}
	/**
	 * 修改当前记录Flag为1，使该题不可用
	 * @param id
	 * @return
	 */
	public static boolean setFlag(int id){
		boolean b=false;
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="UPDATE filling SET flag=1 WHERE id=?";
		try {
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			int t=ps.executeUpdate();
			if(t>0){
				b=true;
			}
		} catch (SQLException e) {
			LogUtil.Error("FillingDAO中修改Flag失败 "+e.getMessage());
			JOptionPane.showMessageDialog(null,"检查数据库连接","提示",JOptionPane.PLAIN_MESSAGE);
		}finally{
			DBUtil.closeConnection(conn);
		}
		return b;
	}
	/**
	 * 重置所有Flag
	 * @return
	 */
	public static boolean resetFlag(){
		boolean b=false;
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="UPDATE filling SET flag=0";
		try {
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			int t=ps.executeUpdate();
			if(t>0){
				b=true;
			}
		} catch (SQLException e) {
			LogUtil.Error("FillingDAO中重置Flag失败 "+e.getMessage());
			JOptionPane.showMessageDialog(null,"检查数据库连接","提示",JOptionPane.PLAIN_MESSAGE);
//			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return b;
	}
	public static boolean addQuestion(String question,String answer){
		boolean b=false;
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="INSERT INTO filling (question,answer,flag) VALUES (?,?,0);";
		try {
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, question);
			ps.setString(2, answer);
			int t=ps.executeUpdate();
			if(t>0){
				b=true;
			}
		} catch (Exception e) {
			LogUtil.Error("FillingDAO中添加题目失败 "+e.getMessage());
			JOptionPane.showMessageDialog(null,"检查数据库连接","提示",JOptionPane.PLAIN_MESSAGE);
		}finally{
			DBUtil.closeConnection(conn);
		}
		return b;
	}
	public static int getCount(){
		int count=0;
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="SELECT COUNT(*) count FROM filling;";
		try {
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				count=rs.getInt("count");
			}
		} catch (SQLException e) {
			LogUtil.Error("FiilingDAO中查询count失败 "+e.getMessage());
			JOptionPane.showMessageDialog(null,"检查数据库连接","提示",JOptionPane.PLAIN_MESSAGE);
		}finally{
			DBUtil.closeConnection(conn);
		}
		return count;
	}
}
