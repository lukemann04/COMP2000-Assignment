package com.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.model.stockDatabase;

public class RemoveStockItem extends JFrame {
    private JPanel mainPanel;
    private JTextField txtItemCode;
    private JButton btnRemove;

    public RemoveStockItem(){
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(300,300));
        pack();

        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stockDatabase removeItem = new stockDatabase();
                removeItem.removeItem(Integer.parseInt(txtItemCode.getText()));
                JOptionPane.showMessageDialog(mainPanel, "Item Removed.");
                setVisible(false);
            }
        });
    }
}
