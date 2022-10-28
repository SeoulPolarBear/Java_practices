package com.polarbear.franc.main.DTO;

import com.polarbear.franc.main.ConsoleScreen;

	public class menu4 extends menuChange{
		//4. 전체 매장 조회(위치(좌석수) - 사장님 이름) 출력
		@Override
		public void click(){
			// TODO Auto-generated method stub
			ConsoleScreen.restaurantRead(dao.ReadAllRestaurant());
		}
	}