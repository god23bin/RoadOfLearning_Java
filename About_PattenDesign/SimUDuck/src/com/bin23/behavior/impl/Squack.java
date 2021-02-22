package com.bin23.behavior.impl;

import com.bin23.behavior.QuackBehavior;

public class Squack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("橡皮鸭吱吱叫");
    }
}
