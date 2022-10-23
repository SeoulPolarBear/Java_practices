package com.Rabbit.aug175.main;

import com.Rabbit.aug175.avengers.Avengers;

public class AMain2 {
    //어벤져스 클래스
    //이름, 나이 속성
    //공격하기 기능

    public static void main(String[] args) {
        //Avengers로 부터 상속받은
        //클래스명은 모름
        //내부에 만들어놓은 클래스

        //익명 내부 클래스(anonymous inner class)

        Avengers a = new Avengers() {//중괄호 안쪽 부분이 클래스 부분
            @Override
            public void attack() {
                System.out.println("거미줄 발사!");
            }
        };
        a.printInfo();
        a.attack();
        System.out.println("-------------------");
        //아이언맨은 어벤져스
        //공격은 빔
        //흡연 O
        //운전 O
        //속성으로 재산
    }
}
