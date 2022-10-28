package com.polarbear.franc.main.DTO;

public class menu9 extends menuChange{
	//9. 종료
		@Override
		public void click(){
			// TODO Auto-generated method stub
			System.out.println("프로그램을 종료합니다.");
			dao.finish();
		}
		
	}
