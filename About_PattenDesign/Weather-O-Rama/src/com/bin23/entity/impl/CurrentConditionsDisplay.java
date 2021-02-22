package com.bin23.entity.impl;

import com.bin23.entity.DisplayElement;
import com.bin23.so.Observer;
import com.bin23.so.Subject;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private Subject weatherData;

    /**
     * 构造方法需要weatherData对象，作为注册之用，还可以以后进行删除
     * @param weatherData
     */
    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("当前情况：温度" + temperature + "℃，湿度" + humidity + "%");
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }
}
