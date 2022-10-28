package com.polarbear.franc.main.DTO;

import com.polarbear.franc.main.ConsoleScreen;

public class menu2 extends menuChange{
		
		public menu2() {
			super();
		}
		//2. 매장 등록 및 등록 성공 실패 print
		@Override
		public void click() throws Exception{
			// TODO Auto-generated method stub
			res = ConsoleScreen.showRes();
			result = dao.UpdateRestaurant(res);
			ConsoleScreen.printResult(result);
		}
	}

