package com.ripper.budding.learning.basic;


import java.util.StringJoiner;

/**
 * @Auther:Yingd
 * @Date:2021-11-29
 * @Description:com.ripper.budding.learning.basic
 * @Version:1.0 Java字符串String是不可变对象；
 * 字符串操作不改变原字符串内容，而是返回新字符串；
 * 常用的字符串操作：提取子串、查找、替换、大小写转换等；
 * Java使用Unicode编码表示String和char；
 * 转换编码就是将String和byte[]转换，需要指定编码；
 * 转换为byte[]时，始终优先考虑UTF-8编码。
 **/
public class StringDemo {

    public static void main(String[] args) {
//        toUpperCase();
//        eqString();
//        fmtString();
//        joinString();
//        adderTest();
        hightFixString();
    }

    public static void demo() {
        String s1 = "Hello!";
        //实际上字符串在String内部是通过一个char[]数组表示的，因此，按下面的写法也是可以的：
        String s2 = new String(new char[]{'H', 'e', 'l', 'l', 'o', '!'});
/*
        因为String太常用了，所以Java提供了"..."这种字符串字面量表示方法。
        Java字符串的一个重要特点就是字符串不可变。这种不可变性是通过内部的private final char[]字段，以及没有任何修改char[]的方法实现的。
*/
    }

    /**
     * @depiction
     * @author：ripper [RipperF@hotmail.com]
     * @date:2021-11-29
     */
    
    public static void toUpperCase() {
        String s = "Hello";
        System.out.println(s);
        s = s.toUpperCase();
        System.out.println(s);
    }

    /**
     * @depiction
     * @author：ripper [RipperF@hotmail.com]
     * @date:2021-11-29
     */
    
    public static void eqString() {
        String s1 = "demo";
        String s2 = "DEMO".toLowerCase();
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }

    /**
     * %s：显示字符串
     * %d：显示整数
     * %x：显示十六进制整数
     * %f：显示浮点数
     * %.2f 表示显示两位小数
     * 如果你不确定用啥占位符，那就始终用%s，因为%s可以显示任何数据类型。要查看完整的格式化语法，请参考JDK文档。
     *
     * @see https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Formatter.html#syntax
     */
    public static void fmtString() {
        String s = "Hi %s,your score is %d!";
        System.out.println(String.format("Hi %s, your score is %.2f!", "Bob", 52.5));
    }


    /**
     * 还可以进行链式操作
     */
    public static void joinString() {
        StringBuilder sb = new StringBuilder(1024);
        sb.append("Mr ")
                .append("Bob")
                .append("!")
                .insert(0, "Hello, ");
        System.out.println(sb.toString());
    }

    /**
     * 如果我们查看StringBuilder的源码，可以发现，进行链式操作的关键是，定义的append()方法会返回this，这样，就可以不断调用自身的其他方法。
     * 仿照StringBuilder，我们也可以设计支持链式操作的类。例如，一个可以不断增加的计数器：
     */
    public static void adderTest(){
        Adder adder = new Adder();
        adder.add(3)
                .add(5)
                .inc()
                .add(10);
        System.out.println(adder.value());
    }


    /**
     * 要高效拼接字符串，应该使用StringBuilder。
     * 类似用分隔符拼接数组的需求很常见，所以Java标准库还提供了一个StringJoiner来干这个事：
     */
    public static  void hightFixString(){
//        String[] names = {"Bob", "Alice", "Grace"};
//        StringJoiner sj = new StringJoiner(", ");
//        for (String name : names) {
//            sj.add(name);
//        }
//        System.out.println(sj.toString());
    }

}
class Adder{
    private int sum = 0;
    public Adder add(int n) {
        sum += n;
        return this;
    }

    public Adder inc() {
        sum ++;
        return this;
    }

    public int value() {
        return sum;
    }

}