package com.bin23.entity;

public abstract class Beverage {
    public String description = "不知道的饮料";
    public String size = "不知道的大小";

    public String getDescription() {
        return description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public abstract double cost();
}
