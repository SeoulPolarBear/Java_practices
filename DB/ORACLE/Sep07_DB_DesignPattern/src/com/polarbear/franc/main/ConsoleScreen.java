package com.polarbear.franc.main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.polarbear.franc.reservation.Reservation;
import com.polarbear.franc.restaurant.Restaurant;

//사용자가 콘솔을 볼 수 있거나, 콘솔에 입력할 수 있게

//아래 메뉴를 볼 수 있는 기능도 있었으면 !

//1. 예약하기(직접 입력, 날짜는 연-월-일/시:분) 
//2. 매장 등록(새로운 매장)
//3. 전체 예약 확인(날짜는 연-월-일 요일 오전/오후 시:분)
//4. 전체 매장 조회(위치(좌석수) - 사장님 이름)
//5. 매장 찾기 (최소 좌석 수)
//6. 예약 찾기 (예약자 이름)
//7. 예약 정보 수정 (예약 번호를 입력하면 연락처 변경)
//8. 예약 취소 (예약번호를 입력하면 취소)
//9. 종료

public class ConsoleScreen {
	static Scanner scan = new Scanner(System.in);
	public static int showMainMenu() {
		
		System.out.println("============================================================");
		System.out.println("				메뉴판");
		System.out.println("============================================================");
		System.out.println("1. 예약하기(직접 입력, 날짜는 연-월-일/시:분)");  
		System.out.println("2. 매장 등록");  
		System.out.println("3. 전체 예약 확인(날짜는 연-월-일 요일 오전/오후 시:분)");  
		System.out.println("4. 전체 매장 조회(위치(좌석수) - 사장님 이름)");  
		System.out.println("5. 매장 찾기 (최소 좌석 수)");  
		System.out.println("6. 예약 찾기 (예약자 이름)");  
		System.out.println("7. 예약 정보 수정 (예약 번호를 입력하면 연락처 변경)");  
		System.out.println("8. 예약 취소 (예약번호를 입력하면 취소)");  
		System.out.println("9. 종료");  
		System.out.println("============================================================");
		System.out.println("원하시는 메뉴를 입력해 주세요. : ");
		int number = scan.nextInt();
		return number;
		
	}
	//1. 예약
	public static Reservation showRsvMenu() throws Exception{
		
		System.out.println("예약자 : ");
		String name = scan.next();
		
		System.out.print("예약 날짜(YYYY-MM-DD/HH:mm) : ");
		String when = scan.next();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd/H:mm");
		
		Date when2 = sdf.parse(when);

		System.out.print("전화 번호 : ");
		String phoneNum = scan.next();
		System.out.print("예약 지정명 : ");
		String location = scan.next();

		Reservation r = new Reservation(0,name,when2,phoneNum,location);
		return r;
		
	}
	//2. 매장 등록
	public static Restaurant showRes() {
		System.out.println("지점 : ");
		String location = scan.next();
		System.out.println("오너 : ");
		String owner = scan.next();
		System.out.println("좌석 수 : ");
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
	//최소 자리수 입력
	public static int LeastSeat() {
		Scanner scan = new Scanner(System.in);
		System.out.println("최소 좌석 수 입력 :");
		return scan.nextInt();
	}
	//예약자 입력
	public static String ResPerson() {
		Scanner scan = new Scanner(System.in);
		System.out.println("예약자 입력 :");
		return scan.next();
	}
	public static int BookNo() {
		System.out.println("예약 번호 입력 : ");
		return scan.nextInt();
	}
	public static String PhoneNo() {
		System.out.println("변경할 핸드폰 번호 입력 : ");
		return scan.next();
	}
	
	public static void printResult(String result) {
		System.out.println(result);
	}
}
	

