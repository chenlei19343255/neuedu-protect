package com.neusoft.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.neusoft.util.DButil;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DButil db=DButil.getInstance();
		Connection conn=null;
		try {
			 conn=db.getConnection();
			System.out.println(conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
