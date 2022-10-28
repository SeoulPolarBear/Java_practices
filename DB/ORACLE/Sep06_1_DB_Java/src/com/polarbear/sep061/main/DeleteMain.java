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
			//상품명 입력 -> 입력한 내용을 포함하는 상품명의 정보 삭제
			System.out.println("삭제할 상품명을 입력하세요 : ");
			String product = scan.next();
			
//			내 풀이
//			String sql = "delete from sep05_product " 
//					+ "where p_name like '%" + product + "%'";
//			pstmt = con.prepareStatement(sql);
			

//			강사님 풀이			
			String sql = "delete from sep05_product " 
					+ "where p_name like '%'||?||'%'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,product);	
			
//			문제점 : 여기는 자바의 영역이기 때문에... % 주의 ! -> %?% -x !(format)
//			String sql = "delete from sep05_product " 
//			2. 다음과 같이 문자열은 ||로 붙여줘야한다.
//					+ "where p_name like '%?%'";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1,product);
			
			
			if(pstmt.executeUpdate() >= 1) {//delete로 여러개 삭제가 될 수도 있으므로
				System.out.println("Success !");
			}else {
				System.out.println("그런거 없습니다.");
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








