package com.ripper.budding.design.factory.simple;

/**
 * Created by Ripper on 2018/3/12.
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        SimpleFactory factory = new SimpleFactory();
        System.out.println(factory.getPhone("诺基亚").getName() );
    }
}
