package com.ripper.budding.learning.basic.veight;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.ripper.budding.utils.StringUtils;

/**
 * @author yingd@jccfc.com
 * @since 2022/3/16 14:46
 * 什么是 Stream？
 * 元素是特定类型的对象，形成一个队列。 Java中的Stream并不会存储元素，而是按需计算。
 * 数据源 流的来源。 可以是集合，数组，I/O channel， 产生器generator 等。
 * 聚合操作 类似SQL语句一样的操作， 比如filter, map, reduce, find, match, sorted等。
 **/
public class StreamTest {

    public static void main(String[] args) {
        // create();
        // forEachDemo();
        // mapTest();
        // filterTest();

        collectorsTest();
    }

    /**
     * 生成流
     * 集合接口有两个方法来生成流：
     * stream() − 为集合创建串行流。
     * parallelStream() − 为集合创建并行流。
     */
    public static void create() {

        List<String> strings = Arrays.asList("a", "ab", "abc", "efg", "jkl", "", "dd");
        List<String> filtered = strings.stream()
            .filter(s -> !StringUtils.isEmpty(s))
            .collect(Collectors.toList());
        System.out.println(filtered);
    }

    /**
     * Stream 提供了新的方法 'forEach' 来迭代流中的每个数据。以下代码片段使用 forEach 输出了10个随机数：
     */
    public static void forEachDemo() {
        Random random = new Random();
        random.ints()
            .limit(10)
            .forEach(System.out::println);
    }

    /**
     * map 方法用于映射每个元素到对应的结果，以下代码片段使用 map 输出了元素对应的平方数：
     */
    public static void mapTest() {
        List<Integer> numbers = Arrays.asList(3, 2, 4, 3, 5);
        List<Integer> squaresList = numbers.stream()
            .map(i -> i * i)
            .distinct()
            .collect(Collectors.toList());
        System.out.println("squaresList>>" + squaresList);
    }

    /**
     * filter 方法用于通过设置的条件过滤出元素。以下代码片段使用 filter 方法过滤出空字符串：
     */
    public static void filterTest() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "opq", "", "jkl");
        //获取空字符串数量
        long count = strings.stream()
            .filter(str -> str.isEmpty())
            .count();
        System.out.println("count>>" + count);
    }

    /**
     * limit 方法用于获取指定数量的流。 以下代码片段使用 limit 方法打印出 10 条数据：
     */
    public static void limitTest() {
        Random random = new Random();
        random.ints()
            .limit(10)
            .forEach(System.out::println);
    }

    /**
     * sorted 方法用于对流进行排序。以下代码片段使用 sorted 方法对输出的 10 个随机数进行排序
     */
    public static void sortedTest() {
        Random random = new Random();
        random.ints()
            .limit(10)
            .sorted()
            .forEach(System.out::println);
    }

    /**
     * parallelStream 是流并行处理程序的代替方法。以下实例我们使用 parallelStream 来输出空字符串的数量：
     */
    public static void parallelTest() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "opg", "", "jkl");
        long count = strings.parallelStream()
            .filter(str -> str.isEmpty())
            .count();
        System.out.println("parallel>>count>>" + count);
    }

    /**
     * Collectors 类实现了很多归约操作，例如将流转换成集合和聚合元素。Collectors 可用于返回列表或字符串：
     */
    public static void collectorsTest() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "opq", "", "jkl");
        List<String> filtered = strings.stream()
            .filter(str -> !str.isEmpty())
            .collect(Collectors.toList());
        System.out.println("筛选列表: " + filtered);
        String mergedString = strings.stream()
            .filter(str -> !str.isEmpty())
            .collect(Collectors.joining(","));
        System.out.println("合并字符串: " + mergedString);
    }

}
