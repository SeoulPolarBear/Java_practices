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
		
		//파일 업로드를 해보자!
		
		//파일이 업로드 될 서버상의 폴더의 절대 경로
		String path = request.getServletContext().getRealPath("img");
		System.out.println(path);// 절대 경로의 위치
		
		//파일 업로드 
		//(이를 통해서 input에서 보낸 multipartRequest 형 파일을 통해서 그 안의 값들을 사용할 있다. 즉, 인코딩 대신해서 사용)
		MultipartRequest mr = new MultipartRequest(
				request, 
				path,
				//업로드시 허용할 파일의 최대 크기(byte)
				1024 * 1024 * 1024,
				// 요청 파라미터 인코딩 방식
				"EUC-KR",
				//사용자가 업로드한 파일명 중복될 때 처리
				// 중복시 파일명 뒤에 숫자를 붙이게 하는 방식
				new DefaultFileRenamePolicy()
				);
		String title = mr.getParameter("title");
		String fileName = mr.getFilesystemName("photo");
		// DB에 파일명 저장할 때 -> 용량을 상당히 여유 있게 만들어야!
		// f_name varchar2(200 char)
		
		// 그 이유는 : 톰캣이 한글로 된 파일명 인식 못함 
		//	ㅋ.png -> %2A.png(URL 인코딩이면 인식 O)
		fileName = URLEncoder.encode(fileName, "EUC-KR");
		
		String fileName2 = mr.getFilesystemName("etc");
		fileName2 = URLEncoder.encode(fileName2, "EUC-KR");
		fileName = fileName.replace("+", " ");//+인식 잘못 할 수 있음
		fileName2 = fileName2.replace("+", " ");//+인식 잘못 할 수 있음
		
		response.setCharacterEncoding("EUC-KR");
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>파일 업로드</title><meta charset='EUC-KR'></head>");
		out.print("<body>");
		
		out.printf("<h1>%s</h1>", title);		
		out.printf("<h1>%s</h1>", fileName);			
		out.printf("<img width = '100px' height = '100px' src='img/%s'>", fileName);// 상대 경로 가능	
		out.printf("<a href='img/%s'>이미지 다운<br>", fileName);// 상대 경로 가능
		//out.printf("<video width = '1000px' height = '1000px' controls = 'controls' src='img/%s'>", fileName);// 상대 경로 가능	
		
		out.printf("<h1>%s</h1>", fileName2);				
		out.printf("<img width = '100px' height = '100px' src='img/%s'>", fileName2);// 상대 경로 가능	
		
		out.printf("<a href='img/%s'>이미지 다운<br>", fileName2);// 상대 경로 가능		
		
		out.print("</body>");
		out.print("</html>");
		
	}

}
