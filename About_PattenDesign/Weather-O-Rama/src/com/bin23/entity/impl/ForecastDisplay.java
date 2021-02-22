package com.bin23.entity.impl;

import com.bin23.entity.DisplayElement;
import com.bin23.so.Observer;
import com.bin23.so.Subject;

public class ForecastDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private float pressure;
    private Subject weatherData;

    public ForecastDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        if(this.temperature > 33){
            System.out.println("天气高温，注意防暑");
        }else if(this.humidity > 80){
            System.out.println("可能会下雨哦~");
        }else{
            System.out.println("正在提供预测中");
        }
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
}
