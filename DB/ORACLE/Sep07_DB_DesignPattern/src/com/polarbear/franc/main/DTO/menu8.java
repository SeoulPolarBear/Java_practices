package com.polarbear.franc.main.DTO;

import com.polarbear.franc.main.ConsoleScreen;

	public class menu8 extends menuChange{
		@Override
		//8. ���� ��� (�����ȣ�� �Է��ϸ� ���) ��� ���� Ȥ�� ���� ���
		public void click(){
			// TODO Auto-generated method stub
			int bookNo = ConsoleScreen.BookNo();
			result = dao.CancelBook(bookNo);
			ConsoleScreen.printResult(result);
		}
	}
	