package com.ripper.budding.learning.basic;

/**
 * @Auther:Yingd
 * @Date:2021-11-29
 * @Description:com.ripper.budding.learning.basic
 * @Version:1.0
 **/
public enum WeekDay {

    /**
     * Java使用enum定义枚举类型，它被编译器编译为final class Xxx extends Enum { … }；
     *
     * 通过name()获取常量定义的字符串，注意不要使用toString()；
     *
     * 通过ordinal()返回常量定义的顺序（无实质意义）；
     *
     * 可以为enum编写构造方法、字段和方法
     *
     * enum的构造方法要声明为private，字段强烈建议声明为final；
     *
     * enum适合用在switch语句中。
     */

    SUN, MON, TUE, WED, THU, FRI, SAT;

}
