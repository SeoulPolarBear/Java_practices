package com.polarbear.sep281.Member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.polarbear.sep281.main.DataManager;

@WebServlet("/loginController")
public class loginController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	MemberDAO.logout(request);
	MemberDAO.loginCheck(request);
	request.setAttribute("contentPage", "home.jsp");
	request.getRequestDispatcher("View/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO.loginCheck(request);	
		MemberDAO.login(request, response);
			request.setAttribute("contentPage", "home.jsp");
		request.getRequestDispatcher("View/index.jsp").forward(request, response);
	}

}
