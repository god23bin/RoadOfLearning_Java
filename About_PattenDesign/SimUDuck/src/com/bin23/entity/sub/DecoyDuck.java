package com.bin23.entity.sub;

import com.bin23.entity.Duck;

public class DecoyDuck extends Duck {
//    @Override
//    public void quack() {
//        //什么都不做
//    }

    @Override
    public void display() {
        //外观是诱饵鸭
        System.out.println("我是诱饵鸭~");
    }


}
