package com.ripper.budding.design.base.Interface;

import com.ripper.budding.design.base.model.Food;

/**
 * @Auther: yingd [RipperF@hotmail.com]
 * @Date:2022-04-20
 * @Description:com.ripper.budding.designpatterns.Interface
 * @Version:1.0
 **/
public interface FoodFactory {

    Food makeFood(String name);
}
