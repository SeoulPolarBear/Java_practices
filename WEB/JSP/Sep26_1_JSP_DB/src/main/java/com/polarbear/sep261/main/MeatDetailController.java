package com.polarbear.sep261.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.polarbear.sep261.dbc.meatDAO;

@WebServlet("/MeatDetailController")
public class MeatDetailController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	if(meatDAO.getMeatdao().getMeatDetail(request)) {
		request.setAttribute("contentPage", "detail.jsp");
	}else {
		meatDAO.getMeatdao().getMeats(1, request);
		request.setAttribute("contentPage", "meat.jsp");
	}
	request.getRequestDispatcher("View/index.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(meatDAO.getMeatdao().MeatDetailUpdate(request)) {
			request.setAttribute("result", "수정 성공");
		}else {
			request.setAttribute("result", "수정 실패");
		}
			meatDAO.getMeatdao().getMeats(1, request);
			System.out.println("약간 성공");
	
		request.setAttribute("contentPage", "meat.jsp");
		request.getRequestDispatcher("View/index.jsp").forward(request, response);
	
	}
}
