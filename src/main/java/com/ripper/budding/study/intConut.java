package com.ripper.budding.study;

public class intConut {

	static void f(Letter y) {
		y.c = 'z';

	}

	public static void main(String[] args) {
		int i = 1;
		prt("i : " + i);
		prt("++i : " + ++i); // Pre-increment
		prt("i++ : " + i++); // Post-increment
		prt("i : " + i);
		prt("--i : " + --i); // Pre-decrement
		prt("i-- : " + i--); // Post-decrement
		prt("i : " + i);
	}
	static void prt(String s) {
		System.out.println(s);
	}
}
/**
 * 1 2  3  3 2 1 1
 * 
 * 
 */
class Letter {
	char c;
}
