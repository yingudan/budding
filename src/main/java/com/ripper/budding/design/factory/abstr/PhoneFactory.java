package com.ripper.budding.design.factory.abstr;


import com.ripper.budding.design.factory.Huawei;
import com.ripper.budding.design.factory.Phone;

/**
 * Created by Ripper on 2018/3/12.
 */
public class PhoneFactory extends   AbstractFactory {
    @Override
    public Phone getHuaweiPhone() {
        return new Huawei();
    }

    @Override
    public Phone getNuojiyaPhone() {
        return null;
    }

    @Override
    public Phone getIphone() {
        return null;
    }
}
