package com.polarbear.sep142.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Calculator")
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Calculator() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("EUC-KR");

		double num1 = Double.parseDouble(request.getParameter("num1"));
		double num2 = Double.parseDouble(request.getParameter("num2"));
		PrintWriter out = response.getWriter();
		String[] cal = { "+", "-", "*", "÷" };
		out.print("<html>");
		out.print("<head><title>사칙연산</title><meta charset='EUC-KR'></head>");
		out.print("<body>");		
		out.print("<table border = '1'>");	
		out.print("<tr>");
		out.print("<th colspan = '2' style='background-color: orange;'>");
		out.print(num1 + "와 " + num2 + "의 사칙연산");
		out.print("</th>");
		out.print("</tr>");
		for (int i = 0; i < cal.length; i++) {
			out.print("<tr>");
				out.print("<th width = '100px' style='background-color: #87CEEB;'>");
				out.print(cal[i]);
				out.print("</th>");
				
				out.print("<td width = '300px' style='text-align: center; "
						+ "background-color: pink;'>");
				out.printf("%.3f %s %.3f = ", num1, cal[i], num2);
				switch (cal[i]) {
				case "+":
					out.printf("%.3f",num1 + num2);
					break;
				
				case "-":
					out.printf("%.3f",num1 - num2);
					break;
					
				case "*":
					out.printf("%.3f", num1 * num2);
					break;
					
				case "÷":
					out.printf("%.3f", num1 / num2);
					break;

				default:
					out.print("다시 입력");
					break;
				}
				out.print("</td>");
			out.print("</tr>");

		}
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
