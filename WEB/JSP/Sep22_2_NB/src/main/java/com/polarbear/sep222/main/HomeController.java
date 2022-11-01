package com.polarbear.sep222.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.polarbear.sep222.main.model.M;

//숫자야구
// 3자리 숫자, 중복 숫자 X
// 1.입력 하는 부분도 숫자아닌거 입력 못하게(값이 안넘어가게), 
// 2.중복 숫자 입력 다시 입력하게 하는 유효성 검사, 
// 3.무조건 3자리 숫자여야 하도록

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!request.getParameterNames().hasMoreElements()) {
			request.getRequestDispatcher("View/playBall.jsp").forward(request, response);
		} else {
			M.getM().computer(request);
			request.getRequestDispatcher("View/playBall.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
