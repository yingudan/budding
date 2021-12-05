package com.ripper.budding.learning.basic.reflex;

/**
 * 获取继承关系
 *
 * @Auther: yingd [RipperF@hotmail.com]
 * @Date:2021-12-05
 * @Description:com.ripper.budding.learning.basic.reflex
 * @Version:1.0
 **/


public class ReflexClass {


    public static void main(String[] args) throws Exception {

        //获取类的所有父类
        getParentsClassTest();

        //获取类的所有接口
        getInterface();

        //继承关系
        classRelationTest();
    }

    /**
     * 如果是两个Class实例，要判断一个向上转型是否成立，
     * 可以调用isAssignableFrom()：
     */
    public static void fixClass() {
        // Integer i = ?
        boolean assignableFrom = Integer.class.isAssignableFrom(Integer.class);// true，因为Integer可以赋值给Integer
        // Number n = ?
        Number.class.isAssignableFrom(Integer.class); // true，因为Integer可以赋值给Number
        // Object o = ?
        Object.class.isAssignableFrom(Integer.class); // true，因为Integer可以赋值给Object
        // Integer i = ?
        Integer.class.isAssignableFrom(Number.class); // false，因为Number不能赋值给Integer
    }

    public static void classRelationTest() {
        Object n = Integer.valueOf(123);
        boolean isDouble = n instanceof Double; // false
//        System.out.println(isDouble);
        boolean isInteger = n instanceof Integer; // true
//        System.out.println(isInteger);
        boolean isNumber = n instanceof Number; // true
//        System.out.println(isNumber);
        boolean isSerializable = n instanceof java.io.Serializable; // true
//        System.out.println(isSerializable);

    }

    /**
     * 获取interface
     * 由于一个类可能实现一个或多个接口，通过Class我们就可以查询到实现的接口类型。例如，查询Integer实现的接口：
     */
    public static void getInterface() throws Exception {
        Class s = String.class;
        Class[] is = s.getInterfaces();
        for (Class i : is) {
            System.out.println(i);
        }
    }


    /**
     * 获取父类的Class
     * 有了Class实例，我们还可以获取它的父类的Class：
     * 运行上述代码，可以看到，Integer的父类类型是Number，Number的父类是Object，Object的父类是null。
     * 除Object外，其他任何非interface的Class都必定存在一个父类类型。
     */
    public static void getParentsClassTest() {
        Class a = Integer.class;
        Class n = a.getSuperclass();
        System.out.println(n);
        Class o = n.getSuperclass();
        System.out.println(o);
        System.out.println(o.getSuperclass());
    }

    /**
     * @depiction
     * @author：Yingd [RipperF@hotmail.com]
     * @date:2021-12-05
     */
    public static void getClassTest() throws Exception {
        /**
         * 当我们获取到某个Class对象时，实际上就获取到了一个类的类型：
         */
        Class cls1 = String.class; // 获取到String的Class

        /**
         * 还可以用实例的getClass()方法获取：
         */
        String s = "";
        Class cls2 = s.getClass(); // s是String，因此获取到String的Class

        /**
         *最后一种获取Class的方法是通过Class.forName("")，传入Class的完整类名获取：
         */
        Class cls3 = Class.forName("java.lang.String");

        //这三种方式获取的Class实例都是同一个实例，因为JVM对每个加载的Class只创建一个Class实例来表示它的类型。

    }

    /**
     * 小节
     * 通过Class对象可以获取继承关系：
     * Class getSuperclass()：获取父类类型；
     * Class[] getInterfaces()：获取当前类实现的所有接口。
     * 通过Class对象的isAssignableFrom()方法可以判断一个向上转型是否可以实现。
     */
}
