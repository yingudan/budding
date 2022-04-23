package com.ripper.budding.learning.basic.reflex;

import java.io.File;
import java.lang.reflect.Field;
import java.util.UUID;

/**
 * @Auther: Yingd [RipperF@hotmail.com]
 * @Date:2021-11-30
 * @Description:com.ripper.budding.learning.basic.reflex
 * @Version:1.0
 **/
public class ReflexDemo {

    //编译时期常量
    final String s1 = "hello" + "ygd";

    //运行时常量
    final String s2 = UUID.randomUUID()
        .toString() + "ygd";

    public static void main(String[] args) {
        // printClassInfo("".getClass());
        //        printClassInfo(Runnable.class);
        //        printClassInfo(java.time.Month.class);
        //        printClassInfo(String[].class);
        //        printClassInfo(int.class);

        // try {
        //     changeString();
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        internString();
    }

    static void printClassInfo(Class cls) {
        System.out.println("Class name: " + cls.getName());
        System.out.println("Simple name: " + cls.getSimpleName());
        if (cls.getPackage() != null) {
            System.out.println("Package name: " + cls.getPackage()
                .getName());
        }
        System.out.println("is interface: " + cls.isInterface());
        System.out.println("is enum: " + cls.isEnum());
        System.out.println("is array: " + cls.isArray());
        System.out.println("is primitive: " + cls.isPrimitive());
    }

    /**
     * 改变一个String的值，而又不想把它重新指向其他对象的话，应该怎么办呢？利用反射修改char数组的值
     */
    public static void changeString() throws NoSuchFieldException, IllegalAccessException {
        String s = "Hydra";
        System.out.println(s + ": " + s.hashCode());
        Field field = String.class.getDeclaredField("value");
        field.setAccessible(true);
        field.set(s, new char[] {'T', 'r', 'u', 'n', 'k', 's'});
        System.out.println(s + ": " + s.hashCode());

    }

    /**
     * 驻留到字符串常量池中
     */
    public static void internString() {
        String s1 = new String("ygd");
        String s2 = s1.intern();
        System.out.println(s1 == s2);
        System.out.println(s1 == "ygd");
        System.out.println(s2 == "ygd");
        System.out.println(s1.equals("ygd"));
    }

}
