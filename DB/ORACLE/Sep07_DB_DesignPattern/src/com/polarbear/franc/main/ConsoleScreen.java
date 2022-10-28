package com.polarbear.franc.main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.polarbear.franc.reservation.Reservation;
import com.polarbear.franc.restaurant.Restaurant;

//����ڰ� �ܼ��� �� �� �ְų�, �ֿܼ� �Է��� �� �ְ�

//�Ʒ� �޴��� �� �� �ִ� ��ɵ� �־����� !

//1. �����ϱ�(���� �Է�, ��¥�� ��-��-��/��:��) 
//2. ���� ���(���ο� ����)
//3. ��ü ���� Ȯ��(��¥�� ��-��-�� ���� ����/���� ��:��)
//4. ��ü ���� ��ȸ(��ġ(�¼���) - ����� �̸�)
//5. ���� ã�� (�ּ� �¼� ��)
//6. ���� ã�� (������ �̸�)
//7. ���� ���� ���� (���� ��ȣ�� �Է��ϸ� ����ó ����)
//8. ���� ��� (�����ȣ�� �Է��ϸ� ���)
//9. ����

public class ConsoleScreen {
	static Scanner scan = new Scanner(System.in);
	public static int showMainMenu() {
		
		System.out.println("============================================================");
		System.out.println("				�޴���");
		System.out.println("============================================================");
		System.out.println("1. �����ϱ�(���� �Է�, ��¥�� ��-��-��/��:��)");  
		System.out.println("2. ���� ���");  
		System.out.println("3. ��ü ���� Ȯ��(��¥�� ��-��-�� ���� ����/���� ��:��)");  
		System.out.println("4. ��ü ���� ��ȸ(��ġ(�¼���) - ����� �̸�)");  
		System.out.println("5. ���� ã�� (�ּ� �¼� ��)");  
		System.out.println("6. ���� ã�� (������ �̸�)");  
		System.out.println("7. ���� ���� ���� (���� ��ȣ�� �Է��ϸ� ����ó ����)");  
		System.out.println("8. ���� ��� (�����ȣ�� �Է��ϸ� ���)");  
		System.out.println("9. ����");  
		System.out.println("============================================================");
		System.out.println("���Ͻô� �޴��� �Է��� �ּ���. : ");
		int number = scan.nextInt();
		return number;
		
	}
	//1. ����
	public static Reservation showRsvMenu() throws Exception{
		
		System.out.println("������ : ");
		String name = scan.next();
		
		System.out.print("���� ��¥(YYYY-MM-DD/HH:mm) : ");
		String when = scan.next();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd/H:mm");
		
		Date when2 = sdf.parse(when);

		System.out.print("��ȭ ��ȣ : ");
		String phoneNum = scan.next();
		System.out.print("���� ������ : ");
		String location = scan.next();

		Reservation r = new Reservation(0,name,when2,phoneNum,location);
		return r;
		
	}
	//2. ���� ���
	public static Restaurant showRes() {
		System.out.println("���� : ");
		String location = scan.next();
		System.out.println("���� : ");
		String owner = scan.next();
		System.out.println("�¼� �� : ");
		int seat = scan.nextInt();
		
		return new Restaurant(location, owner, seat);
	}
	
	public static void restaurantRead(ArrayList<Restaurant> array) {
		
		for (Restaurant res : array) {
			System.out.printf("%s(%d) - %s\n", res.getLocation(), res.getSeat(),res.getOwner());
	System.out.println("=============================================");
//			System.out.println(res.getLocation());
//			System.out.println(res.getOwner());
//			System.out.println(res.getSeat());
//			System.out.println("=============================================");
		}
	}
	
	public static void ReservationRead(ArrayList<Reservation> array) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
		
		for (Reservation res : array) {
			System.out.println(res.getNo());
			System.out.println(res.getName());
			System.out.println(sdf.format(res.getWhen()));
			System.out.println(res.getPhone());
			System.out.println(res.getLocation());
			System.out.println("=============================================");
		}
	}
	//�ּ� �ڸ��� �Է�
	public static int LeastSeat() {
		Scanner scan = new Scanner(System.in);
		System.out.println("�ּ� �¼� �� �Է� :");
		return scan.nextInt();
	}
	//������ �Է�
	public static String ResPerson() {
		Scanner scan = new Scanner(System.in);
		System.out.println("������ �Է� :");
		return scan.next();
	}
	public static int BookNo() {
		System.out.println("���� ��ȣ �Է� : ");
		return scan.nextInt();
	}
	public static String PhoneNo() {
		System.out.println("������ �ڵ��� ��ȣ �Է� : ");
		return scan.next();
	}
	
	public static void printResult(String result) {
		System.out.println(result);
	}
}
	

