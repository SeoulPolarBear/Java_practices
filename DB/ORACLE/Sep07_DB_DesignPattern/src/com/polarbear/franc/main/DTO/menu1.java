package com.polarbear.franc.main.DTO;

import com.polarbear.franc.main.ConsoleScreen;

	public class menu1 extends menuChange{
		
		public menu1() {
			super();
		}
		@Override
		//1. �����ϱ�(���� �Է�, ��¥�� ��-��-��/��:��) �� ���� ���� ���� print
		public void click() throws Exception {
			// TODO Auto-generated method stub
			rsv = ConsoleScreen.showRsvMenu();
			result = dao.book(rsv);
			ConsoleScreen.printResult(result);
		}
	}

