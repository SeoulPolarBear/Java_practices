package com.polarbear.sep051.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertMain1 {
	public static void main(String[] args) {
		// SQL문을 사용해서
		//	-> DB 서버로 전송
		//	-> DB 서버에서 실행해서
		//	-> 그 결과를 받아올 수 있어야 !
		Connection con = null;// 데이터 베이스에 연결할 수 있는 객체 생성
		try {
			String addr = "jdbc:oracle:thin:@203.252.32.74:1521:xe";
			con = DriverManager.getConnection(addr,"babypolarbear","78910");
			// 주의할 점 2가지 !!!
			String sql = "insert into sep05_product " // 띄어쓰기 주의 !!! (하나 넣어야 함.) 
														// 코드가 'productvalues' 가 되어버림.
							+ "values (sep05_product_seq.nextval,'옥수수','1500','12000',3)";
									// 괄호 뒤에 세미콜론 금지 ! [ );" ] 요거 안됨.
//			System.out.println("Success !");
			// 서버에 전송/실행/결과 받아오는 작업을 하는 총괄 매니저
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.executeUpdate();// 서버에 전송/실행/결과받기
		
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










