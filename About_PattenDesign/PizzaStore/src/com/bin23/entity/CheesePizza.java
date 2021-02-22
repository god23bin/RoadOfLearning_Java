package com.bin23.entity;

public class CheesePizza extends Pizza {
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

    public CheesePizza() {
        this.setpName("芝士比萨");
        this.setpMoney("30￥");
    }
}
