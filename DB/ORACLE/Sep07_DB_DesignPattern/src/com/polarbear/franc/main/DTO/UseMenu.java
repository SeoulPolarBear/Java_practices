package com.polarbear.franc.main.DTO;

import java.util.Scanner;

import com.polarbear.franc.main.ConsoleScreen;

public class UseMenu {
	public static void usemenu() {
	int menu = 0;
	menuChange button = null;

	System.out.println("<<���� ���α׷�>>");
	Scanner scan = new Scanner(System.in);
	a : while(true) {
		try {
			//�޴� ����Ʈ ��� �� ���ϴ� ��ȣ�� �Է��ϰ� �ϴ� �޼���
			menu = ConsoleScreen.showMainMenu();
			//�� ��ȣ�� �´� ��� ����
			switch(menu) {
			case 1:	button = new menu1(); button.click(); break;
			case 2:	button = new menu2(); button.click(); break;
			case 3:	button = new menu3(); button.click(); break;
			case 4:	button = new menu4(); button.click(); break;
			case 5:	button = new menu5(); button.click(); break;
			case 6:	button = new menu6(); button.click(); break;
			case 7:	button = new menu7(); button.click(); break;
			case 8:	button = new menu8(); button.click(); break;
			case 9:	button = new menu9(); button.click(); break a;
			}
		} catch(Exception e) {
			e.printStackTrace();
			}
		}	
	}
}

