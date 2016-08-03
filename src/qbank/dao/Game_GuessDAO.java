package qbank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import qbank.util.DBUtil;
import qbank.util.LogUtil;
import qbank.vo.Game_Guess;

public class Game_GuessDAO {
	/**
	 * 获取判断题目
	 * @param id
	 * @return
	 */
	public static Game_Guess getGuess(int id){
		Game_Guess guess=null;
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="SELECT adj,noun,flag "
				+ "FROM game_guess WHERE id=?";
		try {
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			guess=new Game_Guess();
			while(rs.next()){
				guess.setAdj(rs.getString("adj"));
				guess.setNoun(rs.getString("noun"));
				guess.setFlag(rs.getInt("flag"));
			}
			//使用过的题目标志后面不在使用
			if(!setFlag(id)){
				throw new Exception();
			}
		} catch (SQLException e) {
			LogUtil.Error("game_guessDAO中获取题目失败 "+e.getMessage());
			JOptionPane.showMessageDialog(null,"检查数据库连接","提示",JOptionPane.PLAIN_MESSAGE);
//			e.printStackTrace();
		} catch (Exception e) {
			LogUtil.Error("game_guessDAO中修改Flag不成功 "+e.getMessage());
			JOptionPane.showMessageDialog(null,"检查数据库连接","提示",JOptionPane.PLAIN_MESSAGE);
//			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return guess;
	}
	public static Game_Guess getGuessUN(int id){
		Game_Guess guess=null;
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="SELECT adj,noun,flag "
				+ "FROM game_guess WHERE id=?";
		try {
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			guess=new Game_Guess();
			while(rs.next()){
				guess.setAdj(rs.getString("adj"));
				guess.setNoun(rs.getString("noun"));
				guess.setFlag(rs.getInt("flag"));
			}
		} catch (SQLException e) {
			LogUtil.Error("game_guessDAO中获取题目失败 "+e.getMessage());
			JOptionPane.showMessageDialog(null,"检查数据库连接","提示",JOptionPane.PLAIN_MESSAGE);
//			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return guess;
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
		String sql="UPDATE game_guess SET flag=1 WHERE id=?";
		try {
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			int t=ps.executeUpdate();
			if(t>0){
				b=true;
			}
		} catch (SQLException e) {
			LogUtil.Error("game_guessDAO中修改Flag失败 "+e.getMessage());
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
		String sql="UPDATE game_guess SET flag=0";
		try {
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			int t=ps.executeUpdate();
			if(t>0){
				b=true;
			}
		} catch (SQLException e) {
			LogUtil.Error("game_guessDAO中重置Flag失败 "+e.getMessage());
			JOptionPane.showMessageDialog(null,"检查数据库连接","提示",JOptionPane.PLAIN_MESSAGE);
//			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return b;
	}
	public static boolean addGuess(String adj,String noun){
		boolean b=false;
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="INSERT INTO game_guess (adj,noun,flag) VALUES (?,?,0);";
		try {
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, adj);
			ps.setString(2, noun);
			int t=ps.executeUpdate();
			if(t>0){
				b=true;
			}
		} catch (Exception e) {
			LogUtil.Error("game_guessDAO中添加题目失败 "+e.getMessage());
			JOptionPane.showMessageDialog(null,"检查数据库连接","提示",JOptionPane.PLAIN_MESSAGE);
//			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return b;
	}
	/**
	 * 获取题库数量
	 * @return
	 */
	public static int getCount(){
		int count=0;
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="SELECT COUNT(*) count FROM game_guess;";
		try {
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				count=rs.getInt("count");
			}
		} catch (SQLException e) {
			LogUtil.Error("Game_GuessDAO中查询count失败 "+e.getMessage());
			JOptionPane.showMessageDialog(null,"检查数据库连接","提示",JOptionPane.PLAIN_MESSAGE);
//			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return count;
	}
	/**
	 * 一次性从数据库中取出全部题目，待使用，降低访问数据库频率及次数
	 * @return
	 */
	public static List<Game_Guess> getGuessBase(){
		List<Game_Guess> guess_base=new ArrayList<Game_Guess>();
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="SELECT * FROM game_guess";
		try {
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				guess_base.add(new Game_Guess(rs.getString("adj"),rs.getString("noun")));
			}
		} catch (SQLException e) {
			LogUtil.Error("从Guess中取出题库集合出错 "+e.getMessage());
			JOptionPane.showMessageDialog(null,"检查数据库连接","提示",JOptionPane.PLAIN_MESSAGE);
//			e.printStackTrace();
		}
		
		return guess_base;
	}
}
