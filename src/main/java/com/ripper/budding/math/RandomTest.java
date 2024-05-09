package com.ripper.budding.math;

import java.util.Random;

public class RandomTest {
	public static void main(String[] args) {
		String s = "";
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			s = s + rand.nextInt(10) + " ";
		}
		System.out.println(s);
	}
 
}
