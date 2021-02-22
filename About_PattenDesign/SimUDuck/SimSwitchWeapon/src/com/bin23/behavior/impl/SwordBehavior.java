package com.bin23.behavior.impl;

import com.bin23.behavior.WeaponBehavior;

public class SwordBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.println("使用宝剑挥舞！");
    }
}
