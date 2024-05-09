package com.ripper.budding.utils;

import java.util.ArrayList;
import java.util.List;

public class PageTest {

	public static void main(String args[]) {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");

		list.add("6");
		list.add("7");
		list.add("8");
		list.add("9");
		list.add("10");

		list.add("11");
		list.add("12");
		list.add("13");
		list.add("14");
		PageModel pm = new PageModel(list, 10);
		System.out.println(pm.getTotalPages());

		list = pm.getObjects(1);
		System.out.println(list);
		// for (int i = 0; i < sublist.size(); i++) {
		// System.out.println(sublist.get(i));
		// }
	}
}
