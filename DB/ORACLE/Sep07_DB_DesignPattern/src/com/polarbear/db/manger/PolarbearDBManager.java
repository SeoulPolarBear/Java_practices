package com.polarbear.db.manger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PolarbearDBManager {
	public static Connection connect() throws SQLException{
		String addr = "jdbc:oracle:thin:@203.252.32.74:1521:xe";
		return DriverManager.getConnection(addr, "babypolarbear","78910");
	}
	
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			rs.close();						//C,U,D때는 필요 없고, R 때만 사용
		} catch (Exception e) {			//insert하게 되면 NullPointerException이 발생 가능 하므로
			// TODO: handle exception	//모든 exception이 잡히도록 할 것
			//e.printStackTrace();		//메시지 안 보려고 
		}
		try {
			pstmt.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
