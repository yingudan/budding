package com.ripper.budding.learning.basic.veight;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 函数式接口实例
 * Predicate <T> 接口是一个函数式接口，它接受一个输入参数 T，返回一个布尔值结果。
 * 该接口包含多种默认方法来将Predicate组合成其他复杂的逻辑（比如：与，或，非）。
 * 该接口用于测试对象是 true 或 false。
 * 我们可以通过以下实例（Java8Tester.java）来了解函数式接口 Predicate <T> 的使用：
 *
 * @author yingd@jccfc.com
 * @since 2022/3/16 11:11
 **/
public class PredicateTest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println("输出所有数：");
        eval(list, n -> true);
        System.out.println("输出所有偶数：");
        eval(list, n -> n % 2 == 0);
        System.out.println("输出所有>3的数");
        eval(list, n -> n > 3);
    }

    public static void eval(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer n : list) {
            if (predicate.test(n)) {
                System.out.println(n + "");
            }
        }
    }

}
