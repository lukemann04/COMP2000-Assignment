package com.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.model.stockDatabase;

public class ReplenishStock extends JFrame {
    private JPanel mainPanel;
    private JTextField txtStockCode;
    private JTextField txtQuantity;
    private JButton btnReplenish;

    public ReplenishStock(){
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(300,300));
        pack();

        btnReplenish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stockDatabase addStock = new stockDatabase();
                addStock.replenishStock(Integer.parseInt(txtStockCode.getText()), Integer.parseInt(txtQuantity.getText()));
                JOptionPane.showMessageDialog(mainPanel, "Stock Replenished.");
                setVisible(false);
            }
        });
    }

}
