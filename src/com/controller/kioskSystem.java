package com.controller;

import com.model.stockDatabase;

public class kioskSystem {
    public void setUpStock() {
        stockDatabase stockControl = new stockDatabase();
        stockControl.readStock();
    }
}
