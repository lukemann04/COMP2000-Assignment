package com;

import javax.swing.*;
import java.awt.*;

public class KioskDisplay extends JFrame {
    private JPanel mainPanel;
    private JTextField txtCodeInput;
    private JLabel lblCodeInput;

    public KioskDisplay() {
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500,500));
        pack();

    }
    public static void main(String[] args) {
        KioskDisplay page = new KioskDisplay();
        page.setVisible(true);
    }
}