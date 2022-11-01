package com.polarbear.sep261.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.polarbear.sep261.dbc.meatDAO;

@WebServlet("/MeatDeleteController")
public class MeatDeleteController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	meatDAO.getMeatdao().MeatDetailDelete(request);
		meatDAO.getMeatdao().getMeats(1, request);
	request.setAttribute("contentPage", "meat.jsp");
	request.getRequestDispatcher("View/index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
