package com.ripper.budding.design.createtype;

import com.ripper.budding.design.base.Interface.FoodFactory;
import com.ripper.budding.design.base.model.*;

/**
 * @Auther: yingd [RipperF@hotmail.com]
 * @Date:2022-04-20
 * @Description:com.ripper.budding.designpatterns.createtype
 * @Version:1.0
 **/
public class ChineseFoodFactory implements FoodFactory {
    @Override
    public Food makeFood(String name) {
        if (name.equals("A")) {
            return new ChineseFoodA();
        } else if (name.equals("B")) {
            return new ChineseFoodB();
        } else {
            return null;
        }
    }
}

/**
 * 应该单独创建类
 */
class AmericanFoodFactory implements FoodFactory {
    @Override
    public Food makeFood(String name) {
        if (name.equals("A")) {
            return new AmericanFoodA();
        } else if (name.equals("B")) {
            return new AmericanFoodB();
        } else {
            return null;
        }
    }
}