package com.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class stockDatabase {
    ArrayList<ArrayList<String>> stock = new ArrayList<>(3);
    ArrayList<String> newStock = new ArrayList<>();
    public String itemCode;
    public String itemName;
    public String itemPrice;
    public String itemQuantity;
    public String[] temp = new String[0];
    File stockFile = new File("src/com/model/stockDatabase.txt");

    public void updateStock() {
        stock.add(newStock);
    }

    public void replenishStock(Integer rStockCode, Integer rStockQuantity) {
        Integer n = 0;
        Integer found = 0;
        Integer k = null;

        try {
            Scanner reader = new Scanner(stockFile);
            while (reader.hasNextLine()) {
                n = temp.length;
                String[] newTemp = new String[n + 1];

                for (int i=0; i < temp.length; i++)
                {
                    newTemp[i] = temp[i];
                }

                String data = reader.nextLine();
                newTemp[newTemp.length - 1] = data;
                temp = newTemp;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        for (int i=0; i < temp.length; i++)
        {
            if(temp[i].equals(String.valueOf(rStockCode)))
            {
                k = i;
                found++;
                break;
            }
        }
        if(found > 0)
        {
            temp[k + 3] = String.valueOf(Integer.parseInt(temp[k + 3]) + rStockQuantity);
        }

        try
        {
            PrintWriter pr = new PrintWriter(stockFile);

            for (int i=0; i<temp.length ; i++)
            {
                pr.println(temp[i]);
            }
            pr.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("An error occurred.");
        }

    }

    public void removeItem(Integer rStockCode) {
        Integer n = 0;
        Integer found = 0;
        Integer k = null;

        try {
            Scanner reader = new Scanner(stockFile);
            while (reader.hasNextLine()) {
                n = temp.length;
                String[] newTemp = new String[n + 1];

                for (int i=0; i < temp.length; i++)
                {
                    newTemp[i] = temp[i];
                }

                String data = reader.nextLine();
                newTemp[newTemp.length - 1] = data;
                temp = newTemp;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        for (int i=0; i < temp.length; i++)
        {
            if(temp[i].equals(String.valueOf(rStockCode)))
            {
                k = i;
                found++;
                break;
            }
        }
        if(found > 0)
        {
            temp[k] = "";
            temp[k + 1] = "";
            temp[k + 2] = "";
            temp[k + 3] = "";
        }

        try
        {
            PrintWriter pr = new PrintWriter(stockFile);

            for (int i=0; i<temp.length ; i++)
            {
                pr.println(temp[i]);
            }
            pr.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("An error occurred.");
        }

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

    public void addStockItem(String nCode, String nName, String nPrice, String nQuantity) {
        try (FileWriter f = new FileWriter(stockFile, true);
             BufferedWriter b = new BufferedWriter(f);
             PrintWriter p = new PrintWriter(b);) {
            p.println("");
            p.println(nCode);
            p.println(nName);
            p.println(nPrice);
            p.println(nQuantity);

            p.flush();
        } catch
        (IOException i) { i.printStackTrace();
        }

    }

    public ArrayList<String> searchStock(Integer searchCode) {
        ArrayList<String> itemDetails = new ArrayList<>();
        try {
            readStock();
            Integer index = searchCode * 4;
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

            for (int i=0; i < newStock.size() - 3; i++)
            {
                if(newStock.get(i).equals(itemCode))
                {
                    newStock.set(i + 3, String.valueOf(Integer.parseInt(itemQuantity) - 1));
                    break;
                }
                i = i + 3;
            }

            try
            {
                PrintWriter pr = new PrintWriter(stockFile);

                for (int i=0; i<newStock.size() ; i++)
                {
                    pr.println(newStock.get(i));
                }
                pr.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
                System.out.println("An error occurred.");
            }

        } catch (NumberFormatException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return itemDetails;
    }

    public ArrayList<String> checkStock() {
        ArrayList<String> needMoreItems = new ArrayList<>();
        String tempCode;
        String tempName;
        String tempPrice;
        String tempQuantity;
        try {
            readStock();
            for (int i=0; i < newStock.size() - 3; i++)
            {
                tempCode = newStock.get(i);
                tempName = newStock.get(i+1);
                tempPrice = newStock.get(i+2);
                tempQuantity = newStock.get(i+3);
                i = i + 3;
                if(Integer.parseInt(tempQuantity) < 10)
                {
                    needMoreItems.add("Code: " + tempCode);
                    needMoreItems.add("Name: " + tempName);
                    needMoreItems.add("Price: " + tempPrice);
                    needMoreItems.add("Quantity: " + tempQuantity);
                    needMoreItems.add(" ");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return needMoreItems;
    }
}
