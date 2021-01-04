package com.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KioskDisplay extends JFrame {
    private JPanel mainPanel;
    private JTextField txtCodeInput;
    private JLabel lblCodeInput;
    private JTextArea txtProductDetails;
    private JTextArea txtTotal;
    private JButton btnAdminLogin;
    private JButton btnCashPayment;
    private JButton btnCardPayment;
    private JButton btnClearItems;

    public KioskDisplay() {
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500,500));
        pack();

        btnClearItems.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Clear Items Array
                txtProductDetails.setText("");
                txtTotal.setText("");
            }
        });
        btnAdminLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Go to login form
                AdminLogin page = new AdminLogin();
                page.setVisible(true);
            }
        });
    }
    public static void main(String[] args) {
        KioskDisplay page = new KioskDisplay();
        page.setVisible(true);
    }
}