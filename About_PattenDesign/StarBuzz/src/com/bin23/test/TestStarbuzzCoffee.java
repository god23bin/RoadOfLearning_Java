package com.bin23.test;

import com.bin23.entity.Beverage;
import com.bin23.entity.deco.*;
import com.bin23.entity.sub.DarkRoast;
import com.bin23.entity.sub.Espresso;
import com.bin23.entity.sub.HouseBlend;

public class TestStarbuzzCoffee {

    public static void testCoffee(){
        Beverage espresso = new Espresso();
        System.out.println(espresso.getDescription() + " ￥" + espresso.cost());

        Beverage darkRoast = new DarkRoast();
        darkRoast = new Mocha(darkRoast);
        darkRoast = new Mocha(darkRoast);
        darkRoast = new Whip(darkRoast);
        System.out.println(darkRoast.getDescription() + " ￥" + darkRoast.cost());

        Beverage houseBlend = new HouseBlend();
        houseBlend = new Soy(houseBlend);
        houseBlend = new Mocha(houseBlend);
        houseBlend = new Whip(houseBlend);
        System.out.println(houseBlend.getDescription() + " ￥" + houseBlend.cost());
    }

    public static void testSize(){
        Beverage espresso = new Espresso();
        espresso = new SizeBig(espresso);
        System.out.println(espresso.getDescription() + " ￥" + espresso.cost());

        Beverage darkRoast = new DarkRoast();
        darkRoast = new Mocha(darkRoast);
        darkRoast = new Mocha(darkRoast);
        darkRoast = new Whip(darkRoast);
        darkRoast = new SizeMid(darkRoast);
        System.out.println(darkRoast.getDescription() + " ￥" + darkRoast.cost());

        Beverage houseBlend = new HouseBlend();
        houseBlend = new Soy(houseBlend);
        houseBlend = new Mocha(houseBlend);
        houseBlend = new Whip(houseBlend);
        houseBlend = new SizeSmall(houseBlend);
        System.out.println(houseBlend.getDescription() + " ￥" + houseBlend.cost());
    }

    public static void main(String args[]) {
//        testCoffee();
        testSize();
    }

}
