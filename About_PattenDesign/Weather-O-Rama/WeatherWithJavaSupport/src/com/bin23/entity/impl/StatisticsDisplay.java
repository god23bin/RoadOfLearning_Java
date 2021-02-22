package com.bin23.entity.impl;

import com.bin23.entity.DisplayElement;
import com.bin23.weather.WeatherData;

import java.util.Observable;
import java.util.Observer;

@Deprecated
public class StatisticsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private float pressure;
    Observable observable;

    public StatisticsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("统计数据：平均温度" + temperature + "℃，平均湿度" + humidity + "%");
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherData){
            WeatherData weatherData = (WeatherData)o;
            this.temperature = weatherData.getTemperature()/2+10;
            this.humidity = weatherData.getHumidity()/2+42;
            this.pressure = weatherData.getPressure();
            display();
        }
    }
}
