package com.polarbear.franc.main.DTO;

import com.polarbear.franc.main.ConsoleScreen;

	public class menu4 extends menuChange{
		//4. ��ü ���� ��ȸ(��ġ(�¼���) - ����� �̸�) ���
		@Override
		public void click(){
			// TODO Auto-generated method stub
			ConsoleScreen.restaurantRead(dao.ReadAllRestaurant());
		}
	}