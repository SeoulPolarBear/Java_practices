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
			rs.close();						//C,U,D���� �ʿ� ����, R ���� ���
		} catch (Exception e) {			//insert�ϰ� �Ǹ� NullPointerException�� �߻� ���� �ϹǷ�
			// TODO: handle exception	//��� exception�� �������� �� ��
			//e.printStackTrace();		//�޽��� �� ������ 
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
