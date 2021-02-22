package com.bin23.entity.sub;

import com.bin23.behavior.FlyBehavior;
import com.bin23.behavior.QuackBehavior;
import com.bin23.behavior.impl.FlyWithWings;
import com.bin23.behavior.impl.Quack;
import com.bin23.entity.Duck;

public class ModelDuck extends Duck {

    public ModelDuck(){
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("我是模型鸭~");
    }

}
