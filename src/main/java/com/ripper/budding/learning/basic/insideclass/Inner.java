package com.ripper.budding.learning.basic.insideclass;

/**
 * @Auther: yingd [RipperF@hotmail.com]
 * @Date:2021-12-05
 * @Description:com.ripper.budding.learning.basic.insideclass
 * @Version:1.0
 **/


public class Inner {

    public static void main(String[] args) {
        InnerOuter outer = new InnerOuter("Nested"); // 实例化一个Outer
        InnerOuter.Inner inner = outer.new Inner(); // 实例化一个Inner
        inner.hello();
    }
}

/**
 * 这是因为Inner Class除了有一个this指向它自己，还隐含地持有一个Outer Class实例，可以用Outer.this访问这个实例。所以，实例化一个Inner Class不能脱离Outer实例。
 * Inner Class和普通Class相比，除了能引用Outer实例外，还有一个额外的“特权”，就是可以修改Outer Class的private字段，
 * 因为Inner Class的作用域在Outer Class内部，所以能访问Outer Class的private字段和方法。
 * 观察Java编译器编译后的.class文件可以发现，Outer类被编译为Outer.class，而Inner类被编译为Outer$Inner.class。
 */
class InnerOuter {
    private String name;

    InnerOuter(String name) {
        this.name = name;
    }

    class Inner {
        void hello() {
            System.out.println("Hello, " + InnerOuter.this.name);
        }
    }
}
