package com.ripper.budding.math;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author shandowF
 * @date 2018年9月12日
 */
public class Test2 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 120; i++) {
			list.add(i);
		}
		System.out.println(list.size());
		System.out.println(list);

		List<Integer> Num = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			Num.add(list.remove(new Random().nextInt(list.size())));
		}
		System.out.println(Num);
		System.out.println(list);
	}

}
