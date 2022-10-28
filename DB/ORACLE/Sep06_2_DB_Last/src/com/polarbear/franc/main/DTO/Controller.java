package com.polarbear.franc.main.DTO;

import java.util.Scanner;

import com.polarbear.franc.main.ConsoleScreen;
import com.polarbear.franc.main.DAO.DAO;
import com.polarbear.franc.reservation.Reservation;
import com.polarbear.franc.restaurant.Restaurant;

//짝 기능들을 여기서 어떤 흐름으로 보여줄지 보여주면 된다.
public class Controller {
	public static void main(String[] args) {
		int menu = 0;
		Reservation rsv = null;
		String result = null;
		DAO dao = new DAO();
		Restaurant res = null;
		
		System.out.println("<<예약 프로그램>>");
		Scanner scan = new Scanner(System.in);
		while(true) {
			try {
				menu = ConsoleScreen.showMainMenu();
				if(menu == 9) {
					System.out.println("프로그램을 종료합니다.");
					dao.finish();
					break;
					
				} else if (menu == 1) {
					rsv = ConsoleScreen.showRsvMenu();
					result = dao.book(rsv);
					ConsoleScreen.printResult(result);
					
				}else if (menu == 2) {
					res = ConsoleScreen.showRes();
					result = dao.UpdateRestaurant(res);
					ConsoleScreen.printResult(result);
					
				}else if (menu == 3) {
					ConsoleScreen.ReservationRead(dao.ReadAllBook());
					
				}else if(menu == 4) {
					ConsoleScreen.restaurantRead(dao.ReadAllRestaurant());
					
				}else if(menu == 5) {
					int seat = ConsoleScreen.LeastSeat();
					/**
					 * @param ArrayList<Restaurant>
					 * */
					ConsoleScreen.restaurantRead(dao.ReadRestaurantUpperSeat(seat));
				}else if(menu == 6) {
					/**
					 * @param ArrayList<Reservation>
					 * */
					String name = ConsoleScreen.ResPerson();
					ConsoleScreen.ReservationRead(dao.findBook(name));
				}else if(menu == 7) {
					int bookNo = ConsoleScreen.BookNo();
					String PhoneNo = ConsoleScreen.PhoneNo();
					result = dao.changePhoneNumber(bookNo, PhoneNo);
					ConsoleScreen.printResult(result);
				}else if(menu == 8) {
					int bookNo = ConsoleScreen.BookNo();
					result = dao.CancelBook(bookNo);
					ConsoleScreen.printResult(result);
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
//	public static void main(String[] args) {
//		if(번호 == 1) {
//			consolescreen.예약하기 기능(입력)
//			dao.db관련 예약기능(insert)
//			결과보여주기(성공 or 실패)
//		}
//	}
	
	
	
	
}
