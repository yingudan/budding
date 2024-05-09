package com.ripper.budding.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
public class FilteringApples {

	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red"));
			
		for(Apple apple:inventory){
			if("red".equals(apple.getColor())){
				inventory.remove(apple);
			}
		}
		
//		for(int i=0;i<inventory.size();i++){
//			if("red".equals(inventory.get(i).getColor())){
//				inventory.remove(inventory.get(i));
//			}
//		}
//		System.out.println(inventory);
		
		List<Apple> greenApples = filterApples(inventory, FilteringApples::isGreenApple);
		List<Apple> weightApples = filterApples(inventory, FilteringApples::isHeavyApple);

		// System.out.println(greenApples);
		// System.out.println(weightApples);
		// Java8
		 List<Apple> weirdApples = filterApples(inventory,(Apple a) -> a.getWeight() < 130 || "red".equals(a.getColor()));
		// System.out.println(filterApples(inventory, (Apple
		// a)->"green".equals(a.getColor())));
		// Java8非并行处理
		List<Apple> heaveyApples = inventory.stream().filter((Apple a) -> a.getWeight() > 150).collect(toList());
		// Java8并行处理
		List<Apple> bxHeaveyApples = inventory.parallelStream().filter((Apple a) -> a.getWeight() > 150)
				.collect(toList());

		// System.out.println(bxHeaveyApples);

		// java8
		List<Integer> numbers = new ArrayList<>();
		numbers.add(2);
		numbers.add(5);
		numbers.add(8);
		
		List<Integer> Numners = filter(numbers, (Integer i) -> i % 2 == 0);
		// System.out.println(Numners);
			
		
		
		
		// java8
		Runnable t1 = () -> System.out.println("ygd test1");

		Runnable t2 = new Runnable() {
			public void run() {
				System.out.println("ygd test2");
			}
		};
		
		process(t1);
		process(t2);
		process(()->System.out.println("ygd test3"));
		
		
		List<Integer> l = map(Arrays.asList("lambdas", "in", "action"), (String s) -> s.length());
		System.out.println(l);
		
	}
	
	
	
	
	
	@FunctionalInterface
	public interface Function<T,R>{
		R apply(T t);
	}
	
	public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
		List<R> result = new ArrayList<>();
		for (T s : list) {
			result.add(f.apply(s));
		}
		return result;
	}
	
	
	
	public static void process(Runnable r){
		r.run();
	}
	
	
	public static <T> List<T> filter(List<T> list, Predicate<T> p) {
		List<T> result = new ArrayList<>();
		for (T e : list) {
			if (p.test(e)) {
				result.add(e);
			}
		}
		return result;
	}

	/**
	 * 常规筛选
	 * 
	 * @param inventory
	 * @return
	 */
	public static List<Apple> filterGreenApples(List<Apple> inventory) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if ("green".equals(apple.getColor())) {
				result.add(apple);
			}
		}
		return result;
	}

	public static boolean isGreenApple(Apple apple) {
		return "green".equals(apple.getColor());
	}

	public static boolean isHeavyApple(Apple apple) {
		return apple.getWeight() > 150;
	}

	/**
	 * java8中函数式 接口
	 */
	public interface Predicate<T> {
		boolean test(T t);
	}

	public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}

	public static class Apple {
		private int weight = 0;

		private String color = "";

		public Apple(int weight, String color) {
			this.weight = weight;
			this.color = color;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		@Override
		public String toString() {
			return "Apple [weight=" + weight + ", color=" + color + "]";
		}
	}
}
