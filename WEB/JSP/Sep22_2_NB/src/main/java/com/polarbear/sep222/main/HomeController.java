package com.polarbear.sep222.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.polarbear.sep222.main.model.M;

//���ھ߱�
// 3�ڸ� ����, �ߺ� ���� X
// 1.�Է� �ϴ� �κе� ���ھƴѰ� �Է� ���ϰ�(���� �ȳѾ��), 
// 2.�ߺ� ���� �Է� �ٽ� �Է��ϰ� �ϴ� ��ȿ�� �˻�, 
// 3.������ 3�ڸ� ���ڿ��� �ϵ���

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
