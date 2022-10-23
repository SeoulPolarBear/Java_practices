package com.Rabbit.aug173.main;

import com.Rabbit.aug173.dog.Dog;

public class AMain1 extends Dog {
    public static void main(String[] args) {
            Dog dog = new Dog();
            dog.a = 1;
            //정작 책에서 다른 패키지 라면 하위클래스 가능은 잘 못된 설명이다.
            dog.b = 2;
            //같은 package 내
            dog.c = 3;
            //클래스 내부에서만 사용 가능
            dog.d = 4;
    }
}
