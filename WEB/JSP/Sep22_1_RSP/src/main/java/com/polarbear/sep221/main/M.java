package com.polarbear.sep221.main;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class M {
	private  int trying;
	private int win;
	private int draw;
	private int lose;
	private static final M m = new M();
	
	//접근 못하게 만듬
	private M() {
		// TODO Auto-generated constructor stub
	}
	// 나머지 getter가 없는 이유
	// 나머지들은 그냥 setAttribute로 보내버리면 된다.
	public static M getM() {
		return m;
	}
	//싱글톤만 때만 사용가능
	public void Game(HttpServletRequest request) {
		int user = Integer.parseInt(request.getParameter("RSP"));
		Random rand = new Random();
		int attacker = rand.nextInt(3);
		//승, 무 , 패
		String userStr = M2.transaction(user);
		String attackerStr = M2.transaction(attacker);
		String resultStr ="";
		// 이미지
		String userimg = user + ".PNG";
		String attackerimg = attacker + ".PNG";
		
		
		
		// 0 1 / 1 2 / 2 0 =>user - attacker = -1 or 2 일 때는 짐
		// 2 1 / 1 0 / 0 2 = > user - attacker = 1 or -2 일 때는 이김
		int result = user - attacker;
		
		if(result == -1 || result == 2) {
			resultStr = "패배";
			lose++;
			trying += 1;
		}else if(result == 1 || result == -2) {
			resultStr="승리";
			win++;
			trying++;
		}else {
			resultStr="무승부";
			draw++;
			trying++;
		}
		request.setAttribute("user", userStr);
		request.setAttribute("userimg", userimg);
		request.setAttribute("attacker", attackerStr);
		request.setAttribute("attackerimg", attackerimg);
		request.setAttribute("result", resultStr);
		request.setAttribute("trying", trying);
		request.setAttribute("lose", lose);
		request.setAttribute("draw", draw);
		request.setAttribute("win", win);
	}
	
	
}
