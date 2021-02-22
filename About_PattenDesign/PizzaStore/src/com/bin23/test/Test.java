package com.bin23.test;

import com.bin23.entity.PizzaStore;
import com.bin23.entity.factory.SimplePizzaFactory;

public class Test {
    public static void testSimplePizzaFactory(){
        SimplePizzaFactory simplePizzaFactory = new SimplePizzaFactory();
        PizzaStore pizzaStore = new PizzaStore(simplePizzaFactory);
        pizzaStore.oderPizza("芝士");
        pizzaStore.oderPizza("苹果");
        pizzaStore.oderPizza("香蕉");
    }

    public static void main(String[] args) {
        testSimplePizzaFactory();
    }
}
