package com.rabbit.aug182.frame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMIFrame implements ActionListener {
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JLabel jLabel3;

    public BMIFrame(JTextField jTextField1, JTextField jTextField2, JLabel jLabel3) {
        this.jTextField1 = jTextField1;
        this.jTextField2 = jTextField2;
        this.jLabel3 = jLabel3;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double height = Double.parseDouble(jTextField1.getText());
        double weight = Double.parseDouble(jTextField2.getText());

        double BMI = weight / Math.pow((height/100),2);

        String result ="";

        if(0 <= BMI &&BMI <18.5){
            result = "저체중";
        }
        else if(18.5 <= BMI && BMI < 23.0){
            result = "정상체중";
        }
        else if(23.0 <= BMI && BMI < 25.0){
            result = "과체중";
        }
        else if(25.0 <= BMI){
            result = "비만";
        }
        else{
            result = "잘못 입력하셨습니다";
        }
        //System.out.printf(); == String.format();을 이용해보자
        String finalResult = String.format("BMI : %2f, 당신은 %s 입니다.", BMI, result);
        jLabel3.setText(finalResult);
    }
}


