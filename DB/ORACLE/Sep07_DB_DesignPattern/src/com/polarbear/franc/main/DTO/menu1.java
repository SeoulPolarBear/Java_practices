package com.polarbear.franc.main.DTO;

import com.polarbear.franc.main.ConsoleScreen;

	public class menu1 extends menuChange{
		
		public menu1() {
			super();
		}
		@Override
		//1. 예약하기(직접 입력, 날짜는 연-월-일/시:분) 및 예약 성공 실패 print
		public void click() throws Exception {
			// TODO Auto-generated method stub
			rsv = ConsoleScreen.showRsvMenu();
			result = dao.book(rsv);
			ConsoleScreen.printResult(result);
		}
	}

