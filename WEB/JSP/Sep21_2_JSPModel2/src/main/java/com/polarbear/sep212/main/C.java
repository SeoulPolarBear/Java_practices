package com.polarbear.sep212.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// Controller : Servlet
//		상황판단해서 M/V 소환
//			-> 어떤 요청이 들어왔을 때, 판단해서 M/V를 소환
//		이 사이트의 진입점 (실행은 여기서 !!!)

//		 Back-end 웹 개발자 A - PL급 (Project Leader)


@WebServlet("/C")
public class C extends HttpServlet {
	//어떤 사이트에 접속
	// 1. 주소를 직접 입력
	// 2. 검색 -> <a> 눌러서
	//		위 두 방식 다 GET방식 요청(어떤 사이트에 POST로 첫 접속 - X)
	//
	
	//JSP와 HTML 차이 JSP는 request로 받은 값들을 처리 할 수 있다.
	//하지만 JSP는 불가능 하므로 JSP를 주로 사용하게 된다.
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("HTML/V1.html").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		M.add(request);
		request.getRequestDispatcher("JSP/V2.jsp").forward(request,response);
		
	}

}
