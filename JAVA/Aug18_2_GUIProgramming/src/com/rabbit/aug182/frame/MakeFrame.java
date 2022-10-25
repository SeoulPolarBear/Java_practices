package com.rabbit.aug182.frame;

import javax.swing.*;
import java.awt.*;

//JFrame : Swing에서 윈도우를 나타내는 Class
//     속성 : JPanel(보조 프레임), JButton(버튼), Jlabel(라벨), JTextField(글자입력),...
//  layout : flowLayout - 가운데 정렬
//              BorderLayout -Frame 형식
//              GridLayout - 격자 형태
//              setLocation, setBounds - 위치 임의로 지정
public class MakeFrame extends JFrame {
    JPanel pl;

    public MakeFrame(){
        setSize(500,500);
        setTitle("GUI practice");
        pl = new JPanel();  //패널 하나 생성
        pl.setLayout(new FlowLayout());// 가운데 정렬하겠다.
        for (int i = 1; i <= 10; i++){
            pl.add(new JButton("버튼" + i )); //pl안에 button을 넣은 상태
        }
        add(pl);//JPanel을 JFrame안에 넣기
        setVisible(true);// JFrame 보이게 하기(반대 : false)
    }
}
