package com.polarbear.sep281.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberDAO {
	//�������� �������� �ٴҰǵ�... => �α����� �Ǿ��ִ��� Ȯ���� �Ǿ�߰���!
	public static boolean loginCheck(HttpServletRequest req) {
		//�α����� �Ǿ��ִ� ���¸� Session���� ������ �� �ִ�.
		Member m = (Member) req.getSession().getAttribute("m");
		// �α����� �������̰ų� �α��ο� ������ ������ 11������ ���� ��!
		
		return (m != null);
	}

//�α��� ���
	public static void login(HttpServletRequest req , HttpServletResponse res) {
		try {
			req.setCharacterEncoding("EUC-KR");
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			
			//�α��� ������ ���� ����
			//			����Ʈ ��𼭵��� ��� ����
			//			���� �ð��� ������ �α��� ���� Ǯ���� 
			//			session�Ҽ��� attribute or cookie
			//			cookie�� ������
			
			if(id.equals("����") && pw.equals("me")) {
				Member m = new Member(id, pw);
				req.getSession().setAttribute("m", m);
				req.getSession().setMaxInactiveInterval(10);
			}
			
			//�ѹ� �α��ο� ����������, ������ �� ����Ʈ�� ������ ��
			// <input>�� id�� �����־�����...
			//������ ���, ������� �ص� �����ִ� ��... => cookie!
			
			Cookie c = new Cookie("lastLoginId", id);
			c.setMaxAge(20);
			res.addCookie(c);
		}catch(Exception e) {
			
		}
	}
}
