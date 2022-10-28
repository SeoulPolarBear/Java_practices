package com.polarbear.franc.main.DTO;

import com.polarbear.franc.main.ConsoleScreen;

	public class menu8 extends menuChange{
		@Override
		//8. 예약 취소 (예약번호를 입력하면 취소) 취소 성공 혹은 실패 출력
		public void click(){
			// TODO Auto-generated method stub
			int bookNo = ConsoleScreen.BookNo();
			result = dao.CancelBook(bookNo);
			ConsoleScreen.printResult(result);
		}
	}
	