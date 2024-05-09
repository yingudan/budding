package com.ripper.budding.design.base.model;

import lombok.Data;

/**
 * @Auther: yingd [RipperF@hotmail.com]
 * @Date:2022-04-20
 * @Description:com.ripper.budding.designpatterns.modle
 * @Version:1.0
 **/

@Data
public class Food {

    private String spicy;

    private String condiment;

    public void addSpicy(String spicy) {
        this.spicy = spicy;
    }

    public void addCondiment(String condiment) {
        this.condiment = condiment;
    }

}
