package com.ripper.budding.design.factory.factory;


import com.ripper.budding.design.factory.Huawei;
import com.ripper.budding.design.factory.Phone;

/**
 * Created by Ripper on 2018/3/12.
 */
public class HuaweiFactory implements Factory{
    @Override
    public Phone getPhone() {
        return new Huawei();
    }
}
