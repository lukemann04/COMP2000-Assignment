package com.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    }
}
