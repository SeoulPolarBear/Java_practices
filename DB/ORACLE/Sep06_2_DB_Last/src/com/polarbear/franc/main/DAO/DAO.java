package com.polarbear.franc.main.DAO;
//DAO / DTO 패턴

//		MVC 패턴
//		DAO(DATA Access Object)
//			: M 중에서 db관련한 작업을 전담하는 클래스
//		DTO (Data transfer / temp Object)
//			:DAO의 작업 결과를 표현하는 클래스
//즉, DB관련 작업을 여기서 수행
// java.util.Date - 주력(Spring에서는 이걸 원함)
// java.sql.Date - JDBC에서는 이걸 원함

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

// java.util.Date -> java.sql.Date로 사용해야 할 텐데
//		: new Date(클래스명.get날짜관련멤버변수명()).getTime());

// java.sql.Date -> java.util.Date
//		: 알아서 바꿔줌

public class DAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// 0. db랑 연결하기
	public DAO() {
		try {
			this.con = PolarbearDBManager.connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 1. 예약하기(직접 입력, 날짜는 연-월-일/시:분)
	public String book(Reservation r) {
		try {
			String sql = "insert into sep06_book " + "values(sep06_book_seq.nextval,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, r.getName());
			pstmt.setDate(2, new Date(r.getWhen().getTime()));
			pstmt.setString(3, r.getPhone());
			pstmt.setString(4, r.getLocation());

			if (pstmt.executeUpdate() == 1) {
				return "예약 성공 !";
			}
			return "";
		} catch (Exception e) {
			e.printStackTrace();
			return "예약 실패";
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

//2. 매장 등록
	public String UpdateRestaurant(Restaurant res) throws SQLException {
		try {
			String sql = "insert into sep06_restaurant " + "values(?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, res.getLocation());
			pstmt.setString(2, res.getOwner());
			pstmt.setLong(3, res.getSeat());

			if (pstmt.executeUpdate() == 1) {
				return "매장 등록 성공 !";
			}
			return "";
		} catch (Exception e) {
			e.printStackTrace();
			return "매장 등록 실패";
		}
	}

//3. 전체 예약 확인(날짜는 연-월-일 요일 오전/오후 시:분, 번호 대로 오름차순)

	public ArrayList<Reservation> ReadAllBook() {
		ArrayList<Reservation> array = new ArrayList<>();
		String sql = "select * from sep06_book order by b_no";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Reservation res = null;
			while (rs.next()) {
				// DB의 컬럼명
				res = new Reservation(rs.getInt("b_no"), rs.getString("b_name"), rs.getDate("b_time"),
						rs.getString("b_phone_number"), rs.getString("b_r_location"));
				array.add(res);
			}
			return array;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("인식 실패");
			return array;
		}
	}

//4. 전체 매장 조회(위치(좌석수) - 사장님 이름)

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
			System.out.println("인식 실패");
			return array;
		}
	}

//5. 매장 찾기 (최소 좌석 수 입력=> 좌석 수 이상의 매장의 정보 출력)

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
			System.out.println("인식 실패");
			return array;
		}
	}

//6. 예약 찾기 (예약자 이름)
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
			System.out.println("실패");
			return array;
		}
	}

//7. 예약 정보 수정 (예약 번호를 입력하면 연락처 변경)
	public String changePhoneNumber(int bookNo, String phoneNo) {
		String sql = "update sep06_book set b_phone_number = ? " + "where b_no = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, phoneNo);
			pstmt.setInt(2, bookNo);
			if (pstmt.executeUpdate() == 1) {
				return "예약 변경 성공 !";
			}
			return "";
		} catch (Exception e) {
			e.printStackTrace();
			return "예약 변경 실패";
		}
	}

//8. 예약 취소 (예약번호를 입력하면 취소)
	public String CancelBook(int bookNo) {
		String sql = "delete from sep06_book where b_no = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bookNo);

			if (pstmt.executeUpdate() == 1) {
				return "예약 취소 성공";
			}
			return "";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "예약 취소 실패";
		}
	}

//9. 종료
	public void finish() {
		PolarbearDBManager.close(con, pstmt, rs);
	}
}
