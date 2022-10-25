package com.rabbit.aug182.main;

import com.rabbit.aug182.frame.TempFrame;

import javax.swing.*;

public class GMain3 {
    public static void main(String[] args) {
        //화씨온도 -> 섭씨온도 변환기
        JFrame jf = new JFrame();
        JPanel jp = new JPanel();
        jf.add(jp);
        JLabel label1 = new JLabel("화씨 온도 : ");
        JLabel label2 = new JLabel("섭씨 온도 : ");

        JTextField field1 = new JTextField(15);
        JTextField field2 = new JTextField(15);

        JButton button = new JButton("변환");
        jp.add(label1);
        jp.add(label2);
        jp.add(field1);
        jp.add(field2);
        jp.add(button);

        TempFrame tempFrame = new TempFrame(jp,label1,label2,field1,field2,button);
        button.addActionListener(tempFrame);
        jf.setTitle("온도 변환기");
        jf.setSize(300, 150);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//X 클릭시 프로그램 종료
        jf.setVisible(true);
    }
}
