package com.ripper.budding.learning.basic.insideclass;

/**
 * 内部类
 *
 * @Auther:Yingd
 * @Date:2021-11-29
 * @Description:com.ripper.budding.learning.basic
 * @Version:1.0
 **/
public class Nested {
    public static void main(String[] args) {
        Demo.StaticNested sn = new Demo.StaticNested();
        sn.hello();
    }
}

/**
 * 最后一种内部类和Inner Class类似，但是使用static修饰，称为静态内部类（Static Nested Class）：
 * 用static修饰的内部类和Inner Class有很大的不同，它不再依附于Outer的实例，而是一个完全独立的类，
 * 因此无法引用Outer.this，但它可以访问Outer的private静态字段和静态方法。如果把StaticNested移到Outer之外，就失去了访问private的权限。
 */
class Demo {
    private static String NAME = "OUTER";
    private String name;

    Demo(String name) {
        this.name = name;
    }

    static class StaticNested {
        void hello() {
            System.out.println("Hello, " + Demo.NAME);
        }
    }
}
