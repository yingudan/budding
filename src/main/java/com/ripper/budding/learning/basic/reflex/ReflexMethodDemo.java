package com.ripper.budding.learning.basic.reflex;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Auther: yingd [RipperF@hotmail.com]
 * @Date:2021-12-05
 * @Description:com.ripper.budding.learning.basic.reflex
 * @Version:1.0
 **/
public class ReflexMethodDemo {


    public static void main(String[] args) throws Exception {
        //测试反射调用方法
        reflexMethodDemoTest();

        //测试调用String的方法
        reflexStringDemo();

        //测试使用 反射获取静态方法
        reflexStaticMethodTest();

        //测试调用非public 方法
        reflexPrivateMethodTest();

        //测试调用多态
        reflexPolymorphicMethodTest();


    }


    /**
     * 多态
     * 我们来考察这样一种情况：一个People类定义了hello()方法，并且它的子类Man也覆写了hello()方法，
     * 那么，从People.class获取的Method，作用于Man实例时，调用的方法到底是哪个？
     * 运行上述代码，发现打印出的是Man:hello，因此，使用反射调用方法时，仍然遵循多态原则：即总是调用实际类型的覆写方法（如果存在）。上述的反射代码：
     * Method m =People.class.getMethod("hello");
     * m.invoke(new Man());
     * 实际上相当于：
     * Person p = new Man();
     * p.hello();
     */
    public static void reflexPolymorphicMethodTest() throws Exception {
        Method m = People.class.getMethod("hello");
        m.invoke(new Man());
    }


    /**
     * 和Field类似，对于非public方法，我们虽然可以通过Class.getDeclaredMethod()获取该方法实例，但直接对其调用将得到一个IllegalAccessException。
     * 为了调用非public方法，我们通过Method.setAccessible(true)允许其调用：
     */
    public static void reflexPrivateMethodTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Man man = new Man();
        Method m = man.getClass().getDeclaredMethod("getGrade", int.class);
        m.setAccessible(true);
        System.out.println(m.invoke(man, 2));
    }


    /**
     * 如果获取到的Method表示一个静态方法，调用静态方法时，由于无需指定实例对象，所以invoke方法传入的第一个参数永远为null。我们以Integer.parseInt(String)为例：
     */
    public static void reflexStaticMethodTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Integer.class.getMethod("parseInt", String.class);
        Integer n = (Integer) method.invoke(null, "2234");
        System.out.println(n);
    }

    /**
     * 注意到substring()有两个重载方法，我们获取的是String substring(int)这个方法。思考一下如何获取String substring(int, int)方法。
     * 对Method实例调用invoke就相当于调用该方法，invoke的第一个参数是对象实例，即在哪个实例上调用该方法，后面的可变参数要与方法参数一致，否则将报错。
     * 此外，setAccessible(true)可能会失败。如果JVM运行期存在SecurityManager，那么它会根据规则进行检查，有可能阻止setAccessible(true)。
     * 例如，某个SecurityManager可能不允许对java和javax开头的package的类调用setAccessible(true)，这样可以保证JVM核心库的安全。
     *
     * @throws Exception
     */
    public static void reflexStringDemo() throws Exception {
        String s = "hello ym";
        Method m = String.class.getMethod("substring", int.class, int.class);
        String result = (String) m.invoke(s, 3, 5);
        System.out.println(result);
    }


    /**
     * @depiction
     * @author：Yingd [RipperF@hotmail.com]
     * @date:2021-12-05
     */
    public static void reflexMethodDemoTest() throws Exception {
        Class manClass = Man.class;
        System.out.println(manClass.getMethod("getScore", String.class));
        System.out.println(manClass.getMethod("getName"));
        System.out.println(manClass.getDeclaredMethod("getGrade", int.class));
    }

}

class Man extends People {
    public int getScore(String type) {
        return 100;
    }

    private int getGrade(int year) {
        return 1;
    }

    public void hello() {
        System.out.println("Man:hello");
    }
}

class People {
    public String getName() {
        return "tony";
    }

    public void hello() {
        System.out.println("People:hello");
    }
}