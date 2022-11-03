package com.polarbear.sep281.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberDAO {
	//페이지를 여기저기 다닐건데... => 로그인이 되어있는지 확인이 되어야겠음!
	public static boolean loginCheck(HttpServletRequest req) {
		//로그인이 되어있는 상태면 Session값을 가져올 수 있다.
		Member m = (Member) req.getSession().getAttribute("m");
		// 로그인이 유지중이거나 로그인에 성공을 했으면 11번줄이 있을 것!
		
		return (m != null);
	}

//로그인 기능
	public static void login(HttpServletRequest req , HttpServletResponse res) {
		try {
			req.setCharacterEncoding("EUC-KR");
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			
			//로그인 성공한 유저 정보
			//			사이트 어디서든지 사용 가능
			//			일정 시간이 지나면 로그인 상태 풀리게 
			//			session소속의 attribute or cookie
			//			cookie는 위험함
			
			if(id.equals("헬프") && pw.equals("me")) {
				Member m = new Member(id, pw);
				req.getSession().setAttribute("m", m);
				req.getSession().setMaxInactiveInterval(10);
			}
			
			//한번 로그인에 성공했으면, 다음에 이 사이트에 들어왔을 때
			// <input>에 id가 남아있었으면...
			//접속을 끊어도, 재부팅을 해도 남아있는 것... => cookie!
			
			Cookie c = new Cookie("lastLoginId", id);
			c.setMaxAge(20);
			res.addCookie(c);
		}catch(Exception e) {
			
		}
	}
}
