package com.bin23.entity.impl;

import com.bin23.behavior.WeaponBehavior;
import com.bin23.behavior.impl.BowAndArrowBehavior;
import com.bin23.entity.Character;

public class Knight extends Character {

    public Knight(){
        weaponBehavior = new BowAndArrowBehavior();
    }

    @Override
    public void fight() {
        weaponBehavior.useWeapon();
    }
}
