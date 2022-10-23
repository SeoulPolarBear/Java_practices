package com.Rabbit.aug172.main;
//IMain.java에서 쓰는 Scanner는 무조건 이것만 사용하겠다!
import com.Rabbit.aug172.machine.Scanner;

public class IMain1 {
    public static void main(String[] args) {
        //객체 만들때 패키지명을 생략 가능한 경우
        //  - 자바 기본 패키지(java.lang) 소속 일 때 생략이 가능하다.
        java.lang.String s1 = "ㅋ";
        java.lang.System.out.println("a");
        
        //같은 패키시 소속 생략가능
        com.Rabbit.aug172.main.Rabbit b = new com.Rabbit.aug172.main.Rabbit();
        Rabbit b2 = new Rabbit();// 다음 2개는 같은 문법

        //다른 스캐너 소속일 때
        com.Rabbit.aug172.machine.Scanner s = new com.Rabbit.aug172.machine.Scanner();
        Scanner s2 = new Scanner();
    }
}
