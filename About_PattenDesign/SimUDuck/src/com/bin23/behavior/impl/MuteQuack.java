package com.bin23.behavior.impl;

import com.bin23.behavior.QuackBehavior;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        //什么都不做，不会叫
        System.out.println("不会叫~我很安静");
    }
}
