package com.polarbear.sep221.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Java + JSP + CSS + Servlet
//가위바위보 페이지를 만들 것!
// 디자인은 알아서...
//Was 종료할 때까지 전적은 쌓이게 => 매판 진행할 때마다 전적 보이도록(바뀌도록)

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!request.getParameterNames().hasMoreElements()) {
			request.getRequestDispatcher("View/RSP.jsp").forward(request, response);
		}else {
			
			M.getM().Game(request);
			request.getRequestDispatcher("View/RSP.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
