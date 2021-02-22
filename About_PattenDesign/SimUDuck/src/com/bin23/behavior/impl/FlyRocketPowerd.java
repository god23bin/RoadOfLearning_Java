package com.bin23.behavior.impl;

import com.bin23.behavior.FlyBehavior;

public class FlyRocketPowerd implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("使用火箭助推器飞行");
    }
}
