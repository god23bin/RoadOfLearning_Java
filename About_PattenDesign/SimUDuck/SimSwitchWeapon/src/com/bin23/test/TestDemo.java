package com.bin23.test;

import com.bin23.behavior.impl.SwordBehavior;
import com.bin23.entity.impl.Knight;

public class TestDemo {

    public static void testSwitchWeapon(){
        Knight knight = new Knight();
        knight.fight();
        knight.setWeaponBehavior(new SwordBehavior());
        knight.fight();
    }

    public static void main(String[] args) {
        testSwitchWeapon();
    }
}
