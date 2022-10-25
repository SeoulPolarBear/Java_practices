package com.rabbit.aug182.frame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

//JFrame 생성 (500,500)
//JPanel안에 1~30까지의 숫자가 랜덤한 위치에 나오게
//숫자를 여러개 뽑을 때 >> 반복문
//array[] 배열 사용
//글자가 표현되게 하려면 => Jlabel을 이용
//set ~~
//배경색, 글자색도 바꿔보고

public class NumberFrame extends JFrame {
    JPanel pl = new JPanel();
    JLabel[] jLabel = new JLabel[30];
    public NumberFrame(){
        pl.setLayout(null);
        Random r = new Random();
        pl.setBackground(Color.BLUE);
        int x =0;
        int y = 0;
        for(int i = 0; i < 30; i++){
            jLabel[i] = new JLabel(String.valueOf(i + 1));
            jLabel[i].setSize(50,60);
            x = r.nextInt(500) + 1;
            y = r.nextInt(500) + 1;
            jLabel[i].setLocation(x, y);
            jLabel[i].setOpaque(true);
            jLabel[i].setForeground(Color.GREEN);
            jLabel[i].setBackground(Color.pink);
            pl.add(jLabel[i]);
        }
        add(pl);
        setSize(800,800);
        setTitle("임의의 숫자");
        setVisible(true);

    }
}
