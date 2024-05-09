package com.ripper.budding.design.createtype;

import com.ripper.budding.design.base.model.Food;
import com.ripper.budding.design.base.model.HuangMenChicken;
import com.ripper.budding.design.base.model.NeiJiangNoodle;

/**
 * 简单工厂模式
 *
 * @Auther: yingd [RipperF@hotmail.com]
 * @Date:2022-04-21
 * @Description:com.ripper.budding.designpatterns.createtype
 * @Version:1.0
 **/


public class EasyFoodFactory {

    public static Food makeFood(String name) {
        if (name.equals("noodle")) {
            Food noodle = new NeiJiangNoodle();
            noodle.addSpicy("more");
            return noodle;
        } else if (name.equals("chicken")) {
            Food chicken = new HuangMenChicken();
            chicken.addCondiment("potato");
            return chicken;
        } else {
            return null;
        }
    }


}
