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
    double total = 0.00;

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
                //model.addElement(itemSearch.itemCode);
                model.addElement("Item: " + itemSearch.itemName);
                model.addElement("Price: £" +itemSearch.itemPrice);
                //model.addElement(itemSearch.itemQuantity);
                total = total + Double.parseDouble(itemSearch.itemPrice);
                txtTotal.setText("TOTAL: £" + String.valueOf(total));
            }
        });
        btnCashPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CashPayment page = new CashPayment(total, txtProductDetails);
                page.setVisible(true);
            }
        });
        btnCardPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardPayment page = new CardPayment(total, txtProductDetails);
                page.setVisible(true);
            }
        });
    }
    /*public static void main(String[] args) {
        KioskDisplay page = new KioskDisplay();
        page.setVisible(true);
    }*/
}