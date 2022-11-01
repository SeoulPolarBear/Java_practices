package com.polarbear.sep233.main;

import javax.servlet.http.HttpServletRequest;

public class Calcuator {
	public static void calculate(HttpServletRequest request) {
		int x = Integer.parseInt(request.getParameter("num1"));
		int y = Integer.parseInt(request.getParameter("num2"));
		
		int add = x + y;
		int minus = x - y;
		int multiply = x * y;
		double divide = x / (double)y;
		
		request.setAttribute("x", x);
		request.setAttribute("y", y);
		request.setAttribute("a", add);
		request.setAttribute("m1", minus);
		request.setAttribute("m2", multiply);
		request.setAttribute("d", divide);
	}
}
