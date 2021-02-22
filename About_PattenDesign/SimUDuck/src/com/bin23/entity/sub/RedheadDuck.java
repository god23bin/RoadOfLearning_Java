package com.bin23.entity.sub;

import com.bin23.entity.Duck;

public class RedheadDuck extends Duck {
    @Override
    public void display() {
        //外观是红头
        System.out.println("我是红头鸭");
    }
}
