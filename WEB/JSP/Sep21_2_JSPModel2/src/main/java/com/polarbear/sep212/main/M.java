package com.polarbear.sep212.main;

import javax.servlet.http.HttpServletRequest;

//Model : �Ϲ� JAVA CLASS
//���� ����(���, DB, ...)

//back-end������ B
//��, �������� ���� ���� servlet���� �� class�� method�� ����ؼ� 
//�̶� HttpServletRequest request ��ü�� ��� x,y,z,... ������ ���δ�.
//���� ���ο� ��û�� ������ ���ο� ��ü�� �����ϹǷ� ���� �� �� �ٽ� �״´�.
public class M {
	public static void add(HttpServletRequest request) {
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		int z = x + y;
		request.setAttribute("z", z);
	}
}
