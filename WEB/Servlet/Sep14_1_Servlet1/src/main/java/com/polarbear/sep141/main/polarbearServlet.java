package com.polarbear.sep141.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/polarbearServlet")
public class polarbearServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//GET방식 요청(기본) 받는 방법
	//주소를 알고 있으면 직접 타이핑해서 접속 O
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//랜선에 붙어 있는 응답용 빨대(printWriter)
		//response.getWriter().append("Served at: ").append(request.getContextPath());
//		PrintWriter out = response.getWriter();
//		out.print("<html>");
//		out.print("<head><title>Hello!</title><meta charset='EUC-KR'></head>");
//		out.print("<body>");
//		out.print("<html>");
//		for (int i = 0; i < 5; i++) {
//			out.print("<marquee>Hello!</marquee>");
//		}
//		out.print("</body>");
//		out.print("</html>");
		
//		실행했을 때... 주소창 요청파라미터 lang의 값으로
		//korean을 입력하면 '네'
		//english를 입력하면 'yes'
		//그 외에는 '몰라'
		
		//클라이언트에게 서버측이 어떤 방식으로 인코딩을 했는지 알려줘야!!(항상!)
		response.setCharacterEncoding("EUC-KR");
		
		// ? 변수명=값&변수명=값&...
		String language = request.getParameter("lang");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>Hello!</title><meta charset=\"EUC-KR\"></head>");
		out.print("<body>");
		out.print("<h1>");
		if(language.equals("korean")) {
			out.print("네!");
		}
		else if(language.equals("english")) {
			out.print("yes");
		}else {
			out.print("몰라");
			System.out.print(language);
		}
		out.print("</h1>");
		out.print("</body>");
		out.print("</html>");
	}

	//POST방식 요청 받으면
	//프로그램을 통해서만 가능(계정의 비밀번호같이 주소값에 숨기고 싶은 것들...)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
