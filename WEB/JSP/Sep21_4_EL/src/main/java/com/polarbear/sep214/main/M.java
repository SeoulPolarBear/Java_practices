package com.polarbear.sep214.main;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class M {
	public static void multiply(HttpServletRequest request) {
		double x = Double.parseDouble(request.getParameter("x"));
		double y = Double.parseDouble(request.getParameter("y"));
		
		double z = x * y;
		
		request.setAttribute("z", z);
		
		Polarbear pb = new Polarbear("¹é°õ", 27, 180.0,100.0);
		request.setAttribute("b", pb);
		
		ArrayList<Polarbear> pbvs = new ArrayList<Polarbear>();
		pbvs.add(pb);
		pbvs.add(new Polarbear("¹é°õ", 27, 186.0,140.0));
		pbvs.add(new Polarbear("Èæ°õ", 23, 182.0,110.0));
		pbvs.add(new Polarbear("ÆÇ´Ù°õ", 22, 181.0,120.0));
		pbvs.add(new Polarbear("·¡¼­ÆÇ´Ù°õ", 25, 180.0,120.0));
		pbvs.add(new Polarbear("»ª°õ", 21, 184.0,90.0));
		request.setAttribute("pbvs", pbvs);
		
	}
}
