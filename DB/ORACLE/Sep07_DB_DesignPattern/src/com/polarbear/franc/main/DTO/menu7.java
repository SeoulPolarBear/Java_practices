package com.polarbear.franc.main.DTO;

import com.polarbear.franc.main.ConsoleScreen;

	public class menu7 extends menuChange{
		//7. 예약 정보 수정 (예약 번호를 입력하면 연락처 변경) 정보 수정 성공 혹은 실패 출력
		@Override
		public void click(){
			// TODO Auto-generated method stub
			int bookNo = ConsoleScreen.BookNo();
			String PhoneNo = ConsoleScreen.PhoneNo();
			result = dao.changePhoneNumber(bookNo, PhoneNo);
			ConsoleScreen.printResult(result);
		}
	}
	