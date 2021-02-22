package com.bin23.entity;

public class BananaPizza extends Pizza {
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

    public BananaPizza() {
        this.setpName("香蕉比萨");
        this.setpMoney("28￥");
    }
}
