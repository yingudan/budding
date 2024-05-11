package com.ripper.budding.design.factory.factory;


import com.ripper.budding.design.factory.Nuojiya;
import com.ripper.budding.design.factory.Phone;

/**
 * Created by Ripper on 2018/3/12.
 */
public class NuojiyaFactory implements Factory {
    @Override
    public Phone getPhone() {
        return new Nuojiya();
    }
}
