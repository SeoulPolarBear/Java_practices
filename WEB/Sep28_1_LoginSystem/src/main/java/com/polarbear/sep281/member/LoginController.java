package com.polarbear.sep281.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO.login(request, response);
		//1. �α��ο� �����ϸ� -> loginSuccess.jsp
		//2. �α��� ���н� -> index.jsp
		if(MemberDAO.loginCheck(request)) {
			request.getRequestDispatcher("View/loginSuccess.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("View/index.jsp").forward(request, response);
		}
	}

}
