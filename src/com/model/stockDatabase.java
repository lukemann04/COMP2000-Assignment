package com.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class stockDatabase {
    ArrayList<ArrayList<String>> stock = new ArrayList<>(3);
    ArrayList<String> newStock = new ArrayList<>();
    public String itemCode;
    public String itemName;
    public String itemPrice;
    public String itemQuantity;
    File stockFile = new File("C:\\Users\\User\\Documents\\GitHub\\COMP2000-Assignment\\src\\com\\stockDatabase.txt");

    public void updateStock() {
        /*newStock.add(newItemCode);
        newStock.add(newItemName);
        newStock.add(newItemPrice);*/
        stock.add(newStock);
    }

    public void readStock() {
        try {
            Scanner reader = new Scanner(stockFile);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                newStock.add(data);
                updateStock();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public ArrayList<String> searchStock(Integer searchCode) {
        ArrayList<String> itemDetails = new ArrayList<>();
        try {
            readStock();
            Integer index = searchCode;
            Integer codeIndex = index;
            Integer nameIndex = index + 1;
            Integer priceIndex = index + 2;
            Integer quantityIndex = index + 3;
            itemCode = newStock.get(codeIndex);
            itemName = newStock.get(nameIndex);
            itemPrice = newStock.get(priceIndex);
            itemQuantity = newStock.get(quantityIndex);
            itemDetails.add(itemCode);
            itemDetails.add(itemName);
            itemDetails.add(itemPrice);
            itemDetails.add(itemQuantity);
        } catch (NumberFormatException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return itemDetails;
    }
}
