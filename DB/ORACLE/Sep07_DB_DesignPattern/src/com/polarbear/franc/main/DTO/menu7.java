package com.polarbear.franc.main.DTO;

import com.polarbear.franc.main.ConsoleScreen;

	public class menu7 extends menuChange{
		//7. ���� ���� ���� (���� ��ȣ�� �Է��ϸ� ����ó ����) ���� ���� ���� Ȥ�� ���� ���
		@Override
		public void click(){
			// TODO Auto-generated method stub
			int bookNo = ConsoleScreen.BookNo();
			String PhoneNo = ConsoleScreen.PhoneNo();
			result = dao.changePhoneNumber(bookNo, PhoneNo);
			ConsoleScreen.printResult(result);
		}
	}
	