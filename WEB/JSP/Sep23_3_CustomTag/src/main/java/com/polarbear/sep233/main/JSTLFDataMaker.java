package com.polarbear.sep233.main;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class JSTLFDataMaker {
	public static void make(HttpServletRequest req) {
		int a = 123456789;
		req.setAttribute("a", a);
		double b = 10 / 24.0;
		req.setAttribute("b", b);
		double c = 123.43577;
		req.setAttribute("c", c);
		Date now = new Date();
		req.setAttribute("d", now);
			
	}
}
