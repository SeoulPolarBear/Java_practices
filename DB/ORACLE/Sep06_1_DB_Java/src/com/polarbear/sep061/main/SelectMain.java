package com.polarbear.sep061.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectMain {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String addr = "jdbc:oracle:thin:@203.252.32.74:1521:xe";
			con = DriverManager.getConnection(addr,"babypolarbear","78910");
//			System.out.println("Success !");
			
			//��ǰ �̸��� ������������ �����ؼ� ��ǰ ��ü ���� ��ȸ
			String sql = "select * from sep05_product "
					+"order by p_name";
			
			pstmt = con.prepareStatement(sql);
			
			// pstmt.executeUpdate() : �� ���� ������ �޾Ҵ°�(C, U, D)
			// pstmt.executeQuery() : ������ (R)
			
			// select���� ������ ��� : ResultSet
			//		List�� ����� ����
			
			rs = pstmt.executeQuery();
			//rs.next() : ���� �����ͷ� �Ѿ, xml����...!
			//				���� �����Ͱ� ������ true,
			//				���� �����Ͱ� ������ false�� ����
			while(rs.next()) {
				//rs.getxxx("�÷���") : ���� ��ġ�� �÷� �б� (xxx : �ڷ���)
				//rs.getxxx(�ε���) : ����
				System.out.println(rs.getString(2));
				System.out.println(rs.getInt("p_weight"));
				System.out.println(rs.getInt("p_price"));
				System.out.println("===============================");
			}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();	//close ���� �� ��Ű��!
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try {
			pstmt.close();
		} catch (SQLException e1) {
			// TODO: handle exception
			e1.printStackTrace();
		}
		
		try {
			con.close();
		} catch (SQLException e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}
}
