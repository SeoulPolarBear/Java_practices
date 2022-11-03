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

	// �ϴ� ���� ���ε� �õ�

	public static void signUp(HttpServletRequest req) {
		// �ϴ� ���� ���ε� �õ�
		// 10 * 1024 * 1024
		String path = null;
		MultipartRequest mr = null;
		try {
			path = req.getServletContext().getRealPath("View/CSS/img");

			mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "EUC-KR", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			req.setAttribute("r", "ȸ�� ���� ����(�������� �뷮)");
			return;// ���ε忡 �����ϸ� �ڿ� ���� DB�۾� ���� ���� (���� ����)
		}

		// ���� ���ε� �����ÿ� ��� ����

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
				req.setAttribute("r", "ȸ������ ����(DB����)");
			}

		} catch (Exception e) {// ID �ߺ�, DB ���� ���� ���� : p
			e.printStackTrace();
			// TODO: handle exception
			// DB�� ������ ������ ��������, ���� ������ ���ε�� �Ǿ��ִ� ����
			// ���� ���� �������(JAVA- ���ϸ� �ѱ�ó���� �ȵǾ� �־)
			File f = new File(path + "/" + mr.getFilesystemName("m_photo"));
			f.delete();
			req.setAttribute("r", "ȸ������ ����(DB����)");
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
				req.setAttribute("r", "�� �������� ����");
			}else {
				req.setAttribute("r", "�� �������� ����");
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
		//���� ���ε� ���н�(�뷮�ʰ��� ���ؼ�)
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
				//��� �����ؼ� + �����ֱ�
				new_m_photo = URLEncoder.encode(new_m_photo,"EUC-KR").replace("+", " ");
			}
			else {
				new_m_photo = old_m_photo;
			}
			
		} catch (Exception e) {
			//�뷮�ʰ��� �� �־��� ���
			// TODO: handle exception
			e.printStackTrace();
			System.err.println("���� �뷮 �ʰ�");
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
				req.setAttribute("r", "���� ����");
				//������ ������ �ٲ���� ���
				if(!new_m_photo.equals(old_m_photo)) {
					//���ǰ��� ����� ����. ���� ��ο� �ִ� ���� �����ϱ� ���� 
					//�� ���Ͽ� �����߰� old_m_photo��� ���� ������ �ִ� photo�� �����Ѵ�.
					new File(path + "/" + URLEncoder.encode(old_m_photo,"EUC-KR")).delete();// ���� ���� ���� ����
				}
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				m = new Member(m_id,m_passwd,m_name,m_num,m_date,m_photo);
				//session �������ش�.
				req.getSession().setAttribute("loginMember", m);
			}else {
				req.setAttribute("r", "���� ����");
				if(!new_m_photo.equals(old_m_photo)) {
					new File(path + "/" + URLDecoder.decode(new_m_photo, "EUC-KR")).delete();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			req.setAttribute("r", "���� ����");
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
				req.setAttribute("r", "Ż�𼺰�");
				// �� ȸ���� �� ��?
				// �� ����� �ø� ���ϵ�?
				// �� ����� ���� -> ������
			// ���� DB���� ������
			// session���� ������ �� ���� ��������(DeleteMemberController�� 16�� ��ġ ������)
			//	(18���ٿ��� session�� ���ư�)		
				
				String m_photo = m.getM_photo();
				m_photo=URLDecoder.decode(m_photo, "EUC-KR");
				String path = req.getServletContext().getRealPath("img");
				File f = new File(path + "/" + m_photo);
				f.delete();
			}else {
				req.setAttribute("r", "�̹� Ż���ϼ̽��ϴ�.");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			req.setAttribute("r", "Ż�� ����(DB����)");
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

			//String sql = "select * from sep28_member"; //��ȿ����
			// String sql = "select * from sep28_member where m_id = ? and m_passwd = ?";
			// //��ȿ����
			// ��ŷ ��� -SQL Injection
			// ���Ȼ� ������� �̿��ؼ� �����ͺ��̽��� ���������� ������ �ϰ� �ϴ� ���
			String sql = "select * from sep28_member where m_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //�����Ͱ� �ִ��� + �� �����͸� ����Ű��
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
					req.setAttribute("r", "�α��� ����");
				}else {
					req.setAttribute("r", "�α��� ����(PW����)");
				}
				
			}else {
				req.setAttribute("r", "�α��� ����(�̰��� ID)");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			req.setAttribute("r", "�α��� ����(DB����)");
		}
		PolarBearDBManager.close(con, pstmt, rs);
	}
	
	public static boolean loginCheck(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		if(m != null) {
			//�α��� ���� + ���� ������
			req.setAttribute("loginPage", "welcome.jsp");
			return true;
		}//�α��� ���°� �ƴϴ�.
		req.setAttribute("loginPage", "login.jsp");
		return false;
		}
	
	public static void logout(HttpServletRequest req) {
		//���� ���� : �ٸ� ���ǵ� ���ֱ� ������ ����
		//req.getSession().setMaxInactiveInterval(-1);
		
		// Member�� ���� session�� null�� �ٲ��ָ� �ȴ�.
		req.getSession().setAttribute("loginMember", null);
	}
	
	
	
	
	
	
	
}
