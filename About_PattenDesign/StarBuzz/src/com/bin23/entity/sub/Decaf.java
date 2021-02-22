package com.bin23.entity.sub;

import com.bin23.entity.Beverage;

public class Decaf extends Beverage {

    public Decaf() {
        description = "低咖啡因";
    }

    @Override
    public double cost() {
        return 3;
    }
}
