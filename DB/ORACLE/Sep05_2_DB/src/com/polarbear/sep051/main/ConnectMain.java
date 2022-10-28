package com.polarbear.sep051.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// ���� : cmd ��� sqlplus��� ���α׷����� OracleDB����
//			cmd��� ����
// ����ǰ : orange, toad, eclipse, dbeaver, sqldeveloper, ...

// Socket ���
// HTTP ���

// DB������ ��� : Java�� ����Ǿ� ���� (�̿ϼ� ����)
//		DB ����Ŀ�� ���� ������ ... -> ����Ŀ ���� ����� ���ݾ� �޶�
//		������ DB�� ���缭 ���ݾ� ��ġ�� �����!

// OracleDB ����� ! -> ���⿡ ���缭 ��ġ�� �ؾ� !
//		=> �� ����� ojdbc8.jar�� �� ����
//			-> ����Ŭ���� �ٿ�޾Ҵ� instant client �ȿ� ����. 
//			-> ������Ʈ ��Ŭ�� -> �����н� -> ���̺귯�� �� -> �ֵ� �ͽ��ͳ� �� 

//		ojdbc8.jar �ֱ⸸ �ϸ� �˾Ƽ� ����� �� ����

public class ConnectMain {
	public static void main(String[] args) {
		Connection con = null; // db ������ ������ �� �ִ� ��ü��.
		try {
			// ������ DB���� �ּ� ( ����Ŀ���� ������ �ٸ��� ! )
			// Data Source Explorer - ���� �̸��ʿ� ������ ���콺 ��ư Ŭ��
			//	- Properties - Driver Properties - Connection URL ���� ����.
			
			String addr = "jdbc:oracle:thin:@203.252.32.74:1521:xe";
			con = DriverManager.getConnection(addr,"babypolarbear","78910");
					// ù ��° �Ķ����, �ּ� ������ �޾ƿ� ��.
					// �� ��° �Ķ����, oracle id (���� �̸� ��Ŭ���ϸ� ����)
					// �� ��° �Ķ����, oracle pw
			System.out.println("Success !"); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			// ���� : ���������� �ݵ�� �ݾ���� ��. close ö���� �ؾ� ��
			// ���� �ȴ����� �ٸ� ����� �����...!
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
}
