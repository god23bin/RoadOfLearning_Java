package com.bin23.behavior.impl;

import com.bin23.behavior.WeaponBehavior;

public class AxeBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.println("使用斧头劈砍！");
    }
}
