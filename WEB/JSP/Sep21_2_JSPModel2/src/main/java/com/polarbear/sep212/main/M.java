package com.polarbear.sep212.main;

import javax.servlet.http.HttpServletRequest;

//Model : 일반 JAVA CLASS
//실제 업무(계산, DB, ...)

//back-end개발자 B
//즉, 서블릿으로 값이 오면 servlet에서 이 class의 method를 사용해서 
//이때 HttpServletRequest request 객체에 계속 x,y,z,... 값들이 쌓인다.
//따라서 새로운 요청이 있으면 새로운 객체를 생성하므로 값을 그 때 다시 쌓는다.
public class M {
	public static void add(HttpServletRequest request) {
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		int z = x + y;
		request.setAttribute("z", z);
	}
}
