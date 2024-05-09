package com.ripper.budding.java8;

import java.util.Arrays;
import java.util.List;

public class Test1 {

	public static void main(String[] args) {

		final int testNumber = 123;

		Runnable r = () -> System.out.println(testNumber);

		r.run();

		List<String> l = Arrays.asList("a", "b", "c");
		l.forEach(System.out::println);
	}

	// Java8 函数式接口就是只定义一个抽象方法的接口
	public interface Predicate<T> {
		boolean test(T t);
	}
}
