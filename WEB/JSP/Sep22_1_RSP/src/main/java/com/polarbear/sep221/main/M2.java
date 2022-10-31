package com.polarbear.sep221.main;

public class M2 {
	public static String transaction(int number) {
		if(number == 0) return "가위";
		else if(number == 1) return "바위";
		else if(number == 2) return "보";
		else return "잘못 입력한것 같네요";
	}
}
