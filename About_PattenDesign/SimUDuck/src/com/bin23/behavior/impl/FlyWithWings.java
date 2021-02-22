package com.bin23.behavior.impl;

import com.bin23.behavior.FlyBehavior;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        //实现鸭子飞行
        System.out.println("鸭子飞行");
    }
}
