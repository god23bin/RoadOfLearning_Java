package com.bin23.entity;

import com.bin23.entity.factory.SimplePizzaFactory;

public class PizzaStore {
    public SimplePizzaFactory simplePizzaFactory;

    public PizzaStore(SimplePizzaFactory simplePizzaFactory){
        this.simplePizzaFactory = simplePizzaFactory;
    }

    public PizzaStore() {

    }

    public Pizza oderPizza(String type){
        Pizza pizza = simplePizzaFactory.createPizza(type);
        System.out.println(pizza.getpName());
        pizza.prepared();
        pizza.bake();
        pizza.cut();
        pizza.box();
        System.out.println(pizza.getpMoney());
        return pizza;
    }
}
