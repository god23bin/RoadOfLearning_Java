package com.bin23.test;

import com.bin23.entity.impl.CurrentConditionsDisplay;
import com.bin23.entity.impl.ForecastDisplay;
import com.bin23.entity.impl.StatisticsDisplay;
import com.bin23.so.impl.WeatherData;

public class TestDemo {
    public static void testWeatherStation(){
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay ccd = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay sd = new StatisticsDisplay(weatherData);
        ForecastDisplay fd = new ForecastDisplay(weatherData);

        weatherData.setMeasurements(32.3f,75,30.4f);
        weatherData.setMeasurements(30.2f,81,29.2f);
        weatherData.setMeasurements(35.8f,78,31.5f);
    }

    public static void main(String[] args) {
        testWeatherStation();
    }
}
