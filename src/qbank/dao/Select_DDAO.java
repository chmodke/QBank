package qbank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;








import javax.swing.JOptionPane;

import qbank.util.DBUtil;
import qbank.util.LogUtil;
import qbank.vo.Select_D;

public class Select_DDAO {
	/**
	 * 获取题目
	 * @param id
	 * @return
	 */
	public static Select_D getQuestion(int id){
		Select_D sel=null;
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="SELECT question,answerA,answerB,answerC,answerD,answer,flag "
				+ "FROM d_select WHERE id=?";
		try {
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			sel=new Select_D();
			while(rs.next()){
				sel.setQuestion(rs.getString("question"));
				sel.setAnswerA(rs.getString("answerA"));
				sel.setAnswerB(rs.getString("answerB"));
				sel.setAnswerC(rs.getString("answerC"));
				sel.setAnswerD(rs.getString("answerD"));
				sel.setAnswer(rs.getString("answer"));
				sel.setFlag(rs.getInt("flag"));
			}
			//使用过的题目标志后面不在使用
			if(!setFlag(id)){
				throw new Exception();
			}
		} catch (SQLException e) {
			LogUtil.Error("D_SelectDDAO中获取题目失败 "+e.getMessage());
			JOptionPane.showMessageDialog(null,"检查数据库连接","提示",JOptionPane.PLAIN_MESSAGE);
//			e.printStackTrace();
			return null;
		} catch (Exception e) {
			LogUtil.Error("D_SelectDDAO中修改Flag不成功 "+e.getMessage());
//			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return sel;
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
		String sql="UPDATE d_select SET flag=1 WHERE id=?";
		try {
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			int t=ps.executeUpdate();
			if(t>0){
				b=true;
			}
		} catch (SQLException e) {
			LogUtil.Error("D_SelectDDAO中修改Flag失败 "+e.getMessage());
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
		String sql="UPDATE d_select SET flag=0";
		try {
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			int t=ps.executeUpdate();
			if(t>0){
				b=true;
			}
		} catch (SQLException e) {
			LogUtil.Error("D_SelectDDAO中重置Flag失败 "+e.getMessage());
			JOptionPane.showMessageDialog(null,"检查数据库连接","提示",JOptionPane.PLAIN_MESSAGE);
//			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return b;
	}
	public static boolean addQuestion(String question, String answerA, String answerB,
			String answerC, String answerD, String answer){
		boolean b=false;
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="INSERT INTO d_select (question,answerA,answerB,answerC,answerD,answer,flag) VALUES (?,?,?,?,?,?,0);";
		try {
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, question);
			ps.setString(2, answerA);
			ps.setString(3, answerB);
			ps.setString(4, answerC);
			ps.setString(5, answerD);
			ps.setString(6, answer);
			int t=ps.executeUpdate();
			if(t>0){
				b=true;
			}
		} catch (Exception e) {
			LogUtil.Error("D_SelectDDAO中添加题目失败 "+e.getMessage());
			JOptionPane.showMessageDialog(null,"检查数据库连接","提示",JOptionPane.PLAIN_MESSAGE);
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return b;
	}
	
	public static int getCount(){
		int count=0;
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="SELECT COUNT(*) count FROM d_select;";
		try {
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				count=rs.getInt("count");
			}
		} catch (SQLException e) {
			LogUtil.Error("D_SelectDDAO中查询count失败 "+e.getMessage());
			JOptionPane.showMessageDialog(null,"检查数据库连接","提示",JOptionPane.PLAIN_MESSAGE);
//			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return count;
	}
}
