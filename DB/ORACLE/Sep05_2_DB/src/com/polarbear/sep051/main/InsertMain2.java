package com.polarbear.sep051.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertMain2 {
	public static void main(String[] args) {
		Connection con = null; // ���� ��ü ���� ����,
		PreparedStatement pstmt = null; // �Ѱ� �Ŵ��� �� �Ŀ� ������.
		Scanner k = new Scanner(System.in);

		try {
			String addr = "jdbc:oracle:thin:@203.252.32.74:1521:xe";
			con = DriverManager.getConnection(addr, "babypolarbear", "78910");

			// ������ �Ǹ� �Է¹ޱ�(Scanner=
			System.out.print("��Ʈ �̸� : ");
			String name = k.next();
			System.out.print("������ : ");
			String location = k.next();
			System.out.print("�� �� : ");
			int land = k.nextInt();
			System.out.print("���� ���� ��� : ");
			int parking = k.nextInt();

			// SQL
			// Java ������ �ִ� �� �� �ڸ��� '?'��
			String sql = "insert into sep05_market values (sep05_market_seq.nextval, " + "?, ?, ?, ?)";

			pstmt = con.prepareStatement(sql);
			// ?�� �� ä��� : pstmt.setXXX(����ǥ��ȣ, ��)
			// XXX : �ڷ���, ����ǥ��ȣ�� 1���� ���� !
			
			// sql ������ ù��°(1) ����ǥ�� String�� name�� ���� �־�� !
			pstmt.setString(1, name);
			pstmt.setString(2, location);
			pstmt.setInt(3, land);
			pstmt.setInt(4, parking);
			
			
			// ����/����/����ޱ�
			// �� �۾� ������ ������ ���� �������� ���� ����
//			int dataCount = pstmt.executeUpdate();
//			if (dataCount == 1) {
//				System.out.println("Success !");
//			}
			
			if (pstmt.executeUpdate() == 1) {
				//Ŭ������ �ϳ� �ۿ� update ��� ����
				//sql�� PreparedStatement�� 1:1 ��ġ �ۿ� �ȵǹǷ�
				//select���� �������� ������ �� ������
				//update������ �ᱹ 0,1�ۿ� ��� ���� �ʴ´�.
				//�ᱹ ���� ���� Ȥ�� ���и� ��Ÿ���� ���ؼ� ���
				//�׷��� �̸� �����ϱ� ���ؼ� executebatch�� ����ؼ� 
				//batch�� ��Ƴ��ٰ� �ѹ��� �����ϴ� ����� �����Ѵ�.
				System.out.print("Success !");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		// �ݴ� ���� ���� ! ( con.close()���� ���� �ݱ� ! )
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
