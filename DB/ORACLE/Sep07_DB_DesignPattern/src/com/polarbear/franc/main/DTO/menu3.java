package com.polarbear.franc.main.DTO;


import com.polarbear.franc.main.ConsoleScreen;

	public class menu3 extends menuChange{
		//3. 전체 예약 확인(날짜는 연-월-일 요일 오전/오후 시:분) 출력
		@Override
		public void click(){
			// TODO Auto-generated method stub
			ConsoleScreen.ReservationRead(dao.ReadAllBook());
		}
	}
	