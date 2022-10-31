package com.polarbear.sep214.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class C
 */
@WebServlet("/C")
public class C extends HttpServlet {
	//� ����Ʈ�� ù ���� : GET ���
	//���� V1.html���� ��ư�� ������ �� GET����� ��� �Ѵٸ�?
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��û�Ķ���͸��� ������ -> �� ����Ʈ ù ���� GET���
		if(!request.getParameterNames().hasMoreElements()) {
			
			//ó������ ��û parameter�� ���� ������ ó�� �� �� ���
			request.getRequestDispatcher("HTML/V1.html").forward(request, response);
		}else {
			//��û�Ķ���͸��� ������ -> ����Ʈ�� ���Ȱ���� GET ���!
			M.multiply(request);
			request.getRequestDispatcher("JSP/V2.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		M.multiply(request);
		request.getRequestDispatcher("JSP/V2.jsp").forward(request, response);
	}

}
