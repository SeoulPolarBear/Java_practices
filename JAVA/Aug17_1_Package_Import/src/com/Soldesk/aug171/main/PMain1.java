package com.Soldesk.aug171.main;

import com.Soldesk.aug171.Product.Computer;
import com.Soldesk.aug171.Product.Scanner;

//파일 모아두는 폴더
public class PMain1 {
    public static void main(String[] args) {
        //매직스테이션, 800000원, i5-1234, 8GB, 500GB 컴퓨터
        //출력
        Computer c = new Computer("매직스테이션", 800000,"컴퓨터",
                "i5-1234",8,500);
        c.printInfo();
        //멀티익스프레스, 500000원 스캐너
        Scanner scanner = new Scanner("멀티익스프레스",500000,
                "스케너");
        //출력
        scanner.printInfo();
    }

}
