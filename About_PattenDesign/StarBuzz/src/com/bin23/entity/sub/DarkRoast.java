package com.bin23.entity.sub;

import com.bin23.entity.Beverage;

public class DarkRoast extends Beverage {

    public DarkRoast() {
        description = "焦炒咖啡";
    }

    @Override
    public double cost() {
        return 9;
    }
}
