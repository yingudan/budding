package com.ripper.budding.learning.basic.veight;

import java.util.Optional;

/**
 * @author yingd@jccfc.com
 * @since 2022/3/16 16:36
 **/
public class OptionalTest {

    public static void main(String[] args) {

        OptionalTest optionalTest = new OptionalTest();

        Integer value1 = 3;
        Integer value2 = new Integer(10);

        // Optional.ofNullable - 允许传递为 null 参数
        Optional<Integer> a = Optional.ofNullable(value1);

        // Optional.of - 如果传递的参数是 null，抛出异常 NullPointerException
        Optional<Integer> b = Optional.of(value2);

        System.out.println(optionalTest.sum(a, b));
    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b) {
        // Optional.isPresent - 判断值是否存在
        System.out.println("第一个参数值存在: " + a.isPresent());
        System.out.println("第二个参数值存在: " + b.isPresent());

        //Optional.orElse - 如果值存在，返回它，否则返回默认值
        Integer value1 = a.orElse(new Integer(0));

        Integer value2 = b.get();
        return value1 + value2;
    }

}
