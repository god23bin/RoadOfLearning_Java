package com.bin23.entity.sub;

import com.bin23.entity.Beverage;

public class Espresso extends Beverage {

    public Espresso() {
        description = "浓缩咖啡";
    }

    @Override
    public double cost() {
        return 7.5;
    }
}
