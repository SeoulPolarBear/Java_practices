package com.rabbit.aug251.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class CMain2 {
    public static void main(String[] args) {
        //학생 객체 - 이름 / 국어 / 영어 / 수학 + 속성들 출력 기능
        Scanner scan = new Scanner(System.in);
        System.out.print("학생 번호를 입력하세요.(1~4) : ");
        int k = scan.nextInt();
        //학생의 번호를 입력하면 -> 그 학생의 정보를 출력하게 할건데...
        //값이 지정이 되
        // 학생 4명
        Student s1 = new Student("Lim", 80,90,100);
        Student s2 = new Student("Kim", 85,90,100);
        Student s3 = new Student("Hwang", 80,96,100);
        Student s4 = new Student("Ahn", 100,100,100);
        //해당 번호 학생의 전체 정보가 출력되게
        ArrayList<Student> array = new ArrayList<>();
        array.add(s1);
        array.add(s2);
        array.add(s3);
        array.add(s4);
        HashMap<Integer,Student> hm = new HashMap<>();
        hm.put(1,s1);
        hm.put(2,s2);
        hm.put(3,s3);
        hm.put(4,s4);

        array.get(k - 1).printInfo();
        hm.get(k).printInfo();
        //해당 번호 학생의 영어점수만 출력되게
        System.out.printf( "영어 점수 : %d \n", array.get(k-1).getEnglish());
        System.out.printf( "영어 점수 : %d \n", hm.get(k).getEnglish());
        //전체 학생의 정보 출력
        Set<Integer> key = hm.keySet();
        for (Student s : array) {
            s.printInfo();
        }
        for (int m : key) {
            hm.get(m).printInfo();
        }

    }
}
