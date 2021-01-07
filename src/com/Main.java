package com;

import com.view.*;
import com.controller.*;

public class Main {
    public static void main(String[] args) {
        KioskDisplay page = new KioskDisplay();
        kioskSystem setUp = new kioskSystem();
        setUp.setUpStock();
        page.setVisible(true);
    }
}
