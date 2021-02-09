package com.bin23.entity;

public class Teacher {
    private int tNo;
    private String tName;

    public int gettNo() {
        return tNo;
    }

    public void settNo(int tNo) {
        this.tNo = tNo;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public Teacher() {

    }

    public Teacher(int tNo, String tName) {
        this.tNo = tNo;
        this.tName = tName;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tNo=" + tNo +
                ", tName='" + tName + '\'' +
                '}';
    }
}
