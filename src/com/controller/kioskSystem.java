package com.controller;

import com.model.stockDatabase;

import java.util.ArrayList;

public class kioskSystem {
    public void setUpStock() {
        stockDatabase stockControl = new stockDatabase();
        stockControl.readStock();
    }
}
