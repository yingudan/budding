package com.ripper.budding.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Test {

	public static void main(String[] args) {
		
		String a="-1";
		
		System.out.println(Integer.valueOf(a));

//		Add a = (x, y) -> x + y;

		Add b = (m, n) -> m - n;

//		System.out.println(a.add(10, 20));
//		System.out.println(b.sub(10, 20));
		// List<String> list = Arrays.asList("aaa","bbbb","cccc");
		//
		//// list.forEach(e -> {System.out.println(e);});
		////
		//// Add.interfaceStaticMethod();
		////
		//// Add add = (x,y) -> x-y;
		////
		//// add.defaultMethod();
		//
		//
		// String s = "hello";
		// Function<String,String> function = x -> x+" world";
		//
		// System.out.println(function.apply(s));

	}

	@FunctionalInterface // 函数式接口（也叫功能接口），此接口中只能有一个抽象方法。函数式接口可以用lambda表达式实例化。
	interface Add {
//		public int add(int x, int y);

		public int sub(int m, int n);

		public static void interfaceStaticMethod() {
			System.out.println("interface static method");
		}

		public default void defaultMethod() {
			System.out.println("default method");
		}

	}
}
