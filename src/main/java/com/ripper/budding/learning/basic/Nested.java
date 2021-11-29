package com.ripper.budding.learning.basic;

/**
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
