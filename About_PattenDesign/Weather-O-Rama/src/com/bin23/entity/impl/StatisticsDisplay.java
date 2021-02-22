package com.bin23.entity.impl;

import com.bin23.entity.DisplayElement;
import com.bin23.so.Observer;
import com.bin23.so.Subject;

import java.util.Random;

public class StatisticsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private float pressure;
    private Subject weatherData;

    public StatisticsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("统计数据：平均温度" + temperature + "℃，平均湿度" + humidity + "%");
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature/2+10;
        this.humidity = humidity/2+42;
        this.pressure = pressure;
        display();
    }
}
