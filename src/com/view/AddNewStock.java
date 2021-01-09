package com.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.model.stockDatabase;

public class AddNewStock extends JFrame {
    private JPanel mainPanel;
    private JButton btnAddNewItem;
    private JTextField txtNewCode;
    private JTextField txtNewName;
    private JTextField txtNewPrice;
    private JTextField txtNewQuantity;

    public AddNewStock(){
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(300,300));
        pack();

        btnAddNewItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stockDatabase addItem = new stockDatabase();
                addItem.addStockItem(txtNewCode.getText(), txtNewName.getText(), txtNewPrice.getText(), txtNewQuantity.getText());
                JOptionPane.showMessageDialog(mainPanel, "Item Added.");
                setVisible(false);
            }
        });
    }
}
