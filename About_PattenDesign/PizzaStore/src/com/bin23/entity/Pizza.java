package com.bin23.entity;

public class Pizza {
    private String pName;
    private String pMoney;

    public void prepared(){
        System.out.println("擀面皮，加佐料");
    }

    public void bake(){
        System.out.println("烘烤");
    }

    public void cut(){
        System.out.println("切片");
    }

    public void box(){
        System.out.println("装盒");
    }

    public Pizza() {
    }

    public Pizza(String pName, String pMoney) {
        this.pName = pName;
        this.pMoney = pMoney;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpMoney() {
        return pMoney;
    }

    public void setpMoney(String pMoney) {
        this.pMoney = pMoney;
    }
}
