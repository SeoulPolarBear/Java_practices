package com.polarbear.sep222.main.model;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class M {
	Random rand = new Random();

	private int first;
	private int second;
	private int third;
	private int userNum;
	private ArrayList<Integer> userNumList = new ArrayList<>();
	private ArrayList<String> userResult = new ArrayList<>();
	private int counter;
	private String res;

	private final static M m = new M();

	private M() {
		Random rand = new Random();
		this.first = rand.nextInt(10);
		
		/*
		 * public static String pickAns() { 
		 * int a = rand.nextInt(976) + 12; String
		 * attack = String.format("%03d", a);
		 * 
		 * if(attack.charAt(0) == ans.charAt(1) || 
		 * attack.charAt(0) == ans.charAt(1)||
		 * attack.charAt(0) == ans.charAt(1)) { 
		 * return pickAns(); 
		 * } 
		 * return ans; }
		 */
		
		while (true) {
			this.second = rand.nextInt(10);
			if (second != first)
				break;
		}
		while (true) {
			this.third = rand.nextInt(10);
			if (third != second && third != first)
				break;
		}
	}

	public static M getM() {
		return m;
	}

	public void computer(HttpServletRequest request) {
		userNum =  Integer.parseInt(request.getParameter("userNum")); 
		userNumList.add(userNum);
		int hundred = userNum / 100;
		int ten = (userNum % 100) / 10;
		int one = userNum % 10;
		counter++;

		int[] result = { 0, 0 };
		
		if (first == hundred)
			result[0]++;
		else if (first == ten)
			result[1]++;
		else if (first == one)
			result[1]++;

		if (second == hundred)
			result[1]++;
		else if (second == ten)
			result[0]++;
		else if (second == one)
			result[1]++;

		if (third == hundred)
			result[1]++;
		else if (third == ten)
			result[1]++;
		else if (third == one)
			result[0]++;

		// 스트라이크 3개시
		res = result[0] + " 스트라이크&nbsp&nbsp&nbsp" + result[1] + " 볼";
		if (result[0] == 3)
			res = "정답입니다!";

		userResult.add(res);
		
		request.setAttribute("userNumList", userNumList);
		request.setAttribute("userResult", userResult);
		request.setAttribute("result", res);
		request.setAttribute("counter", counter);

	}

}
