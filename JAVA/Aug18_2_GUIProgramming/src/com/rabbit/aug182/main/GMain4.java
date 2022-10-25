package com.rabbit.aug182.main;

import com.rabbit.aug182.frame.BMIFrame;

import javax.swing.*;
import java.awt.*;

public class GMain4 {
    public static void main(String[] args) {
        //제목이 BMI 검사인 JFrame
        JFrame jf = new JFrame("BMI 검사");
        //3행 2열짜리 GridLayout
        GridLayout gl = new GridLayout(3,2);
        jf.setLayout(gl);

        JLabel jLabel1 = new JLabel("키(cm) : ");
        JTextField jTextField1 = new JTextField(15);
        JLabel jLabel2 = new JLabel("몸무게(kg) : ");
        JTextField jTextField2 = new JTextField(15);
        JLabel jLabel3 = new JLabel("결과 : ");;
        JButton jButton = new JButton("버튼");

        jf.add(jLabel1);
        jf.add(jTextField1);
        jf.add(jLabel2);
        jf.add(jTextField2);
        jf.add(jLabel3);
        jf.add(jButton);

        BMIFrame bmiFrame = new BMIFrame(jTextField1,jTextField2,jLabel3);
        jButton.addActionListener(bmiFrame);
        jf.setSize(500,120);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
}
