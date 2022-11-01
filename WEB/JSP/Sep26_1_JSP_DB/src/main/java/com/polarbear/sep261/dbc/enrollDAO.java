package com.polarbear.sep261.dbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import com.polarbear.db.manager.PolarBearDBManager;

public class enrollDAO {
	private static final enrollDAO enroll = new enrollDAO();

	private enrollDAO() {
		// TODO Auto-generated constructor stub
	}

	public static enrollDAO getEnroll() {
		return enroll;
	}
	
	public void enrolldao(HttpServletRequest request) {
	
	Connection con = null;
	PreparedStatement pstmt = null;
	String result ="등록 실패";
	try {
		request.setCharacterEncoding("EUC-KR");	
		String m_kind = (String) request.getParameter("m_kind");
		String m_from = (String) request.getParameter("m_from");
		Long m_price = Long.parseLong(request.getParameter("m_price"));
		String m_introduce = (String) request.getParameter("m_introduce");
		con = PolarBearDBManager.connect("polarbearPool");
		String sql = "insert into sep26_meat values(sep26_meat_seq.nextval,?,?,?,?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, m_kind);
		pstmt.setString(2, m_from);
		pstmt.setLong(3, m_price);
		pstmt.setString(4, m_introduce);
		
		if(pstmt.executeUpdate()==1) {
			result = "등록 성공";
			meatDAO.getMeatdao().setAllMeatCount(meatDAO.getMeatdao().getAllMeatCount() + 1);
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	PolarBearDBManager.close(con, pstmt, null);
	request.setAttribute("result", result);
	}
	
}
