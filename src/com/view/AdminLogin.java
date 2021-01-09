package com.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AdminLogin extends JFrame{
    private JPanel mainPanel;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JLabel lblUsername;
    private JLabel lblPassword;
    private JButton btnSubmit;
    private JLabel txtErrorText;

    public AdminLogin() {
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(300,300));
        pack();

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Check Details
                try {
                    File myObj = new File("C:\\Users\\User\\Documents\\GitHub\\COMP2000-Assignment\\src\\com\\admins.txt");
                    Scanner reader = new Scanner(myObj);
                    String data;
                    String pwd = new String(txtPassword.getPassword());
                    Boolean userFound = false;
                    while (reader.hasNextLine()) {
                        data = reader.nextLine();
                        if(data.equals(txtUsername.getText())){
                            userFound = true;
                            data = reader.nextLine();
                            if(data.equals(pwd)){
                                //Load Staff Area
                                setVisible(false);
                                StaffArea page = new StaffArea();
                                page.setVisible(true);
                            } else{txtErrorText.setText("Incorrect Password");}
                        }
                    }
                    if(userFound == false) {
                        txtErrorText.setText("User not found.");
                    }
                    reader.close();
                } catch (FileNotFoundException n) {
                    System.out.println("An error occurred.");
                    n.printStackTrace();
                }

            }
        });
    }
}
