package com.bin23.so;

/**
 * 所有的观察者都必须实现观察者接口，即此接口
 * 然后实现update()方法
 */
public interface Observer {
    //当气象观测值改变时，主题会把这些状态值当作方法的参数传递给观察者
    public void update(float temperature,float humidity,float pressure);
}
