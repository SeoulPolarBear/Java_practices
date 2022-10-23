package com.Soldesk.aug171.main;
//패키지 : 클래스명이 중복될 때 구별할 수 있는 수단!
//      모든 클래스는 패키지에 넣을 수 있도록!!!
//패키지명이 중복? 똑같은면? => 방법이 없음
//      ->전 세계적으로 패키지명이 중복 안되게
//      com.회사명.프로그램명.카테고리 (소문자)
//      kr.co.회사명.프로그램명.카테고리

import java.util.Scanner;

//객체
//      패키지명.클래스명 변수명 = new 패키지명.생성자();
public class PMain2 {
    public static void main(String[] args) {
        java.util.Random r= new java.util.Random();
        java.util.Scanner keyboard = new java.util.Scanner(System.in);

        com.Soldesk.aug171.Product.Scanner s =
                new com.Soldesk.aug171.Product.Scanner(
                        "멀티익스프레스", 500000,"스케너");
    }
}
