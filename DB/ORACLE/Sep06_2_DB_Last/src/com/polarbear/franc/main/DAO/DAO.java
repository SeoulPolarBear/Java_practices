package com.polarbear.franc.main.DAO;
//DAO / DTO ����

//		MVC ����
//		DAO(DATA Access Object)
//			: M �߿��� db������ �۾��� �����ϴ� Ŭ����
//		DTO (Data transfer / temp Object)
//			:DAO�� �۾� ����� ǥ���ϴ� Ŭ����
//��, DB���� �۾��� ���⼭ ����
// java.util.Date - �ַ�(Spring������ �̰� ����)
// java.sql.Date - JDBC������ �̰� ����

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.polarbear.db.manger.PolarbearDBManager;
import com.polarbear.franc.reservation.Reservation;
import com.polarbear.franc.restaurant.Restaurant;

// java.util.Date -> java.sql.Date�� ����ؾ� �� �ٵ�
//		: new Date(Ŭ������.get��¥���ø��������()).getTime());

// java.sql.Date -> java.util.Date
//		: �˾Ƽ� �ٲ���

public class DAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// 0. db�� �����ϱ�
	public DAO() {
		try {
			this.con = PolarbearDBManager.connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 1. �����ϱ�(���� �Է�, ��¥�� ��-��-��/��:��)
	public String book(Reservation r) {
		try {
			String sql = "insert into sep06_book " + "values(sep06_book_seq.nextval,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, r.getName());
			pstmt.setDate(2, new Date(r.getWhen().getTime()));
			pstmt.setString(3, r.getPhone());
			pstmt.setString(4, r.getLocation());

			if (pstmt.executeUpdate() == 1) {
				return "���� ���� !";
			}
			return "";
		} catch (Exception e) {
			e.printStackTrace();
			return "���� ����";
		}
//		finally {
//			try {
//				PolarbearDBManager.close(con, pstmt, rs);
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//
//		}
	}

//2. ���� ���
	public String UpdateRestaurant(Restaurant res) throws SQLException {
		try {
			String sql = "insert into sep06_restaurant " + "values(?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, res.getLocation());
			pstmt.setString(2, res.getOwner());
			pstmt.setLong(3, res.getSeat());

			if (pstmt.executeUpdate() == 1) {
				return "���� ��� ���� !";
			}
			return "";
		} catch (Exception e) {
			e.printStackTrace();
			return "���� ��� ����";
		}
	}

//3. ��ü ���� Ȯ��(��¥�� ��-��-�� ���� ����/���� ��:��, ��ȣ ��� ��������)

	public ArrayList<Reservation> ReadAllBook() {
		ArrayList<Reservation> array = new ArrayList<>();
		String sql = "select * from sep06_book order by b_no";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Reservation res = null;
			while (rs.next()) {
				// DB�� �÷���
				res = new Reservation(rs.getInt("b_no"), rs.getString("b_name"), rs.getDate("b_time"),
						rs.getString("b_phone_number"), rs.getString("b_r_location"));
				array.add(res);
			}
			return array;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("�ν� ����");
			return array;
		}
	}

//4. ��ü ���� ��ȸ(��ġ(�¼���) - ����� �̸�)

	public ArrayList<Restaurant> ReadAllRestaurant() {
		ArrayList<Restaurant> array = new ArrayList<>();
		String sql = "select * from sep06_restaurant";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Restaurant res = null;
			while (rs.next()) {
				res = new Restaurant(rs.getString("r_location"), rs.getString("r_owner"), rs.getInt("r_seat"));
				array.add(res);
			}
			return array;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�ν� ����");
			return array;
		}
	}

//5. ���� ã�� (�ּ� �¼� �� �Է�=> �¼� �� �̻��� ������ ���� ���)

	public ArrayList<Restaurant> ReadRestaurantUpperSeat(int seat) {
		ArrayList<Restaurant> array = new ArrayList<>();
		String sql = "select * from sep06_restaurant " + "where r_seat>= ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, seat);
			rs = pstmt.executeQuery();
			Restaurant res = null;
			while (rs.next()) {
				res = new Restaurant(rs.getString("r_location"), rs.getString("r_owner"), rs.getInt("r_seat"));
				array.add(res);
			}
			return array;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�ν� ����");
			return array;
		}
	}

//6. ���� ã�� (������ �̸�)
	public ArrayList<Reservation> findBook(String name) {
		ArrayList<Reservation> array = new ArrayList<>();
		String sql = "select * from sep06_book " + "where b_name = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			Reservation res = null;
			while (rs.next()) {

				res = new Reservation(rs.getInt("b_no"), rs.getString("b_name"), rs.getDate("b_time"),
						rs.getString("b_phone_number"), rs.getString("b_r_location"));
				array.add(res);
			}
			return array;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("����");
			return array;
		}
	}

//7. ���� ���� ���� (���� ��ȣ�� �Է��ϸ� ����ó ����)
	public String changePhoneNumber(int bookNo, String phoneNo) {
		String sql = "update sep06_book set b_phone_number = ? " + "where b_no = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, phoneNo);
			pstmt.setInt(2, bookNo);
			if (pstmt.executeUpdate() == 1) {
				return "���� ���� ���� !";
			}
			return "";
		} catch (Exception e) {
			e.printStackTrace();
			return "���� ���� ����";
		}
	}

//8. ���� ��� (�����ȣ�� �Է��ϸ� ���)
	public String CancelBook(int bookNo) {
		String sql = "delete from sep06_book where b_no = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bookNo);

			if (pstmt.executeUpdate() == 1) {
				return "���� ��� ����";
			}
			return "";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "���� ��� ����";
		}
	}

//9. ����
	public void finish() {
		PolarbearDBManager.close(con, pstmt, rs);
	}
}
