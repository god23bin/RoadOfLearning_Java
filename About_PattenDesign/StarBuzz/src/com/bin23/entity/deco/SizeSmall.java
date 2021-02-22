package com.bin23.entity.deco;

import com.bin23.entity.Beverage;
import com.bin23.entity.CondimentDecorator;

public class SizeSmall extends CondimentDecorator {
    /**
     * 用一个实例变量记录饮料，也就是被装饰者。
     */
    public Beverage beverage;

    /**
     * 想办法让被装饰者（饮料）被记录到实例变量中。
     * 这里的做法是：
     * 把饮料当作构造器的参数，再由构造器将此饮料记录在实例变量中。
     * @param beverage 被装饰者
     */
    public SizeSmall(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ",小杯";
    }

    @Override
    public double cost() {
        return 0.5 + .20 + beverage.cost();
    }
}
