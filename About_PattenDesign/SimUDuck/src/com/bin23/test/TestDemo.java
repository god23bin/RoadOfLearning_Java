package com.bin23.test;

import com.bin23.behavior.impl.FlyRocketPowerd;
import com.bin23.behavior.impl.MuteQuack;
import com.bin23.behavior.impl.Quack;
import com.bin23.behavior.impl.Squack;
import com.bin23.entity.Duck;
import com.bin23.entity.DuckCall;
import com.bin23.entity.sub.MallardDuck;
import com.bin23.entity.sub.ModelDuck;

public class TestDemo {
    public static void testDuck(){
        Duck mallardDuck = new MallardDuck();
        mallardDuck.display();
        mallardDuck.performFly();
        mallardDuck.performQuack();
        mallardDuck.performQuack();
        mallardDuck.swim();
    }

    public static void testDuckWithDynamic(){
        Duck modelDuck = new ModelDuck();
        modelDuck.display();
        modelDuck.performFly();
        modelDuck.setFlyBehavior(new FlyRocketPowerd());
        modelDuck.performFly();
    }

    public static void testDuckCall(){
        DuckCall duckCall = new DuckCall();
        duckCall.performQuack(new Quack());
        duckCall.performQuack(new Squack());
        duckCall.performQuack(new MuteQuack());
    }

    public static void main(String[] args) {
        testDuck();
//        testDuckWithDynamic();
//        testDuckCall();
    }
}
