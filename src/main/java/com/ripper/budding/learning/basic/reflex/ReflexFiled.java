package com.ripper.budding.learning.basic.reflex;

/**
 * @Auther: Yingd [RipperF@hotmail.com]
 * @Date:2021-12-01
 * @Description:com.ripper.budding.learning.basic.reflex
 * @Version:1.0
 **/


public class ReflexFiled {

    public static void main(String[] args) throws NoSuchFieldException {
        Class studentClass= Student.class;
        // 获取public字段"score":
        System.out.println(studentClass.getField("score"));

        // 获取继承的public字段"name":
        System.out.println(studentClass.getField("name"));

        System.out.println(studentClass.getDeclaredField("grade"));
    }
}
//上述代码首先获取Student的Class实例，然后，分别获取public字段、继承的public字段以及private字段，打印出的Field类似：
//public int com.ripper.budding.learning.basic.reflex.Student.score
//public java.lang.String com.ripper.budding.learning.basic.reflex.Person.name
//private int com.ripper.budding.learning.basic.reflex.Student.grade

class Student extends Person {
    public int score;
    private int grade;
}

class Person {
    public String name;
}

