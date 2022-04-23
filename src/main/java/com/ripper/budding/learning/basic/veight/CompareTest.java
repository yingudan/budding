package com.ripper.budding.learning.basic.veight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author yingd@jccfc.com
 * @since 2022/3/17 9:20
 **/
public class CompareTest {

    public static void main(String[] args) {
        // normalTest();
        // lowerString();
        // countNum();
        // convertTest();
        // reduceStream();
        UserStreamDemo();
    }


    public static void normalTest() {
        List<String> names = Arrays.asList("z", "c", "p", "a");
        Collections.sort(names, ((o1, o2) -> o1.compareTo(o2)));
        System.out.println("names>>" + names);

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        //上面两段代码分别是：使用lambda表达式来排序和使用匿名内部类来排序。这个例子可以很明显的看出lambda表达式简化代码的效果
    }

    public static void lowerString() {
        List<String> names = Arrays.asList("TianQing", "ZHAOziLong");
        List<String> lowercaseNames = names.stream()
            .map(s -> s.toLowerCase())
            .collect(Collectors.toList());
        System.out.println(lowercaseNames);
        //注意代码第四行的map方法调用，这里map方法就是接受了一个lambda表达式（其实是一个java.util.function.Function的实例，后面会介绍）。

        List<String> lowerCaseNames = names.stream()
            .map(String::toLowerCase)
            .collect(Collectors.toList());

    }

    /**
     * 使用Stream
     */
    public static void countNum() {
        List<Integer> nums = Arrays.asList(1, null, 3, null, 7);
        long count = nums.stream() //创建Stream
            .filter(i -> i != null)//转换Stream
            .count();//聚合
        System.out.println("count>>" + count);
    }

    /**
     * 转换Stream
     */
    public static void convertTest() {
        List<Integer> nums = Arrays.asList(1, 4, 7, null, 9, 5, null, 3, 7, 1, null);
        int sum = nums.stream()
            .filter(num -> num != null)
            .distinct()
            .mapToInt(num -> num * 2)
            .peek(System.out::println)
            .skip(2)
            .limit(4)
            .sum();
        System.out.println("sum is:" + nums.stream()
            .filter(num -> num != null)
            .distinct()
            .mapToInt(num -> num * 2)
            .peek(System.out::println)
            .skip(2)
            .limit(4)
            .sum());
        /**
         *这段代码演示了上面介绍的所有转换方法（除了flatMap），简单解释一下这段代码的含义：给定一个Integer类型的List，获取其对应的Stream对象，然后进行过滤掉null，
         * 再去重，再每个元素乘以2，再每个元素被消费的时候打印自身，在跳过前两个元素，
         * 最后去前四个元素进行加和运算(解释一大堆，很像废话，因为基本看了方法名就知道要做什么了。这个就是声明式编程的一大好处！)。
         * 大家可以参考上面对于每个方法的解释，看看最终的输出是什么。
         */
        // 2  8  14  18 10 6 >>>48
        /**
         * 性能问题
         * 在对于一个Stream进行多次转换操作，每次都对Stream的每个元素进行转换，而且是执行多次，这样时间复杂度就是一个for循环里把所有操作都做掉的N（转换的次数）倍啊。
         * 其实不是这样的，转换操作都是lazy的，多个转换操作只会在汇聚操作（见下节）的时候融合起来，一次循环完成。
         * 我们可以这样简单的理解，Stream里有个操作函数的集合，每次转换操作就是把转换函数放入这个集合中，
         * 在汇聚操作的时候循环Stream对应的集合，然后对每个元素执行所有的函数。
         */
    }

    /**
     * 汇聚 Stream
     * 汇聚操作（也称为折叠）接受一个元素序列为输入，反复使用某个合并操作，把序列中的元素合并成一个汇总的结果。
     * Stream接口有一些通用的汇聚操作，比如reduce()和collect()；也有一些特定用途的汇聚操作，比如sum(),max()和count()。
     * sum方法不是所有的Stream对象都有的，只有IntStream、LongStream和DoubleStream是实例才有
     */
    public static void reduceStream() {
        //可变汇聚
        List<Integer> nums = Arrays.asList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);
        List<Integer> sumsWithoutNull = nums.stream()
            .filter(integer -> integer != null)
            // .collect(() -> new ArrayList<Integer>(), (list, item) -> list.add(item),
            //     (list1, list2) -> list1.addAll(list2));
            .collect(Collectors.toList());
        System.out.println("sumsWithoutNull>>>" + sumsWithoutNull);
        //其他汇聚

        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);




        System.out.println("ints sum is：" + ints.stream()
            .reduce(0, (sum, item) -> sum + item));

    }

    /**
     * 用户流信息demo
     */
    public static void UserStreamDemo(){
        List<UserInfo> userInfoList =new ArrayList<>();
        userInfoList.add( UserInfo.builder().age(10).name("小雨").status("0").build());
        userInfoList.add( UserInfo.builder().age(20).name("大明").status("1").build());
        userInfoList.add( UserInfo.builder().age(15).name("西蒙").status("1").build());
        userInfoList.add( UserInfo.builder().age(23).name("理塘丁真").status("0").build());
        userInfoList.add( UserInfo.builder().age(17).name("武藤游戏").status("1").build());

        Map<String,UserInfo> userInfoMap = userInfoList.stream().collect(Collectors.toMap(UserInfo::getName, Function.identity(),(v1,v2)->v1));

        System.out.println(userInfoMap);
    }




}
