package com.Rabbit.aug175.main;

import com.Rabbit.aug175.avengers.Avengers;
import com.Rabbit.aug175.avengers.IronMan;

//다형성(Polymorphism)
//Poly (많은) + morph(모양)
//상위타입 변수에 하위타입 객체를 담는 것이 가능
//같은 형태이지만 다른 기능을 할 수 있다.(overriding과 밀접한 관련)
public class AMain3 {
    public static void main(String[] args) {
        //아이언맨 담는 그릇 i에 아이언맨 만들어 넣음
        IronMan i = new IronMan("a",123,1231231);


        //어벤져스 담는 그릇 a에 아이언맨 만들어 넣음
        Avengers a = new IronMan("b",123,1222222);
    }
}
