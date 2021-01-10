package com.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.view.KioskDisplay;

public class CashPayment extends JFrame {
    private JPanel mainPanel;
    private JTextField txtCashTotal;
    private JTextField txtCashPaid;
    private JTextField txtCashChange;
    private JButton btnPrintReceipt;
    private JButton btnCalcChange;

    public CashPayment(Double parseTotal, JList<String> parseBasket){
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(300,300));
        pack();
        txtCashTotal.setText("£" + String.valueOf(parseTotal));

        btnCalcChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtCashChange.setText("£" + String.valueOf(Double.parseDouble(txtCashPaid.getText()) - parseTotal));
            }
        });
        btnPrintReceipt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Receipt page = new Receipt(parseTotal, txtCashPaid.getText(), txtCashChange.getText(), parseBasket);
                page.setVisible(true);
                setVisible(false);
            }
        });
    }
}
