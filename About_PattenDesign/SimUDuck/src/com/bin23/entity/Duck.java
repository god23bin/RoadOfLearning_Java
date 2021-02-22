package com.bin23.entity;

import com.bin23.behavior.FlyBehavior;
import com.bin23.behavior.QuackBehavior;

public abstract class Duck {

    /**
     * 把行为抽取出来，加入两个成员变量，接口类型的
     */
    public FlyBehavior flyBehavior;
    public QuackBehavior quackBehavior;
/*
    public void quack(){
        System.out.println("鸭子呱呱叫");
    }
*/
    public void swim(){
        System.out.println("鸭子游泳");
    }

    public void performFly(){
        flyBehavior.fly();
    }

    public void performQuack(){
        quackBehavior.quack();
    }

    public abstract void display();

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
