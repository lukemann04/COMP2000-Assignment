package com.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.model.stockDatabase;

public class StaffArea extends JFrame{
    private JPanel mainPanel;
    private JList txtNeedsStock;
    private JButton removeItemButton;
    private JButton addNewItemButton;
    private JButton replenishStockButton;
    private JButton btnLogOut;
    DefaultListModel<String> model = new DefaultListModel<>();

    public StaffArea() {
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(500,500));
        pack();
        checkStock();

        btnLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Close form
                setVisible(false);
            }
        });
        replenishStockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReplenishStock page = new ReplenishStock();
                page.setVisible(true);
            }
        });
        addNewItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddNewStock page = new AddNewStock();
                page.setVisible(true);
            }
        });
        removeItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveStockItem page = new RemoveStockItem();
                page.setVisible(true);
            }
        });
    }
    public void checkStock(){
        stockDatabase check = new stockDatabase();
        txtNeedsStock.setModel(model);
        model.removeAllElements();
        model.addAll(check.checkStock());
    }
}
