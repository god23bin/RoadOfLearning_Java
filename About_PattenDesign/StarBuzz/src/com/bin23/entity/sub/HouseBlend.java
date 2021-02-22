package com.bin23.entity.sub;

import com.bin23.entity.Beverage;

public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "家常咖啡";
    }

    @Override
    public double cost() {
        return 5;
    }
}
