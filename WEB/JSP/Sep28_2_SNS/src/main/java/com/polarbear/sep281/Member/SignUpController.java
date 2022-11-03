package com.polarbear.sep281.Member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.polarbear.sep281.main.DataManager;


@WebServlet("/SignUpController")
public class SignUpController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDAO.loginCheck(request);
		DataManager.getCurYear(request);
		System.out.println("회원가입");
		request.setAttribute("contentPage", "signUp.jsp");
		request.getRequestDispatcher("View/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO.loginCheck(request);
		MemberDAO.signUp(request);
		System.out.println("회원가입");
	request.setAttribute("contentPage", "home.jsp");
	request.getRequestDispatcher("View/index.jsp").forward(request, response);
	}

}
