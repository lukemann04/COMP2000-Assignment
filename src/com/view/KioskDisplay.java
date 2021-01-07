package com.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.model.*;

public class KioskDisplay extends JFrame {
    private JPanel mainPanel;
    private JTextField txtCodeInput;
    private JLabel lblCodeInput;
    private JList txtProductDetails;
    private JTextArea txtTotal;
    private JButton btnAdminLogin;
    private JButton btnCashPayment;
    private JButton btnCardPayment;
    private JButton btnClearItems;
    private JButton btnAdd;

    public KioskDisplay() {
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500,500));
        pack();

        btnClearItems.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Clear Items Array
                //txtProductDetails.;
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
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stockDatabase itemSearch = new stockDatabase();
                //ArrayList<ArrayList<String>> outputDetails = new ArrayList<>(3);
                //outputDetails.add(itemSearch.searchStock(Integer.parseInt(txtCodeInput.getText())));
                JList<String> list = new JList<String>(itemSearch.searchStock(Integer.parseInt(txtCodeInput.getText())).toArray(new String[itemSearch.searchStock(Integer.parseInt(txtCodeInput.getText())).size()]));
                txtProductDetails.add(list);
                //txtProductDetails.add(itemSearch.searchStock(Integer.parseInt(txtCodeInput.getText())).toArray(new String[itemSearch.searchStock(Integer.parseInt(txtCodeInput.getText())).size()]));
                //txtProductDetails.add(itemSearch.searchStock(Integer.parseInt(txtCodeInput.getText())).get(1));
            }
        });
    }
    /*public static void main(String[] args) {
        KioskDisplay page = new KioskDisplay();
        page.setVisible(true);
    }*/
}