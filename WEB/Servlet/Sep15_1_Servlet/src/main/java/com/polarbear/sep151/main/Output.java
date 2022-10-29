package com.polarbear.sep151.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/Output")
public class Output extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		
		//String title = request.getParameter("title");
		
		//���� ���ε带 �غ���!
		
		//������ ���ε� �� �������� ������ ���� ���
		String path = request.getServletContext().getRealPath("img");
		System.out.println(path);// ���� ����� ��ġ
		
		//���� ���ε� 
		//(�̸� ���ؼ� input���� ���� multipartRequest �� ������ ���ؼ� �� ���� ������ ����� �ִ�. ��, ���ڵ� ����ؼ� ���)
		MultipartRequest mr = new MultipartRequest(
				request, 
				path,
				//���ε�� ����� ������ �ִ� ũ��(byte)
				1024 * 1024 * 1024,
				// ��û �Ķ���� ���ڵ� ���
				"EUC-KR",
				//����ڰ� ���ε��� ���ϸ� �ߺ��� �� ó��
				// �ߺ��� ���ϸ� �ڿ� ���ڸ� ���̰� �ϴ� ���
				new DefaultFileRenamePolicy()
				);
		String title = mr.getParameter("title");
		String fileName = mr.getFilesystemName("photo");
		// DB�� ���ϸ� ������ �� -> �뷮�� ����� ���� �ְ� ������!
		// f_name varchar2(200 char)
		
		// �� ������ : ��Ĺ�� �ѱ۷� �� ���ϸ� �ν� ���� 
		//	��.png -> %2A.png(URL ���ڵ��̸� �ν� O)
		fileName = URLEncoder.encode(fileName, "EUC-KR");
		
		String fileName2 = mr.getFilesystemName("etc");
		fileName2 = URLEncoder.encode(fileName2, "EUC-KR");
		fileName = fileName.replace("+", " ");//+�ν� �߸� �� �� ����
		fileName2 = fileName2.replace("+", " ");//+�ν� �߸� �� �� ����
		
		response.setCharacterEncoding("EUC-KR");
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>���� ���ε�</title><meta charset='EUC-KR'></head>");
		out.print("<body>");
		
		out.printf("<h1>%s</h1>", title);		
		out.printf("<h1>%s</h1>", fileName);			
		out.printf("<img width = '100px' height = '100px' src='img/%s'>", fileName);// ��� ��� ����	
		out.printf("<a href='img/%s'>�̹��� �ٿ�<br>", fileName);// ��� ��� ����
		//out.printf("<video width = '1000px' height = '1000px' controls = 'controls' src='img/%s'>", fileName);// ��� ��� ����	
		
		out.printf("<h1>%s</h1>", fileName2);				
		out.printf("<img width = '100px' height = '100px' src='img/%s'>", fileName2);// ��� ��� ����	
		
		out.printf("<a href='img/%s'>�̹��� �ٿ�<br>", fileName2);// ��� ��� ����		
		
		out.print("</body>");
		out.print("</html>");
		
	}

}
