package com.ripper.budding.learning.basic.insideclass;

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

/**
 * 还有一种定义Inner Class的方法，它不需要在Outer Class中明确地定义这个Class，
 * 而是在方法内部，通过匿名类（Anonymous Class）来定义。示例代码如下：
 */
class Outer {
    private String name;

    Outer(String name) {
        this.name = name;
    }

    void asyncHello() {
        Runnable r = new Runnable() {
            public void run() {
                System.out.println("Hello, " + Outer.this.name);
            }
        };
        new Thread(r).start();
    }
}

/**
 * 观察asyncHello()方法，我们在方法内部实例化了一个Runnable。Runnable本身是接口，接口是不能实例化的，
 * 所以这里实际上是定义了一个实现了Runnable接口的匿名类，并且通过new实例化该匿名类，然后转型为Runnable。
 * 在定义匿名类的时候就必须实例化它，定义匿名类的写法如下：
 * Runnable r = new Runnable() {
 *     // 实现必要的抽象方法...
 * };
 */
/**
 * 匿名类和Inner Class一样，可以访问Outer Class的private字段和方法。之所以我们要定义匿名类，是因为在这里我们通常不关心类名，比直接定义Inner Class可以少写很多代码。
 * 观察Java编译器编译后的.class文件可以发现，Outer类被编译为Outer.class，而匿名类被编译为Outer$1.class。如果有多个匿名类，Java编译器会将每个匿名类依次命名为Outer$1、Outer$2、Outer$3……
 * 除了接口外，匿名类也完全可以继承自普通类。观察以下代码：
 * // Anonymous Class
 * import java.util.HashMap;
 *
 * public class Main {
 *     public static void main(String[] args) {
 *         HashMap<String, String> map1 = new HashMap<>();
 *         HashMap<String, String> map2 = new HashMap<>() {}; // 匿名类!
 *         HashMap<String, String> map3 = new HashMap<>() {
 *             {
 *                 put("A", "1");
 *                 put("B", "2");
 *             }
 *         };
 *         System.out.println(map3.get("A"));
 *     }
 * }
 *  Run
 * map1是一个普通的HashMap实例，但map2是一个匿名类实例，只是该匿名类继承自HashMap。
 * map3也是一个继承自HashMap的匿名类实例，并且添加了static代码块来初始化数据。
 * 观察编译输出可发现Main$1.class和Main$2.class两个匿名类文件。
 */


