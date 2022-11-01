package com.polarbear.sep261.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.polarbear.sep261.dbc.enrollDAO;
import com.polarbear.sep261.dbc.meatDAO;

@WebServlet("/enrollController")
public class enrollController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("contentPage", "enroll.jsp");
		request.getRequestDispatcher("View/index.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DB등록
		enrollDAO.getEnroll().enrolldao(request);
		// 게시판에 나올 데이터 가지고
		meatDAO.getMeatdao().getMeats(1, request);
		//등록 후에 보여줄 페이지 이동
		request.setAttribute("contentPage", "meat.jsp");
		request.getRequestDispatcher("View/index.jsp").forward(request, response);
	}

}
