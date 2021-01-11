package com.model;

public class Items {
    private int itemCode;
    private String itemName;
    private double itemPrice;
    private int itemStock;

    public Items(int newItemCode, String newItemName, double newItemPrice, int newItemStock)
    {
        itemCode = newItemCode;
        itemName = newItemName;
        itemPrice = newItemPrice;
        itemStock = newItemStock;
    }

    public int getItemCode() { return itemCode; }
    public String getItemName() { return itemName; }
    public double getItemPrice() { return itemPrice; }
    public int getItemStock() { return itemStock; }

    public void setItemCode(int inItemCode) { this.itemCode = inItemCode; }
    public void setItemName(String inItemName) { this.itemName = inItemName; }
    public void setItemPrice(double inItemPrice) { this.itemPrice = inItemPrice; }
    public void setItemStock(int inItemStock) { this.itemStock = inItemStock; }
}
