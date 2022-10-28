package com.polarbear.sep061.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateMain {
	public static void main(String[] args) {
		//매장명 입력 -> 그 단어를 포함하는 모든 매장의 상품을 20% 할인된 가격으로 바꾸기!!
		Connection con = null;
		PreparedStatement pstmt = null;
		Scanner scan = new Scanner(System.in);
		try {
			String addr = "jdbc:oracle:thin:@203.252.32.74:1521:xe";
			con = DriverManager.getConnection(addr, "babypolarbear","78910");
			System.out.println("매장명 : ");
			String name = scan.next();
			String sql = "update sep05_product "
					+"set p_price = p_price * 0.8 "
						+ "where p_m_no in "
						+ "(select m_no "
						+ "from sep05_market "
						+ "where m_name "
						+ "like '%'||?||'%')"; 
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			
			if(pstmt.executeUpdate() >= 1) {
				System.out.println("success !");
			}else {
				System.out.println("not success !");
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
