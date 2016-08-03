package qbank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import qbank.util.DBUtil;
import qbank.util.LogUtil;
import qbank.vo.m_50;

public class m_50DAO {
	/**
	 * 获取判断题目
	 * @param id
	 * @return
	 */
	public static m_50 getQuestion(int id){
		m_50 fill=null;
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="SELECT question,answer,flag "
				+ "FROM m_50 WHERE id=?";
		try {
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			fill=new m_50();
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
			LogUtil.Error("m_50DAO中获取题目失败 "+e.getMessage());
			JOptionPane.showMessageDialog(null,"检查数据库连接","提示",JOptionPane.PLAIN_MESSAGE);
//			e.printStackTrace();
		} catch (Exception e) {
			LogUtil.Error("m_50DAO中修改Flag不成功 "+e.getMessage());
//			e.printStackTrace();
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
		String sql="UPDATE m_50 SET flag=1 WHERE id=?";
		try {
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			int t=ps.executeUpdate();
			if(t>0){
				b=true;
			}
		} catch (SQLException e) {
			LogUtil.Error("m_50DAO中修改Flag失败 "+e.getMessage());
			JOptionPane.showMessageDialog(null,"检查数据库连接","提示",JOptionPane.PLAIN_MESSAGE);
//			e.printStackTrace();
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
		String sql="UPDATE m_50 SET flag=0";
		try {
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			int t=ps.executeUpdate();
			if(t>0){
				b=true;
			}
		} catch (SQLException e) {
			LogUtil.Error("m_50DAO中重置Flag失败 "+e.getMessage());
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
		String sql="INSERT INTO m_50 (question,answer,flag) VALUES (?,?,0);";
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
			LogUtil.Error("m_50DAO中添加题目失败 "+e.getMessage());
			JOptionPane.showMessageDialog(null,"检查数据库连接","提示",JOptionPane.PLAIN_MESSAGE);
//			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return b;
	}
	public static int getCount(){
		int count=0;
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="SELECT COUNT(*) count FROM m_50;";
		try {
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				count=rs.getInt("count");
			}
		} catch (SQLException e) {
			LogUtil.Error("m_50DAO中查询count失败 "+e.getMessage());
			JOptionPane.showMessageDialog(null,"检查数据库连接","提示",JOptionPane.PLAIN_MESSAGE);
//			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return count;
	}
}
