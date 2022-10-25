package com.rabbit.aug251.main;

import java.util.*;

//Set 계열
//  가변사이즈
//  중복데이터 자동 삭제
//      같은 객체가 여러번 들어가면 하나만 남김
//      순서가 랜덤
//      HashSet, TreeSet, ...
//          =>실전에서는 그닥 유용하지 않음
public class SetMain {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<String>();
        hs.add("ㅁㅁ");
        hs.add("ㅎㅎ");
        hs.add("ㅊㅊ");
        hs.add("ㄴㄴ");
        hs.add("ㄱㄱ");
        hs.add("ㅅㅅ");
        hs.add("ㄴㄴ");
        hs.add("ㅎㅎ");

        System.out.println(hs.size());
        for (String str: hs) {
            System.out.println(str);
        }

        System.out.println("===================================");
        //ArrayList로 데이터를 받아오자 ! => 정수 - 10개
        //중복 제거후 내림차순으로 정렬
        ArrayList<Integer> array = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            array.add(new Random().nextInt(7) + 1);
        }
        HashSet<Integer> si = new HashSet<>(array);//set에 list를 담아서 중복 제거
        array = new ArrayList<>(si);//다시 list로 변경
        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //return o1.compareTo(o2);//o1이 기준이면 오름차순
                return o2.compareTo(o1);//o1이 기준이면 내림차순
                
            }
        };
        array.sort(c);
        for (Integer i : array
             ) {
            System.out.println(i);
        }
    }
}
