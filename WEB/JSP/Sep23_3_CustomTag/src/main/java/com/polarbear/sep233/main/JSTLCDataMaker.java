package com.polarbear.sep233.main;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class JSTLCDataMaker {
	public static void make(HttpServletRequest req) {
		int[] ar = {123,456,789, 91, 234};
		req.setAttribute("ar", ar);
		
		ArrayList<polarbear> al = new ArrayList<polarbear>();
		
		al.add(new polarbear("���", 4, 180, 104));
		al.add(new polarbear("���", 2, 200, 102));
		al.add(new polarbear("�Ұ�", 6, 190, 100.1));
		al.add(new polarbear("����", 3, 210, 100.5));
		req.setAttribute("al", al);
	}
}
