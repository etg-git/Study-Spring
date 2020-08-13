package org.green.join_admin;

import java.sql.Connection;

public interface MyIDAO {
	Connection connect();
	JoinInfo search(Connection con, int id);
	JoinInfo[] getAll(Connection con);
	int insert(Connection con, JoinInfo info);
	int delete(Connection con, int id);
	int update(Connection con, JoinInfo info);
	void disconnect(Connection con);
}
