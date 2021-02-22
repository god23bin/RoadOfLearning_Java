package com.bin23.entity.factory;

import com.bin23.entity.ApplePizza;
import com.bin23.entity.BananaPizza;
import com.bin23.entity.CheesePizza;
import com.bin23.entity.Pizza;

public class SimplePizzaFactory {

    public Pizza createPizza(String type){
        Pizza pizza = null;
        if(type.equals("芝士")){
            pizza = new CheesePizza();
        }else if(type.equals("苹果")){
            pizza = new ApplePizza();
        }else if(type.equals("香蕉")){
            pizza = new BananaPizza();
        }
        return pizza;
    }
}
