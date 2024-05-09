package com.ripper.budding.design.createtype;

import com.ripper.budding.design.base.model.Food;

/**
 * @Auther: yingd [RipperF@hotmail.com]
 * @Date:2022-04-20
 * @Description:com.ripper.budding.designpatterns.createtype
 * @Version:1.0
 **/


public class App {
    public static void main(String[] args) {
        // 先选择一个具体的工厂
        com.ripper.budding.design.base.Interface.FoodFactory factory = new ChineseFoodFactory();
        // 由第一步的工厂产生具体的对象，不同的工厂造出不一样的对象
        Food food = factory.makeFood("A");
    }
}
