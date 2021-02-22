package com.bin23.entity;

public class ApplePizza extends Pizza {
    @Override
    public void prepared() {
        super.prepared();
    }

    @Override
    public void bake() {
        super.bake();
    }

    @Override
    public void cut() {
        super.cut();
    }

    @Override
    public void box() {
        super.box();
    }

    public ApplePizza() {
        this.setpName("苹果比萨");
        this.setpMoney("25￥");
    }
}
