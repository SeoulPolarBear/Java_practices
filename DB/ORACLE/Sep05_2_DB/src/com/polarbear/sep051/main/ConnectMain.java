package com.polarbear.sep051.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// 원래 : cmd 기반 sqlplus라는 프로그램으로 OracleDB제어
//			cmd기반 불편
// 사제품 : orange, toad, eclipse, dbeaver, sqldeveloper, ...

// Socket 통신
// HTTP 통신

// DB서버와 통신 : Java에 내장되어 있음 (미완성 상태)
//		DB 메이커가 많기 때문에 ... -> 메이커 별로 통신이 조금씩 달라서
//		연결할 DB에 맞춰서 조금씩 터치를 해줘야!

// OracleDB 사용중 ! -> 여기에 맞춰서 터치를 해야 !
//		=> 그 기능은 ojdbc8.jar에 다 있음
//			-> 오라클에서 다운받았던 instant client 안에 있음. 
//			-> 프로젝트 우클릭 -> 빌드패스 -> 라이브러리 탭 -> 애드 익스터널 자 

//		ojdbc8.jar 넣기만 하면 알아서 사용할 수 있음

public class ConnectMain {
	public static void main(String[] args) {
		Connection con = null; // db 서버에 연결할 수 있는 객체임.
		try {
			// 연결할 DB서버 주소 ( 메이커별로 형식이 다르다 ! )
			// Data Source Explorer - 서버 이름쪽에 오른쪽 마우스 버튼 클릭
			//	- Properties - Driver Properties - Connection URL 값을 복사.
			
			String addr = "jdbc:oracle:thin:@203.252.32.74:1521:xe";
			con = DriverManager.getConnection(addr,"babypolarbear","78910");
					// 첫 번째 파라미터, 주소 눌러서 받아온 것.
					// 두 번째 파라미터, oracle id (서버 이름 우클릭하면 나옴)
					// 세 번째 파라미터, oracle pw
			System.out.println("Success !"); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			// 주의 : 연결했으면 반드시 닫아줘야 함. close 철저히 해야 함
			// 내가 안닫으면 다른 사람이 못써요...!
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
}
