package com.ripper.budding.study;

public class SingletonIsSame {
	private static SingletonIsSame s;

	public static SingletonIsSame getInstance() {
		if (s == null)
			s = new SingletonIsSame();
		return s;
	}
	
	public static void main(String[] args) {
		singletonTest.main();
	}
	
}

class singletonTest {
	
	public static void main() {
		SingletonIsSame s1 = SingletonIsSame.getInstance();
		SingletonIsSame s2 = SingletonIsSame.getInstance();
		if (s1 == s2)
			System.out.println("s1 is the same instance with s2");
		else
			System.out.println("s1 is not the same instance with s2");
	}
}