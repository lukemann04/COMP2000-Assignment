package com.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardPayment extends JFrame {
    private JPanel mainPanel;
    private JButton btnVerify;

    public CardPayment(Double parseTotal, JList<String> parseBasket){
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(300,300));
        pack();


        btnVerify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Receipt page = new Receipt(parseTotal, String.valueOf(parseTotal), "N/A", parseBasket);
                page.setVisible(true);
                setVisible(false);
            }
        });
    }
}
