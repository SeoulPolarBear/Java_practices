package com.rabbit.aug182.frame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class TempFrame implements ActionListener {
    private JPanel panel;
    private JLabel label1;
    private JLabel label2 ;
    private JTextField field1;
    private JTextField field2;
    private JButton button;
    public TempFrame() {

    }
    public TempFrame(JPanel panel, JLabel label1, JLabel label2, JTextField field1, JTextField field2, JButton button) {
        this.panel = panel;
        this.label1 = label1;
        this.label2 = label2;
        this.field1 = field1;
        this.field2 = field2;
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            double fahrenheit = Double.parseDouble(field1.getText());
            double celcius = (double)5/9 *(fahrenheit - 32);
            String c = new DecimalFormat("##.####").format(celcius);
            field2.setText(c);
        }

    }
}
