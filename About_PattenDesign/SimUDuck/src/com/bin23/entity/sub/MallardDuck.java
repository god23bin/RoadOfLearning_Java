package com.bin23.entity.sub;

import com.bin23.behavior.impl.FlyWithWings;
import com.bin23.behavior.impl.Quack;
import com.bin23.entity.Duck;

public class MallardDuck extends Duck {
    @Override
    public void display() {
        System.out.println("我是绿头鸭~");
    }

    public MallardDuck(){
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }


}
