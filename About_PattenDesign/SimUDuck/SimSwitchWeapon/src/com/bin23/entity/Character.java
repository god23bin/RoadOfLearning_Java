package com.bin23.entity;

import com.bin23.behavior.WeaponBehavior;

public abstract class Character {

    public WeaponBehavior weaponBehavior;

    public void setWeaponBehavior(WeaponBehavior weaponBehavior) {
        this.weaponBehavior = weaponBehavior;
    }

    public abstract void fight();


}
