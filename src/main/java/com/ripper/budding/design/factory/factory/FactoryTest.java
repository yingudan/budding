package com.ripper.budding.design.factory.factory;

/**
 * Created by Ripper on 2018/3/12.
 */
public class FactoryTest {

    public static void main(String[] args) {
        HuaweiFactory huaweiFactory = new HuaweiFactory();
        System.out.println(huaweiFactory.getPhone().getName());
    }
}
