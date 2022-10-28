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
			
			//상품 이름을 오름차순으로 정렬해서 상품 전체 정보 조회
			String sql = "select * from sep05_product "
					+"order by p_name";
			
			pstmt = con.prepareStatement(sql);
			
			// pstmt.executeUpdate() : 몇 개나 영향을 받았는가(C, U, D)
			// pstmt.executeQuery() : 데이터 (R)
			
			// select문을 수행한 결과 : ResultSet
			//		List와 비슷한 느낌
			
			rs = pstmt.executeQuery();
			//rs.next() : 다음 데이터로 넘어감, xml느낌...!
			//				다음 데이터가 있으면 true,
			//				다음 데이터가 없으면 false가 리턴
			while(rs.next()) {
				//rs.getxxx("컬럼명") : 현재 위치의 컬럼 읽기 (xxx : 자료형)
				//rs.getxxx(인덱스) : 비추
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
			rs.close();	//close 순서 잘 지키기!
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
