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
    DefaultListModel<String> model = new DefaultListModel<>();

    public KioskDisplay() {
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500,500));
        pack();

        btnClearItems.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Clear Items Array
                model.removeAllElements();
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
                //Search stock and add item to basket
                stockDatabase itemSearch = new stockDatabase();
                itemSearch.searchStock(Integer.parseInt(txtCodeInput.getText()));
                txtProductDetails.setModel(model);
                model.addElement(itemSearch.itemCode);
                model.addElement(itemSearch.itemName);
                model.addElement(itemSearch.itemPrice);
                model.addElement(itemSearch.itemQuantity);
            }
        });
    }
    /*public static void main(String[] args) {
        KioskDisplay page = new KioskDisplay();
        page.setVisible(true);
    }*/
}