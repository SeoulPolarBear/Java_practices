package com.Rabbit.aug176.main;

import com.Rabbit.aug176.human.Human;

//원하는 객체 하나 생성
//이름, 나이, 별명
// 출력

//패턴프로그래밍
//      싱글톤패턴 ***
public class SMain1 {
    public static void main(String[] args) {
        Human human = Human.getLim();
        System.out.println(human);
        System.out.println("+===================================+");
        Human human2 = Human.getLim();
        System.out.println(human2);
        human2.printInfo();




    }
}
