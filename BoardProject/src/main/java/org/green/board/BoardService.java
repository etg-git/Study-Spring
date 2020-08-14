package org.green.board;

import java.sql.Connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
	
	@Autowired
	private MySqlDAO dao;
	
	public int writeBoard(BoardInfo info,  String id) {
		Connection con = dao.connect();
		int result = dao.boardInsert(con, info, id);
		dao.disconnect(con);
		
		return result;
	}
	
	public BoardInfo[] getAll(String sqlId) {
		Connection con = dao.connect();
		BoardInfo[] list = dao.boardGetAll(con, sqlId);
		dao.disconnect(con);
		return list;
	}
	
	public BoardInfo boardSearch(int id, String sqlId) {
		Connection con = dao.connect();
		BoardInfo info = dao.boardSearch(con, id, sqlId);
		dao.disconnect(con);
		return info;
	}
	
	public int boardUpdate(BoardInfo info, String id) {
		Connection con = dao.connect();
		int result = dao.boardUpdate(con, info, id);
		dao.disconnect(con);
		return result;
	}
	
	public int boardDelete(int id, String sqlId) {
		Connection con = dao.connect();
		int result = dao.boardDelete(con, id, sqlId);
		dao.disconnect(con);
		return result;
	}
}
