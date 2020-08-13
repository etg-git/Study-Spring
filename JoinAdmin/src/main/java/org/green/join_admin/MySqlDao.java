package org.green.join_admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

@Repository
public class MySqlDao implements MyIDAO{
	public MySqlDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Connection connect() {
		Connection con = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1234");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return con;
	}
	@Override
	public int update(Connection con, JoinInfo info) {
		int result = 0;
		
		PreparedStatement stmt = null;
		String sql = "UPDATE join_info SET name = ?, password = ?, nickName = ?, tel = ? WHERE id = ?";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, info.getName());
			stmt.setString(2, info.getPassword());
			stmt.setString(3, info.getNickName());
			stmt.setString(4, info.getTel());
			stmt.setInt(5, info.getId());
			
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		return result;
	}

	@Override
	public JoinInfo search(Connection con, int id) {
		JoinInfo info = null;
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = con.prepareStatement("SELECT * FROM join_info WHERE id = ?");
			stmt.setInt(1, id);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				int my_id = rs.getInt("id");
				String name = rs.getString("name");
				String password = rs.getString("password");
				String nickName = rs.getString("nickName");
				String tel = rs.getString("tel");
				
				info = new JoinInfo(my_id, name, password, nickName, tel);
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
	public JoinInfo[] getAll(Connection con) {
		JoinInfo[] list = null;
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = con.prepareStatement("SELECT * FROM join_info");
			rs = stmt.executeQuery();
			rs.last();
			int count = rs.getRow();
			rs.beforeFirst();
			
			list = new JoinInfo[count];
			int idx = 0;
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String password = rs.getString("password");
				String nickName = rs.getString("nickName");
				String tel = rs.getString("tel");
				
				list[idx] = new JoinInfo(id, name, password, nickName, tel);
				idx++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rs);
		}
		return list;
	}

	@Override
	public int insert(Connection con, JoinInfo info) {
		int result = 0;
		
		PreparedStatement stmt = null;
		String sql = "INSERT INTO join_info(name, password, nickName, tel) VALUES (?,?,?,?)";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, info.getName());
			stmt.setString(2, info.getPassword());
			stmt.setString(3, info.getNickName());
			stmt.setString(4, info.getTel());
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
				
		return result;
	}

	@Override
	public int delete(Connection con, int id) {
		int result = 0;
		
		PreparedStatement stmt = null;
		String sql = "DELETE FROM join_info WHERE id = ?";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
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
	private void close(PreparedStatement pStmt) {
		try {
			pStmt.close();
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
