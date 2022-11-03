package com.polarbear.sep281.Member;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.polarbear.db.manager.PolarBearDBManager;

public class MemberDAO {

	// 일단 파일 업로드 시도

	public static void signUp(HttpServletRequest req) {
		// 일단 파일 업로드 시도
		// 10 * 1024 * 1024
		String path = null;
		MultipartRequest mr = null;
		try {
			path = req.getServletContext().getRealPath("View/CSS/img");

			mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "EUC-KR", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			req.setAttribute("r", "회원 가입 실패(사진파일 용량)");
			return;// 업로드에 실패하면 뒤에 남은 DB작업 하지 말자 (강제 종료)
		}

		// 파일 업로드 성공시에 계속 진행

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = PolarBearDBManager.connect("polarbearPool");
			String id = mr.getParameter("m_id");
			String pw = mr.getParameter("m_passwd");
			String name = mr.getParameter("m_name");
			int p1 = Integer.parseInt(mr.getParameter("m_phoneNum1"));
			int p2 = Integer.parseInt(mr.getParameter("m_phoneNum2"));
			int p3 = Integer.parseInt(mr.getParameter("m_phoneNum3"));
			int y = Integer.parseInt(mr.getParameter("m_y"));
			int m = Integer.parseInt(mr.getParameter("m_m"));
			int d = Integer.parseInt(mr.getParameter("m_d"));

			String m_num = String.format("%d-%d-%d", p1, p2, p3);

			String m_date = String.format("%d-%d-%d", y, m, d);

			String photo = mr.getFilesystemName("m_photo");
			photo = URLEncoder.encode(photo, "EUC-KR").replace("+", "-");

			String sql = "insert into sep28_member values(" + "?,?,?,?, to_date(?,'YYYY-MM-DD'), ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, m_num);
			pstmt.setString(5, m_date);
			pstmt.setString(6, photo);

			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("r", "회원가입 성공(DB서버)");
			}

		} catch (Exception e) {// ID 중복, DB 서버 연결 상태 : p
			e.printStackTrace();
			// TODO: handle exception
			// DB쪽 문제로 가입은 실패지만, 사진 파일이 업로드는 되어있는 상태
			// 사진 파일 지워줘야(JAVA- 파일명에 한글처리가 안되어 있어서)
			File f = new File(path + "/" + mr.getFilesystemName("m_photo"));
			f.delete();
			req.setAttribute("r", "회원가입 실패(DB서버)");
		}
		PolarBearDBManager.close(con, pstmt, null);
	}
	
	public static void memberGet(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String m_id = (String) req.getAttribute("m_id");
			con = PolarBearDBManager.connect("polarbearPool");
			String sql = "select * from sep28_member where m_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m_id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				req.setAttribute("r", "값 가져오기 성공");
			}else {
				req.setAttribute("r", "값 가져오기 실패");
			}
			
			Member m = new Member(
					rs.getString("m_id"),
					rs.getString("m_passwd"),
					rs.getString("m_name"),
					rs.getString("m_phoneNum"),
					rs.getString("m_birthday"),
					rs.getString("m_photo")
					);
			
			req.setAttribute("m", m);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		PolarBearDBManager.close(con, pstmt, rs);
	}
	
	public static void memberUpdate(HttpServletRequest req) {
		//파일 업로드 실패시(용량초과로 인해서)
		String path = null;
		MultipartRequest mr = null;
		Member m = (Member) req.getSession().getAttribute("loginMember");
		String old_m_photo = m.getM_photo();
		String new_m_photo = null;
		
		try {
			path = req.getServletContext().getRealPath("View/CSS/img");
			mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "EUC-KR", new DefaultFileRenamePolicy());
			
			new_m_photo = mr.getFilesystemName("m_photo");
			
			
			if(new_m_photo != null) {
				//경로 관련해서 + 없애주기
				new_m_photo = URLEncoder.encode(new_m_photo,"EUC-KR").replace("+", " ");
			}
			else {
				new_m_photo = old_m_photo;
			}
			
		} catch (Exception e) {
			//용량초과로 못 넣었을 경우
			// TODO: handle exception
			e.printStackTrace();
			System.err.println("파일 용량 초과");
			return;
		}
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			String m_id = mr.getParameter("m_id");
			String m_passwd = mr.getParameter("m_passwd");
			String m_name = mr.getParameter("m_name");
			String m_phoneNum1 = mr.getParameter("m_phoneNum1");
			String m_phoneNum2 = mr.getParameter("m_phoneNum2");
			String m_phoneNum3 = mr.getParameter("m_phoneNum3");
			String y = mr.getParameter("m_y");
			int m_m = Integer.parseInt(mr.getParameter("m_m"));
			int d = Integer.parseInt(mr.getParameter("m_d"));
			String m_photo = (String) req.getAttribute("m_id");
			
			String m_num = String.format("%s-%s-%s", m_phoneNum1, m_phoneNum2, m_phoneNum3);

			String m_date = String.format("%d-%d-%d", y, m_m, d);
			
			con = PolarBearDBManager.connect("polarbearPool");
			String sql = "update sep28_member set"
					+ "m_passwd = ?"
					+ "m_name = ?"
					+ "m_phoneNum = ?"
					+ "m_birthday = to_date(?,'YYYY-MM-DD')"
					+ "m_photo = ?"
					+ "where m_id = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, m_passwd);
			pstmt.setString(2, m_name);
			pstmt.setString(3, m_num);
			pstmt.setString(4, m_date);
			pstmt.setString(5, m_photo);
			pstmt.setString(6, m_id);
			
			if(pstmt.executeUpdate() == 1) {
				req.setAttribute("r", "수정 성공");
				//프로필 사진이 바뀌었을 경우
				if(!new_m_photo.equals(old_m_photo)) {
					//세션과는 상관이 없다. 절대 경로에 있는 값을 삭제하기 위해 
					//그 파일에 접근했고 old_m_photo라는 값을 가지고 있는 photo를 삭제한다.
					new File(path + "/" + URLEncoder.encode(old_m_photo,"EUC-KR")).delete();// 기존 사진 파일 삭제
				}
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				m = new Member(m_id,m_passwd,m_name,m_num,m_date,m_photo);
				//session 갱신해준다.
				req.getSession().setAttribute("loginMember", m);
			}else {
				req.setAttribute("r", "수정 실패");
				if(!new_m_photo.equals(old_m_photo)) {
					new File(path + "/" + URLDecoder.decode(new_m_photo, "EUC-KR")).delete();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			req.setAttribute("r", "수정 실패");
			if(!new_m_photo.equals(old_m_photo)) {
				try {
					new File(path + "/" + URLDecoder.decode(new_m_photo, "EUC-KR")).delete();
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		PolarBearDBManager.close(con, pstmt, null);
	}
	
	public static void MemberDelete(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = PolarBearDBManager.connect("polarbearPool");
			Member m = (Member) req.getSession().getAttribute("loginMember");
			String m_id = m.getM_id();
			
			String sql = "delete from sep26_member where m_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m_id);
			
			if(pstmt.executeUpdate() == 1) {
				req.setAttribute("r", "탈퇴성공");
				// 그 회원이 쓴 글?
				// 그 사람이 올린 파일들?
				// 그 사람의 프사 -> 지워야
			// 지금 DB에서 지웠음
			// session에는 여전히 그 정보 남아있음(DeleteMemberController의 16번 위치 진행중)
			//	(18번줄에서 session이 날아감)		
				
				String m_photo = m.getM_photo();
				m_photo=URLDecoder.decode(m_photo, "EUC-KR");
				String path = req.getServletContext().getRealPath("img");
				File f = new File(path + "/" + m_photo);
				f.delete();
			}else {
				req.setAttribute("r", "이미 탈퇴하셨습니다.");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			req.setAttribute("r", "탈퇴 실패(DB서버)");
		}
		PolarBearDBManager.close(con, pstmt, null);
	}
	

	public static void login(HttpServletRequest req, HttpServletResponse res) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = PolarBearDBManager.connect("polarbearPool");

			req.setCharacterEncoding("EUC-KR");
			String id = req.getParameter("m_id");
			String pw = req.getParameter("m_passwd");

			//String sql = "select * from sep28_member"; //비효율적
			// String sql = "select * from sep28_member where m_id = ? and m_passwd = ?";
			// //비효율적
			// 해킹 기법 -SQL Injection
			// 보안상 취약점을 이용해서 데이터베이스가 비정상적인 동작을 하게 하는 기법
			String sql = "select * from sep28_member where m_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //데이터가 있는지 + 그 데이터를 가리키게
				String dbPw = rs.getString("m_passwd");
				if(dbPw.equals(pw)) {
					Member m = new Member(
							rs.getString("m_id"),
							rs.getString("m_passwd"),
							rs.getString("m_name"),
							rs.getString("m_phoneNum"),
							rs.getString("m_birthday"),
							rs.getString("m_photo"));
					
					req.getSession().setAttribute("loginMember", m);
					req.getSession().setMaxInactiveInterval(600);
					
					Cookie c =new Cookie("lastLoginId", id);
					c.setMaxAge(60 * 60 * 24 * 5);
					res.addCookie(c);
					req.setAttribute("r", "로그인 성공");
				}else {
					req.setAttribute("r", "로그인 실패(PW오류)");
				}
				
			}else {
				req.setAttribute("r", "로그인 실패(미가입 ID)");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			req.setAttribute("r", "로그인 실패(DB서버)");
		}
		PolarBearDBManager.close(con, pstmt, rs);
	}
	
	public static boolean loginCheck(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		if(m != null) {
			//로그인 성공 + 상태 유지시
			req.setAttribute("loginPage", "welcome.jsp");
			return true;
		}//로그인 상태가 아니다.
		req.setAttribute("loginPage", "login.jsp");
		return false;
		}
	
	public static void logout(HttpServletRequest req) {
		//세션 끊기 : 다른 세션도 들어가있기 때문에 비추
		//req.getSession().setMaxInactiveInterval(-1);
		
		// Member에 대한 session만 null로 바꿔주면 된다.
		req.getSession().setAttribute("loginMember", null);
	}
	
	
	
	
	
	
	
}
