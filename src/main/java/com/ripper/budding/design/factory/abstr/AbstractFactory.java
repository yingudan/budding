package com.ripper.budding.design.factory.abstr;


import com.ripper.budding.design.factory.Phone;

/**
 * Created by Ripper on 2018/3/12.
 */
public abstract class AbstractFactory  {

    public abstract Phone getHuaweiPhone();


    public abstract Phone getNuojiyaPhone();

    public abstract  Phone getIphone();
}
