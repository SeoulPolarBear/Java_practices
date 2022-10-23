package com.Rabbit.aug174.main;

import com.Rabbit.aug174.Cafe.Coffee;

import javax.swing.*;

public class OMain1 {
    public static void main(String[] args) {
        //타이틀이 ㅋㅋㅋdls JFrame
        JFrame f =new JFrame("ㅋㅋㅋ");
        //사이즈를 300,500 수정
        f.setSize(300,500);
        //타이틀을 ㅎㅎㅎ로 수정
        f.setTitle("ㅎㅎㅎ");
        //보이게 하고 싶다.
      //  f.show();
        f.setVisible(true);




        //커피...
        //이름 : 아메리카노, 3000원
        Coffee coffee1 = new Coffee("Americano", 3000);
        coffee1.printInfo();
    }
}
