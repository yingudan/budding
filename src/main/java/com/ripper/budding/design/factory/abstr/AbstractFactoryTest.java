package com.ripper.budding.design.factory.abstr;

/**
 * Created by Ripper on 2018/3/12.
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {

        PhoneFactory phonefactory = new PhoneFactory();
        System.out.println( phonefactory.getHuaweiPhone());
    }
}
