package com.bin23.entity.impl;

import com.bin23.entity.DisplayElement;
import com.bin23.weather.WeatherData;

import java.util.Observable;
import java.util.Observer;

@Deprecated
public class CurrentConditionsDisplay implements Observer , DisplayElement {
    private float temperature;
    private float humidity;
    Observable observable;

    public CurrentConditionsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("当前情况：温度" + temperature + "℃，湿度" + humidity + "%");
    }

    /**
     * 先确定可观察者属于WeatherData类型，然后利用 getter方法
     * 获取温度和湿度测量值
     * 最后调用display()
     * @param o 可观察者，主题
     * @param arg 数据对象
     */
    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherData){
            WeatherData weatherData = (WeatherData)o;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }
}
