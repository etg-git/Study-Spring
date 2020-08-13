package org.green.join_admin;

import java.sql.Connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JoinService {
	
	@Autowired
	private MyIDAO myDao;
	
	public JoinInfo[] getAll() {
		Connection con = myDao.connect();
		JoinInfo[] list = myDao.getAll(con);
		myDao.disconnect(con);
		return list;
	}
	
	public int insert(JoinInfo info) {
		Connection con = myDao.connect();
		int result = myDao.insert(con, info);
		myDao.disconnect(con);
		
		return result;
	}
	
	public int update(JoinInfo info) {
		Connection con = myDao.connect();
		int result = myDao.update(con, info);
		myDao.disconnect(con);
		
		return result;
	}
	
	public int delete(JoinInfo info) {
		Connection con = myDao.connect();
		int result = myDao.delete(con, info);
		myDao.disconnect(con);
		
		return result;
	}
	
	public JoinInfo[] search(int id) {
		Connection con = myDao.connect();
		JoinInfo[] info = myDao.search(con, id);
		myDao.disconnect(con);
		
		return info;
	}
}
