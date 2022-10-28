package com.polarbear.sep051.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertMain2 {
	public static void main(String[] args) {
		Connection con = null; // 연결 객체 먼저 열고,
		PreparedStatement pstmt = null; // 총괄 매니저 그 후에 열었다.
		Scanner k = new Scanner(System.in);

		try {
			String addr = "jdbc:oracle:thin:@203.252.32.74:1521:xe";
			con = DriverManager.getConnection(addr, "babypolarbear", "78910");

			// 연결이 되면 입력받기(Scanner=
			System.out.print("마트 이름 : ");
			String name = k.next();
			System.out.print("지점명 : ");
			String location = k.next();
			System.out.print("몇 평 : ");
			int land = k.nextInt();
			System.out.print("주차 가능 대수 : ");
			int parking = k.nextInt();

			// SQL
			// Java 변수에 있는 값 들어갈 자리에 '?'로
			String sql = "insert into sep05_market values (sep05_market_seq.nextval, " + "?, ?, ?, ?)";

			pstmt = con.prepareStatement(sql);
			// ?에 값 채우기 : pstmt.setXXX(물음표번호, 값)
			// XXX : 자료형, 물음표번호는 1부터 시작 !
			
			// sql 변수의 첫번째(1) 물음표는 String인 name의 값을 넣어라 !
			pstmt.setString(1, name);
			pstmt.setString(2, location);
			pstmt.setInt(3, land);
			pstmt.setInt(4, parking);
			
			
			// 전송/실행/결과받기
			// 이 작업 때문에 영향을 받은 데이터의 수가 리턴
//			int dataCount = pstmt.executeUpdate();
//			if (dataCount == 1) {
//				System.out.println("Success !");
//			}
			
			if (pstmt.executeUpdate() == 1) {
				//클래스당 하나 밖에 update 사용 못함
				//sql과 PreparedStatement는 1:1 매치 밖에 안되므로
				//select으로 여러개를 가져올 수 있지만
				//update에서는 결국 0,1밖에 사용 하지 않는다.
				//결국 접속 성공 혹은 실패를 나타내기 위해서 사용
				//그래서 이를 보완하기 위해서 executebatch를 사용해서 
				//batch에 모아놨다가 한번에 전송하는 방법이 존재한다.
				System.out.print("Success !");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		// 닫는 순서 주의 ! ( con.close()보다 먼저 닫기 ! )
		try {
			pstmt.close();
		} catch (SQLException e) {
			// TODO: handle exception
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
