package org.green.board;

import java.sql.Connection;

public interface MyIDAO {
	Connection connect();
	JoinInfo joinSearch(Connection con, String id, String password);
	int joinInsert(Connection con, JoinInfo info);
	
	int createBoard(Connection con, String id);
	
	BoardInfo boardSearch(Connection con, int id, String sqlId);
	int boardInsert(Connection con, BoardInfo info, String sqlId);
	int boardUpdate(Connection con, BoardInfo info, String sqlId);
	BoardInfo[] boardGetAll(Connection con, String sqlId);
	int boardDelete(Connection con, int id, String sqlId);
	
	
	void disconnect(Connection con);
}
