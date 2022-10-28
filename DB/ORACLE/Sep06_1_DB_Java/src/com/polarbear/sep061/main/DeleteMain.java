package com.polarbear.sep061.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteMain {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		Scanner scan = new Scanner(System.in);
		try {
			String addr = "jdbc:oracle:thin:@203.252.32.74:1521:xe";
			con = DriverManager.getConnection(addr,"babypolarbear","78910");
			//��ǰ�� �Է� -> �Է��� ������ �����ϴ� ��ǰ���� ���� ����
			System.out.println("������ ��ǰ���� �Է��ϼ��� : ");
			String product = scan.next();
			
//			�� Ǯ��
//			String sql = "delete from sep05_product " 
//					+ "where p_name like '%" + product + "%'";
//			pstmt = con.prepareStatement(sql);
			

//			����� Ǯ��			
			String sql = "delete from sep05_product " 
					+ "where p_name like '%'||?||'%'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,product);	
			
//			������ : ����� �ڹ��� �����̱� ������... % ���� ! -> %?% -x !(format)
//			String sql = "delete from sep05_product " 
//			2. ������ ���� ���ڿ��� ||�� �ٿ�����Ѵ�.
//					+ "where p_name like '%?%'";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1,product);
			
			
			if(pstmt.executeUpdate() >= 1) {//delete�� ������ ������ �� ���� �����Ƿ�
				System.out.println("Success !");
			}else {
				System.out.println("�׷��� �����ϴ�.");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try {
			pstmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}








