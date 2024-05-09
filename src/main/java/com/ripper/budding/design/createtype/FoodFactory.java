package com.ripper.budding.design.createtype;

import com.ripper.budding.design.base.model.Food;
import com.ripper.budding.design.base.model.HuangMenChicken;
import com.ripper.budding.design.base.model.NeiJiangNoodle;

/**
 * 工厂模式
 *
 * @Auther: yingd [RipperF@hotmail.com]
 * @Date:2022-04-20
 * @Description:com.ripper.budding.designpatterns.createtype
 * @Version:1.0
 **/
public class FoodFactory {

    /**
     * @param foodName
     * @return
     */
    public static Food makeFood(String foodName) {
        if (foodName.equals("noodle")) {
            Food noodle = new NeiJiangNoodle();
            noodle.setSpicy("more");
            return noodle;
        } else if (foodName.equals("chicken")) {
            Food chicken = new HuangMenChicken();
            chicken.setCondiment("potato");
            return chicken;
        } else {
            return null;
        }

    }

}
