package com.polarbear.sep261.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.polarbear.sep261.dbc.meatDAO;

@WebServlet("/MeatPageController")
public class MeatPageController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!request.getParameterNames().hasMoreElements()) {
			meatDAO.getMeatdao().getMeats(1, request);
			System.out.println("약간 성공");
		} else {
			int p = Integer.parseInt(request.getParameter("pageCount"));
			meatDAO.getMeatdao().getMeats(p, request);
			System.out.println("완전 성공");
		}
			request.setAttribute("contentPage", "meat.jsp");
			request.getRequestDispatcher("View/index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
