package com.polarbear.franc.main.DTO;

import com.polarbear.franc.main.ConsoleScreen;


	public class menu6 extends menuChange{
		@Override
		//6. 예약 찾기 (예약자 이름) 출력
		public void click(){
			// TODO Auto-generated method stub
			/**
			 * @param ArrayList<Reservation>
			 * */
			String name = ConsoleScreen.ResPerson();
			ConsoleScreen.ReservationRead(dao.findBook(name));
		}
	}
