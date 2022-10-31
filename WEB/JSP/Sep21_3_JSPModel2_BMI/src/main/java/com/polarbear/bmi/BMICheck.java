package com.polarbear.bmi;

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

@WebServlet("/BMICheck")
public class BMICheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String path = request.getServletContext().getRealPath("img");
		MultipartRequest mr = new MultipartRequest(
				request, 
				path, 
				1024 * 1024 * 1024, 
				"EUC-KR",
				new DefaultFileRenamePolicy()
				);
		String myName = mr.getParameter("myName");
		String myHeight = mr.getParameter("myHeight");
		String myWeight = mr.getParameter("myWeight");
		String fileName = mr.getFilesystemName("myPhoto");
		
		//몸무게 / 키 * 키 (m  단위)
		double weight = Double.parseDouble(myWeight);
		double height = Double.parseDouble(myHeight) / 100;
		
		double BMI = weight / Math.pow(height, 2);
		
		
		fileName = URLEncoder.encode(fileName, "EUC-KR");
		fileName.replace("+", " ");
		
		
		response.setCharacterEncoding("EUC-KR");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head><title>BMI</title><meta charset='EUC-KR'></head>");
		out.print("<body>");
		
		out.printf("<h1>%s</h1>", myName);
		out.printf("<h1>%s</h1>", myHeight);
		out.printf("<h1>%s</h1>", myWeight);
		out.printf("<img src = 'img/%s' width = '100px' height = '100px'>", fileName);
		if(BMI >= 25.00) {
			out.printf("<h1>BMI : %.2f으로 비만 입니다.</h1><br>",BMI);
		}
		else if(BMI >= 23.00) {
			out.printf("<h1>BMI : %.2f으로 과체중 입니다.</h1><br>",BMI);
		}
		else if(BMI >= 18.5) {
			out.printf("<h1>BMI : %.2f으로 정상 입니다.</h1><br>",BMI);
		}
		else if(BMI >= 0) {
			out.printf("<h1>BMI : %.2f으로 저체중 입니다.</h1><br>",BMI);
		}
		else{
			out.print("<h1>BMI 이상한데요?? 다시 해보세요</h1><br>");
		}
		
		out.print("</body>");
		out.print("</html>");
	}

}
