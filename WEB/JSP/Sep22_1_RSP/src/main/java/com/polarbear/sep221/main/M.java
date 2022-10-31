package com.polarbear.sep221.main;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class M {
	private  int trying;
	private int win;
	private int draw;
	private int lose;
	private static final M m = new M();
	
	//���� ���ϰ� ����
	private M() {
		// TODO Auto-generated constructor stub
	}
	// ������ getter�� ���� ����
	// ���������� �׳� setAttribute�� ���������� �ȴ�.
	public static M getM() {
		return m;
	}
	//�̱��游 ���� ��밡��
	public void Game(HttpServletRequest request) {
		int user = Integer.parseInt(request.getParameter("RSP"));
		Random rand = new Random();
		int attacker = rand.nextInt(3);
		//��, �� , ��
		String userStr = M2.transaction(user);
		String attackerStr = M2.transaction(attacker);
		String resultStr ="";
		// �̹���
		String userimg = user + ".PNG";
		String attackerimg = attacker + ".PNG";
		
		
		
		// 0 1 / 1 2 / 2 0 =>user - attacker = -1 or 2 �� ���� ��
		// 2 1 / 1 0 / 0 2 = > user - attacker = 1 or -2 �� ���� �̱�
		int result = user - attacker;
		
		if(result == -1 || result == 2) {
			resultStr = "�й�";
			lose++;
			trying += 1;
		}else if(result == 1 || result == -2) {
			resultStr="�¸�";
			win++;
			trying++;
		}else {
			resultStr="���º�";
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
