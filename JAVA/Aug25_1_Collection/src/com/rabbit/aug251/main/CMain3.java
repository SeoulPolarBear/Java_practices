package com.rabbit.aug251.main;

import java.util.*;

public class CMain3 {
    public static void main(String[] args) {
        //학생의 이름을 입력했을 때
        //그 학생의 전체 정보를 출력하고 싶음
        Scanner scan = new Scanner(System.in);
        System.out.print("학생 이름을 입력하세요 : ");
        String k = scan.next();
        //학생의 번호를 입력하면 -> 그 학생의 정보를 출력하게 할건데...
        //값이 지정이 되
        // 학생 4명
        Student s1 = new Student("Lim", 80,90,100);
        Student s2 = new Student("Kim", 85,90,100);
        Student s3 = new Student("Hwang", 80,96,100);
        Student s4 = new Student("Ahn", 100,100,100);
        //해당 번호 학생의 전체 정보가 출력되게
        HashMap<String ,Student> hm = new HashMap<>();
        hm.put("Lim",s1);
        hm.put("Kim",s2);
        hm.put("Hwang",s3);
        hm.put("Ahn",s4);

        HashSet<Student> hs = new HashSet<>();
        hs.add(s1);
        hs.add(s2);
        hs.add(s3);
        hs.add(s4);

        hm.get(k).printInfo();
        for (Student s : hs) {
            if(s.getName().equals(k))
                s.printInfo();
        }

        //해당 번호 학생의 영어점수만 출력되게
        System.out.printf( "영어 점수 : %d \n", hm.get(k).getEnglish());
        //전체 학생의 정보 출력
        Set<String> key = hm.keySet();



        for (String m : key) {
            hm.get(m).printInfo();
        }

    }
}
