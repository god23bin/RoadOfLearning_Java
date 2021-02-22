package com.bin23.behavior.impl;

import com.bin23.behavior.FlyBehavior;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        //什么都不做
        System.out.println("不会飞~");
    }
}
