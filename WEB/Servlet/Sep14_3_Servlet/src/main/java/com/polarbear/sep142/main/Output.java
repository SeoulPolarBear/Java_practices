package com.polarbear.sep142.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Output")
public class Output extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("EUC-KR");
		ArrayList<String> hobby = new ArrayList<>();
		//배열은 getParameterValues 사용
		for (String str : request.getParameterValues("hobby")) {
			hobby.add(str);
		}
		//마지막에 받은게 기타 및 기타 입력일 경우
		
		Data data = new Data(
				request.getParameter("Id"),
				request.getParameter("passwd"),
				request.getParameter("gender"),
				request.getParameter("location"),
				hobby,
				request.getParameter("introduce"));
		
		response.setCharacterEncoding("EUC-KR");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>인적사항</title><meta charset='EUC-KR'></head>");
		out.print("<body>");		
		out.printf("<h1>ID : %s</h1><br>", data.getId());
		out.printf("<h1>PW : %s</h1><br>", data.getPW());
		out.printf("<h1>성별 : %s</h1><br>", data.getGender());
		out.printf("<h1>지역 : %s</h1><br>", data.getLocation());
		out.printf("<h1>취미 : ");
		for (String str : hobby) {
			if(str.equals("기타")) {
				continue;
			}
			out.printf("%s ", str);
		}
		out.print("</h1><br>");
		out.printf("<h1>자기소개 : %s</h1><br>", data.getIntroduce());
		out.print("</body>");
		out.print("</html>");
	}

}
