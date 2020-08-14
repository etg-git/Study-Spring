package org.green.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import org.springframework.stereotype.Repository;

@Repository
public class MySqlDAO implements MyIDAO {
	
	public MySqlDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public Connection connect() {
		Connection con = null;;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1234");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	@Override
	public int createBoard(Connection con, String id) {
		int result = 0;
		String createName = "board_info" + id;
		System.out.println(createName);
		String sql = "CREATE TABLE "+ createName + " (\r\n" + 
				"	b_id 			INT			PRIMARY KEY 		AUTO_INCREMENT,\r\n" + 
				"	b_title		CHAR(20)	NOT NULL,\r\n" + 
				"	b_content	CHAR(50)	NOT NULL,\r\n" + 
				"	b_date		CHAR(40) 	NOT NULL\r\n" + 
				")";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			result = stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public JoinInfo joinSearch(Connection con, String id, String password) {
		JoinInfo join = null;
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM join_info WHERE id = ? AND password = ?";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, password);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				String myid = rs.getString("id");
				String name = rs.getString("name");
				String mypassword = rs.getString("password");
				String nickName = rs.getString("nickName");
				
				join = new JoinInfo(myid, name, mypassword, nickName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}
		
		return join;
	}
	@Override
	public int joinInsert(Connection con, JoinInfo info) {
		int result = 0;
		PreparedStatement stmt = null;
		String sql = "INSERT INTO join_info (id, name, password, nickName) VALUES (?,?,?,?)";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, info.getId());
			stmt.setString(2, info.getName());
			stmt.setString(3, info.getPassword());
			stmt.setString(4, info.getNickName());
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		return result;
	}
	
	@Override
	public BoardInfo boardSearch(Connection con, int id, String sqlId) {
		BoardInfo info = null;
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM board_info"+ sqlId 
				+ " WHERE b_id = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if(rs.next()) {
				int myid = rs.getInt("b_id");
				String title = rs.getString("b_title");
				String content = rs.getString("b_content");
				String date = rs.getString("b_date");
				
				info = new BoardInfo(myid, title, content, date);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}
		return info;
	}
	@Override
	public BoardInfo[] boardGetAll(Connection con, String sqlId) {
		BoardInfo[] list = null;
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM board_info"+sqlId
				+ " ORDER BY b_id DESC";
		
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			Vector<BoardInfo> vec = new Vector<BoardInfo>();
			
			while(rs.next()) {
				int id = rs.getInt("b_id");
				String title = rs.getString("b_title");
				String content = rs.getString("b_content");
				String date = rs.getString("b_date");
				
				vec.add(new BoardInfo(id, title, content, date));
			}
			list = vec.toArray(new BoardInfo[0]);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}
		return list;
	}

	@Override
	public int boardInsert(Connection con, BoardInfo info, String sqlId) {
		int result = 0;
		
		PreparedStatement stmt = null;
		String sql = "INSERT INTO board_info" + sqlId
				+ " (b_title, b_content, b_date) VALUES (?,?,?)";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, info.getB_title());
			stmt.setString(2, info.getB_content());
			stmt.setString(3, info.getB_date());
			
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		return result;
	}
	@Override
	public int boardUpdate(Connection con, BoardInfo info, String sqlId) {
		int result = 0;
		
		PreparedStatement stmt = null;
		String sql = "UPDATE board_info" + sqlId
				+ " SET b_title = ?, b_content = ?, b_date = ? WHERE b_id = ?";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, info.getB_title());
			stmt.setString(2, info.getB_content());
			stmt.setString(3, info.getB_date());
			stmt.setInt(4, info.getB_id());
			
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		return result;
	}
	
	@Override
	public int boardDelete(Connection con, int id, String sqlId) {
		int result = 0;
		
		PreparedStatement stmt = null;
		String sql = "DELETE FROM board_info" + sqlId+ " WHERE b_id = ?";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			
			result = stmt.executeUpdate();
		} catch(SQLException e) {
			
		} finally {
			close(stmt);
		}
		return result;
	}
	@Override
	public void disconnect(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void close(PreparedStatement stmt) {
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
