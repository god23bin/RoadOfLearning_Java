package com.bin23.entity;

import java.util.*;

public class AllTypeCollection {
    private List<String> listElem;
    private Set<String> setElem;
    private Map<String,String> mapElem;
    private String[] arrayElem;
    private Properties propsElement;

    public List<String> getListElem() {
        return listElem;
    }

    public void setListElem(List<String> listElem) {
        this.listElem = listElem;
    }

    public Set<String> getSetElem() {
        return setElem;
    }

    public void setSetElem(Set<String> setElem) {
        this.setElem = setElem;
    }

    public Map<String, String> getMapElem() {
        return mapElem;
    }

    public void setMapElem(Map<String, String> mapElem) {
        this.mapElem = mapElem;
    }

    public String[] getArrayElem() {
        return arrayElem;
    }

    public void setArrayElem(String[] arrayElem) {
        this.arrayElem = arrayElem;
    }

    public Properties getPropsElement() {
        return propsElement;
    }

    public void setPropsElement(Properties propsElement) {
        this.propsElement = propsElement;
    }

    public AllTypeCollection() {

    }

    public AllTypeCollection(List<String> listElem, Set<String> setElem, Map<String, String> mapElem, String[] arrayElem, Properties propsElement) {
        this.listElem = listElem;
        this.setElem = setElem;
        this.mapElem = mapElem;
        this.arrayElem = arrayElem;
        this.propsElement = propsElement;
    }

    @Override
    public String toString() {
        return "AllTypeCollection{" +
                "listElem=" + listElem +
                ", setElem=" + setElem +
                ", mapElem=" + mapElem +
                ", arrayElem=" + Arrays.toString(arrayElem) +
                ", propsElement=" + propsElement +
                '}';
    }
}
