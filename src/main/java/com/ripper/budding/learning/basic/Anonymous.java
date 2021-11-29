package com.ripper.budding.learning.basic;

/**
 * @Auther:Yingd
 * @Date:2021-11-29
 * @Description:com.ripper.budding.learning.basic
 * @Version:1.0
 **/


public class Anonymous {

    public static void main(String[] args) {
        Outer outer = new Outer("Nested");
        outer.asyncHello();
    }
}
    class Outer {
        private String name;

        Outer(String name) {
            this.name = name;
        }

        void asyncHello() {
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    System.out.println("Hello, " + Outer.this.name);
                }
            };
            new Thread(r).start();
        }
    }

