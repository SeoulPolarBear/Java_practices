package com.polarbear.franc.main.DTO;

import com.polarbear.franc.main.ConsoleScreen;

public class menu2 extends menuChange{
		
		public menu2() {
			super();
		}
		//2. ���� ��� �� ��� ���� ���� print
		@Override
		public void click() throws Exception{
			// TODO Auto-generated method stub
			res = ConsoleScreen.showRes();
			result = dao.UpdateRestaurant(res);
			ConsoleScreen.printResult(result);
		}
	}

