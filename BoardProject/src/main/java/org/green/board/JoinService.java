package org.green.board;

import java.sql.Connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JoinService {
	
	@Autowired
	private MySqlDAO dao;
	
	public int joinInsert(JoinInfo info) {
		Connection con = dao.connect();
		int result = dao.joinInsert(con, info);
		dao.disconnect(con);
		return result;
	}
	public JoinInfo joinSearch(String id, String pw) {
		Connection con = dao.connect();
		JoinInfo info = dao.joinSearch(con, id, pw);
		dao.disconnect(con);
		
		return info;
	}
	
	public int createBoard(String id) {
		Connection con = dao.connect();
		int result = dao.createBoard(con, id);
		dao.disconnect(con);
		
		return result;
	}
}
