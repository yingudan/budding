package com.ripper.budding.learning.basic.reflex;

import java.lang.reflect.Constructor;

/**
 * @Auther: yingd [RipperF@hotmail.com]
 * @Date:2021-12-05
 * @Description:com.ripper.budding.learning.basic.reflex
 * @Version:1.0
 **/
public class ReflexInstance {

    public static void main(String[] args) throws Exception {
        //使用构造器调用对象方法
        useInstanceTest();
    }


    /**
     * 调用Class.newInstance()的局限是，它只能调用该类的public无参数构造方法。
     * 如果构造方法带有参数，或者不是public，就无法直接通过Class.newInstance()来调用。
     * 为了调用任意的构造方法，Java的反射API提供了Constructor对象，它包含一个构造方法的所有信息，
     * 可以创建一个实例。Constructor对象和Method非常类似，不同之处仅在于它是一个构造方法，并且，调用结果总是返回实例：
     */
    public static void useInstanceTest() throws Exception {
        Constructor cons1 = Integer.class.getConstructor(int.class);
        Integer n1 = (Integer) cons1.newInstance(123);
        System.out.println(n1);

        Constructor cons2 = String.class.getConstructor(String.class);
        String n2 = (String) cons2.newInstance("测试");
        System.out.println(n2);
    }

    /****************匿名内小结********************/
    /**
     * 通过Class实例获取Constructor的方法如下：
     * getConstructor(Class...)：获取某个public的Constructor；
     * getDeclaredConstructor(Class...)：获取某个Constructor；
     * getConstructors()：获取所有public的Constructor；
     * getDeclaredConstructors()：获取所有Constructor。
     * 注意Constructor总是当前类定义的构造方法，和父类无关，因此不存在多态的问题。
     * 调用非public的Constructor时，必须首先通过setAccessible(true)设置允许访问。setAccessible(true)可能会失败。
     *
     * Constructor对象封装了构造方法的所有信息；
     * 通过Class实例的方法可以获取Constructor实例：getConstructor()，getConstructors()，getDeclaredConstructor()，getDeclaredConstructors()；
     * 通过Constructor实例可以创建一个实例对象：newInstance(Object... parameters)； 通过设置setAccessible(true)来访问非public构造方法。
     **/


}
