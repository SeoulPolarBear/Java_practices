package com.polarbear.sep141.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/polarbearServlet")
public class polarbearServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//GET��� ��û(�⺻) �޴� ���
	//�ּҸ� �˰� ������ ���� Ÿ�����ؼ� ���� O
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������ �پ� �ִ� ����� ����(printWriter)
		//response.getWriter().append("Served at: ").append(request.getContextPath());
//		PrintWriter out = response.getWriter();
//		out.print("<html>");
//		out.print("<head><title>Hello!</title><meta charset='EUC-KR'></head>");
//		out.print("<body>");
//		out.print("<html>");
//		for (int i = 0; i < 5; i++) {
//			out.print("<marquee>Hello!</marquee>");
//		}
//		out.print("</body>");
//		out.print("</html>");
		
//		�������� ��... �ּ�â ��û�Ķ���� lang�� ������
		//korean�� �Է��ϸ� '��'
		//english�� �Է��ϸ� 'yes'
		//�� �ܿ��� '����'
		
		//Ŭ���̾�Ʈ���� �������� � ������� ���ڵ��� �ߴ��� �˷����!!(�׻�!)
		response.setCharacterEncoding("EUC-KR");
		
		// ? ������=��&������=��&...
		String language = request.getParameter("lang");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>Hello!</title><meta charset=\"EUC-KR\"></head>");
		out.print("<body>");
		out.print("<h1>");
		if(language.equals("korean")) {
			out.print("��!");
		}
		else if(language.equals("english")) {
			out.print("yes");
		}else {
			out.print("����");
			System.out.print(language);
		}
		out.print("</h1>");
		out.print("</body>");
		out.print("</html>");
	}

	//POST��� ��û ������
	//���α׷��� ���ؼ��� ����(������ ��й�ȣ���� �ּҰ��� ����� ���� �͵�...)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
