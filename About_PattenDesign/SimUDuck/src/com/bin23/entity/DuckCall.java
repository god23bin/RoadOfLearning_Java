package com.bin23.entity;

import com.bin23.behavior.QuackBehavior;

/**
 * 鸭鸣器，不继承Duck类而实现了鸭叫的行为
 */
public class DuckCall {

    public QuackBehavior quackBehavior;

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void performQuack(QuackBehavior quackBehavior){
        quackBehavior.quack();
    }
}
