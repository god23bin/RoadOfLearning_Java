package com.bin23.so;

public interface Subject {
    //注册观察者
    public void registerObserver(Observer o);
    //删除观察者
    public void removeObserver(Observer o);
    //当主题状态改变时，该方法被调用，以通知所有观察者
    public void notifyObservers();
}
