package com.polarbear.sep261.dbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.http.HttpServletRequest;

import com.polarbear.db.manager.PolarBearDBManager;


public class meatDAO {
	private int allMeatCount;
	
	private static meatDAO meatdao = new meatDAO();
	
	private meatDAO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public int getAllMeatCount() {
		return allMeatCount;
	}



	public void setAllMeatCount(int allMeatCount) {
		this.allMeatCount = allMeatCount;
	}



	public static meatDAO getMeatdao() {
		return meatdao;
	}


	public static void getMeatDAO(HttpServletRequest request){
		String result = "";
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		ArrayList<meat> meatList= new ArrayList<>();
		
		try {
		request.setCharacterEncoding("EUC-KR");
		con = PolarBearDBManager.connect("polarbearPool");
		String sql = "select * from sep26_meat order by m_price";
		pstmt = con.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		
		// C / U / D : pstmt.executeUpdate()로 실행
		// => 데이터 몇 개 영향을 받았는지
		//	R : pstmt.excuteQuery()로 실행
		//		=> select결과를 ResultSet으로 보냄
		int count = 1;
		while(rs.next()) {
			meatList.add(new meat(rs.getInt("m_id"),
					count,
				rs.getString("m_kind"),
				rs.getString("m_from"),
				rs.getLong("m_price"),
				rs.getString("m_introduce")));   
			count++;
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("meatList", meatList);
		PolarBearDBManager.close(con, pstmt, rs);
	}
	
	//총 데이터가 몇개 인지 
	public void countMeats() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs =  null;
		
		try {
			con = PolarBearDBManager.connect("polarbearPool");
			String sql = "select count(*) from sep26_meat";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			//이렇게 한번 해주지 않으면 읽어 올 수 없다.
			rs.next();
			allMeatCount = rs.getInt("count(*)");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// DB에 데이터가 100개 있다 ? -> 해당 페이지 번호에 맞는 데이터만 가져오기
	public void getMeats(int pageNo, HttpServletRequest req) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs =  null;
		try {
			req.setCharacterEncoding("EUC-KR");
		//SQL 수행하는데 필요한 값 챙기기
		
		// allAppleCount : 전체 사과 데이터 수
		int meatPerPage = 4;//한 페이지당 보여줄 사과 데이터 수
		
		//페이지 개수 가져오기
		int pageCount = (int) Math.ceil(allMeatCount /(double) meatPerPage);
		req.setAttribute("pageCount", pageCount);
		//////////////////////////////////////////////////
		int start = (meatPerPage * (pageNo - 1)) + 1;
		int end = (pageNo == pageCount) ? allMeatCount : (start + meatPerPage - 1);
		
		con = PolarBearDBManager.connect("polarbearPool");
		String sql = "select * from("
				+"select rownum as rn, m_id, "
				+ "m_kind, m_from, m_price, "
				+ "m_introduce from"
				+ "(select * "
						+ "from sep26_meat "
						+ "order by m_price)"
						+ ")"
						+ "where rn >= ? and rn <= ?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, start);
		pstmt.setInt(2, end);
		
		rs = pstmt.executeQuery();
		
		ArrayList<meat> meats = new ArrayList<meat>();
		meat meatmeat = null;
		while(rs.next()) {
			meatmeat = new meat(rs.getInt("m_id"),
					rs.getInt("rn"),
					rs.getString("m_kind"),
					rs.getString("m_from"),
					rs.getLong("m_price"),
					rs.getString("m_introduce"));
			meats.add(meatmeat);
		}
		req.setAttribute("meats", meats);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		PolarBearDBManager.close(con, pstmt, rs);
	}
	
	//상세정보 가져오기(primary key)
	//제대로 데이터를 가져왔으면 : true
	//실패했으면 : false
	
	public boolean getMeatDetail(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			req.setCharacterEncoding("EUC-KR");
			con = PolarBearDBManager.connect("polarbearPool");
			int m_id = Integer.parseInt(req.getParameter("m_id"));
			String sql = "select * from sep26_meat where m_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, m_id);
			rs = pstmt.executeQuery();
			int count = 1;
			if(rs.next()) {
				meat meatmeat = new meat(rs.getInt("m_id"),
						count,
						rs.getString("m_kind"),
						rs.getString("m_from"),
						rs.getLong("m_price"),
						rs.getString("m_introduce"));
				req.setAttribute("meatmeat", meatmeat);
				System.out.println("성공");
				return true;
			}
			return false;//다른 사람이 그 데이터를 지웠으면 : 데이터 없음
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;//DB서버 상태가 안 좋음(ex : 서버가 안 켜짐)
		} finally {
			PolarBearDBManager.close(con, pstmt, rs);
		}
	}
	
	//상세 정보에서 수정
	public boolean MeatDetailUpdate(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			req.setCharacterEncoding("EUC-KR");
			con = PolarBearDBManager.connect("polarbearPool");
			int m_id = Integer.parseInt((req.getParameter("m_id")));
			String m_kind = (String)(req.getParameter("m_kind"));
			String m_from = (String)(req.getParameter("m_from"));
			long m_price = Long.parseLong((req.getParameter("m_price")));
			String m_introduce = (String)(req.getParameter("m_introduce"));
			String sql = "update sep26_meat set m_kind=?, "
					+ "m_from=?,"
					+ "m_price=?,"
					+ "m_introduce=? "
					+ "where m_id= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m_kind);
			pstmt.setString(2, m_from);
			pstmt.setLong(3, m_price);
			pstmt.setString(4, m_introduce);
			pstmt.setInt(5, m_id);
			
			if(pstmt.executeUpdate() == 1) {
				System.out.println("수정 성공");
				return true;
			}else {
				System.out.println("수정 실패");
				return false;
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			PolarBearDBManager.close(con, pstmt, null);
		}
	}
	
	
	//상세 정보에서 삭제
	public void MeatDetailDelete(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String result = "";
		try {
			req.setCharacterEncoding("EUC-KR");
			con = PolarBearDBManager.connect("polarbearPool");
			int m_id = Integer.parseInt((req.getParameter("m_id")));
			String sql = "delete from sep26_meat"
					+ " where m_id= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, m_id);
			
			if(pstmt.executeUpdate() == 1) {
				result ="삭제 성공";
				System.out.println(result);
				allMeatCount--;
			}else {
				result ="삭제 실패";
				System.out.println(result);
			}
		
		} catch (Exception e) {
			result ="삭제 실패";
			e.printStackTrace();
			
		} finally {
			req.setAttribute("result", result);
			PolarBearDBManager.close(con, pstmt, null);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
