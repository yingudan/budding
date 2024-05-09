package com.ripper.budding.study;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Person {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Person() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}

public class CreateObject {
	/**
	 * Java的反射机制是指：反射就是把Java类中的各种成分映射成相应相应的Java类， 然后就可以获取这个类的所有信息
	 * 
	 * @throws Exception
	 */
	public static void createObj1() throws Exception {
		// 返回与带有给定字符串名的类或接口相关联的 Class 对象。
		// Class classType = Person.class;
		Class classType = Class.forName("lxf.Person");
		Object obj = classType.newInstance();
		System.out.println("使用反射反射机制创建出来的对象是否是Person类的对象：" + (obj instanceof Person));
	}

	/**
	 * 创建带有构造参数的对象的时候我们需要使用另外一种方式即： 1.先获取操作类的Class对象即字节码文件
	 * 2.使用Class对象的getConstructor
	 * (parameterTypes)方法获取该对象的构造方法的对象，注意括号中可以带不等的可变参数,
	 * 3.使用构造方法对象的newInstance(initargs)方法就可以实例化一个对象 4.注意，使用这些方法都不可以访问被
	 * private修饰的方法，需要设置某些访问权限setAccessable()方法
	 * 
	 * @throws Exception
	 */
	public static void createObj2() throws Exception {
		@SuppressWarnings("rawtypes")
		Class classType = Person.class;

		@SuppressWarnings("unchecked")
		Constructor<Person> con = classType.getConstructor(String.class, int.class);
		Object obj = con.newInstance("asd", 23);
		System.out.println("使用constructor对象的newInstance方法创建对象的信息：" + ((Person) obj).getName());
	}

	/**
	 * 操作方法包括（private方法） 步骤： 1.首先获取要操作类的Class对象
	 * 2.然后通过Class对象的getMethod方法获取要操作的方法的Method对象（两个参数，第一个参数是方法名，第二个参数是参数类型）
	 * 3.调用Method的方法的invoke方法（两个参数，第一个参数是该方法属于的类对象，具体参数）
	 * 4.当方法被private修饰的时候，首先需要调用getDeclaredMethod()方法获取要操作的被private修饰的类。
	 * 在这里要注意这个getDeclaredMethod方法，它既可以用作获取普通方法的对象也可以用来操作private修饰的方法，
	 * 但是操作private修饰的方法的时候，必须使用这个方法，其它方法不可以。普通方法还可以使用getMethod方法，
	 * 且属性操作也是如此。另外，还需要设置访问权限setAccessable(true)才可以
	 * 
	 * @throws Exception
	 */
	public static void methodDo() throws Exception {
		Person p = new Person();
		Class classType = Person.class;
		Method method = classType.getMethod("setName", String.class);
		method.invoke(p, "ckl");
		System.out.println("使用反射操作SetName方法后，Person对象的name值是：" + p.getName());

		Method method2 = classType.getDeclaredMethod("test");
		method2.setAccessible(true);
		method2.invoke(p);
	}

	/**
	 * 操作字段
	 * 
	 * @throws Exception
	 */
	public static void FieldDo() throws Exception {
		Person p = new Person();
		Class classType = Person.class;
		Field field = classType.getDeclaredField("name");
		Field field2 = classType.getDeclaredField("age");
		field.setAccessible(true);
		field2.setAccessible(true);
		field.set(p, "mht");
		field2.set(p, 23);
		System.out.println("使用反射机制操作被private修饰的对象字段后得到的属性值是：" + p.getName());
		System.out.println("使用反射机制操作被private修饰的对象字段后得到的属性值是：" + p.getAge());
	}

	public static void main(String[] args) throws Exception {
		new CreateObject().FieldDo();
	}
}
