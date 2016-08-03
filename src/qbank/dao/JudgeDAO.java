package qbank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import qbank.util.DBUtil;
import qbank.util.LogUtil;
import qbank.vo.Judge;

public class JudgeDAO {
	/**
	 * 获取判断题目
	 * @param id
	 * @return
	 */
	public static Judge getQuestion(int id){
		Judge judge=null;
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="SELECT question,answer,flag "
				+ "FROM judge WHERE id=?";
		try {
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			judge=new Judge();
			while(rs.next()){
				judge.setQuestion(rs.getString("question"));
				judge.setAnswer(rs.getInt("answer"));
				judge.setFlag(rs.getInt("flag"));
			}
			//使用过的题目标志后面不在使用
			if(!setFlag(id)){
				throw new Exception();
			}
		} catch (SQLException e) {
			LogUtil.Error("JudgeDAO中获取题目失败 "+e.getMessage());
			JOptionPane.showMessageDialog(null,"检查数据库连接","提示",JOptionPane.PLAIN_MESSAGE);
//			e.printStackTrace();
		} catch (Exception e) {
			LogUtil.Error("JudgeDAO中修改Flag不成功 "+e.getMessage());
			JOptionPane.showMessageDialog(null,"检查数据库连接","提示",JOptionPane.PLAIN_MESSAGE);
//			e.printStackTrace();
		}finally{
			setFlag(id);
			DBUtil.closeConnection(conn);
		}
		return judge;
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
		String sql="UPDATE judge SET flag=1 WHERE id=?";
		try {
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			int t=ps.executeUpdate();
			if(t>0){
				b=true;
			}
		} catch (SQLException e) {
			LogUtil.Error("JudgeDAO中修改Flag失败 "+e.getMessage());
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
		String sql="UPDATE judge SET flag=0";
		try {
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			int t=ps.executeUpdate();
			if(t>0){
				b=true;
			}
		} catch (SQLException e) {
			LogUtil.Error("JudgeDAO中重置Flag失败 "+e.getMessage());
			JOptionPane.showMessageDialog(null,"检查数据库连接","提示",JOptionPane.PLAIN_MESSAGE);
//			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return b;
	}
	public static boolean addQuestion(String question,int answer){
		boolean b=false;
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="INSERT INTO judge (question,answer,flag) VALUES (?,?,0);";
		try {
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, question);
			ps.setInt(2, answer);
			int t=ps.executeUpdate();
			if(t>0){
				b=true;
			}
		} catch (Exception e) {
			LogUtil.Error("Judge中添加题目失败 "+e.getMessage());
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
		String sql="SELECT COUNT(*) count FROM judge;";
		try {
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				count=rs.getInt("count");
			}
		} catch (SQLException e) {
			LogUtil.Error("JudgeDAO中查询count失败 "+e.getMessage());
			JOptionPane.showMessageDialog(null,"检查数据库连接","提示",JOptionPane.PLAIN_MESSAGE);
//			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return count;
	}
}
