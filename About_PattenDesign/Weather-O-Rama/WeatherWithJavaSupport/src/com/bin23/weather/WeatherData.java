package com.bin23.weather;

import java.util.Observable;

@Deprecated
public class WeatherData extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {

    }

    /**
     * 采用拉的方式，观察者可以拉取想要的状态
     */
    public void measurementsChanged(){
        //调用setChanged()表示状态已经改变，然后才调用notifyObservers()来通知观察者
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float temperature,float humidity,float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    //观察者利用getXxx的方式拉取WeatherData对象的状态
    public float getTemperature(){
        return temperature;
    }

    public float getHumidity(){
        return humidity;
    }

    public float getPressure(){
        return pressure;
    }

}
