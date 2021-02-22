package com.bin23.so.impl;

import com.bin23.so.Observer;
import com.bin23.so.Subject;

import java.util.ArrayList;

public class WeatherData implements Subject {
    //ArrayList来记录观察者
    private ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData(){
        observers = new ArrayList<>();
    }


    /**
     * 注册观察者，加到ArrayList中即可
     * @param o
     */
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    /**
     * 观察者想取消注册，直接从ArrayList中删除
     * @param o
     */
    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if(i>=0) observers.remove(i);
    }

    /**
     * 通知观察者，通过遍历出ArrayList中的观察者，调用update()
     */
    @Override
    public void notifyObservers() {
        for(Observer ob : observers){
            ob.update(temperature,humidity,pressure);
        }
    }

    /**
     * 当从气象站获取新数据时，就会通知观察者
     */
    public void measurementsChanged(){
        notifyObservers();
    }

    /**
     * 通过该方法来假装获取了气象站的数据，实际你自己玩玩而已~
     * @param temperature
     * @param humidity
     * @param pressure
     */
    public void setMeasurements(float temperature,float humidity,float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
