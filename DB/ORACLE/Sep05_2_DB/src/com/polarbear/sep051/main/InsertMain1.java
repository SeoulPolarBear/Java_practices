package com.polarbear.sep051.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertMain1 {
	public static void main(String[] args) {
		// SQL���� ����ؼ�
		//	-> DB ������ ����
		//	-> DB �������� �����ؼ�
		//	-> �� ����� �޾ƿ� �� �־�� !
		Connection con = null;// ������ ���̽��� ������ �� �ִ� ��ü ����
		try {
			String addr = "jdbc:oracle:thin:@203.252.32.74:1521:xe";
			con = DriverManager.getConnection(addr,"babypolarbear","78910");
			// ������ �� 2���� !!!
			String sql = "insert into sep05_product " // ���� ���� !!! (�ϳ� �־�� ��.) 
														// �ڵ尡 'productvalues' �� �Ǿ����.
							+ "values (sep05_product_seq.nextval,'������','1500','12000',3)";
									// ��ȣ �ڿ� �����ݷ� ���� ! [ );" ] ��� �ȵ�.
//			System.out.println("Success !");
			// ������ ����/����/��� �޾ƿ��� �۾��� �ϴ� �Ѱ� �Ŵ���
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.executeUpdate();// ������ ����/����/����ޱ�
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
			
		try {
			con.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}










