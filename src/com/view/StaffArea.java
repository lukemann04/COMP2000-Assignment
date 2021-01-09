package com.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.model.stockDatabase;

public class StaffArea extends JFrame{
    private JPanel mainPanel;
    private JTextArea txtNeedsStock;
    private JButton removeItemButton;
    private JButton addNewItemButton;
    private JButton replenishStockButton;
    private JButton btnLogOut;

    public StaffArea() {
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(500,500));
        pack();

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

            }
        });
    }
}
