package com.polarbear.franc.main.DTO;


import com.polarbear.franc.main.ConsoleScreen;

	public class menu3 extends menuChange{
		//3. ��ü ���� Ȯ��(��¥�� ��-��-�� ���� ����/���� ��:��) ���
		@Override
		public void click(){
			// TODO Auto-generated method stub
			ConsoleScreen.ReservationRead(dao.ReadAllBook());
		}
	}
	