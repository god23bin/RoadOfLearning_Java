package com.bin23.entity.impl;

import com.bin23.entity.DisplayElement;
import com.bin23.weather.WeatherData;

import java.util.Observable;
import java.util.Observer;

@Deprecated
public class ForecastDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private float pressure;
    Observable observable;

    public ForecastDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
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
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherData){
            WeatherData weatherData = (WeatherData)o;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            this.pressure = weatherData.getPressure();
            display();
        }
    }
}
