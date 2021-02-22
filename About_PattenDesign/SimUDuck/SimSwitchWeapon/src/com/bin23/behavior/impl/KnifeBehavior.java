package com.bin23.behavior.impl;

import com.bin23.behavior.WeaponBehavior;

public class KnifeBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.println("使用小刀刺！");
    }
}
