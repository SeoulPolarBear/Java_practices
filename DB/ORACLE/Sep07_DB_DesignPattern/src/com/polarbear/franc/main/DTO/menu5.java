package com.polarbear.franc.main.DTO;

import com.polarbear.franc.main.ConsoleScreen;

	public class menu5 extends menuChange{
		//5. ���� ã�� (�ּ� �¼� ��) ���
		@Override
		public void click(){
			// TODO Auto-generated method stub
			int seat = ConsoleScreen.LeastSeat();
			/**
			 * @param ArrayList<Restaurant>
			 * */
			ConsoleScreen.restaurantRead(dao.ReadRestaurantUpperSeat(seat));
		}
	}