package com.view;

import javax.swing.*;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Receipt extends JFrame {
    private JPanel mainPanel;
    private JList txtBasket;
    private JTextArea txtCompanyName;
    private JTextArea txtChange;
    private JTextArea txtDate;
    private JTextArea txtTotal;

    public Receipt(Double parseTotal, String parsePaid, String parseChange, JList<String> parseBasket){
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(250,500));
        pack();

        txtBasket.add(parseBasket);
        txtTotal.setText("£" + String.valueOf(parseTotal));
        txtChange.setText("Amount Paid: £" + parsePaid + "     Change Given: " + parseChange);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        txtDate.setText("Date: " + dtf.format(now));
    }
}
