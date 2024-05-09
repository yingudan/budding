package com.ripper.budding.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 笛卡尔积 取直积(优雅的方式)
 * 
 * @author shadow
 *
 */
public class CartesianProductPlus {

	public static void run(List<List<String>> dimvalue, List<String> result, int layer, String curstring) {
		// 大于一个集合时：
		if (layer < dimvalue.size() - 1) {
			// 大于一个集合时，第一个集合为空
			if (dimvalue.get(layer).size() == 0)
				run(dimvalue, result, layer + 1, curstring);
			else {
				for (int i = 0; i < dimvalue.get(layer).size(); i++) {
					StringBuilder s1 = new StringBuilder();
					s1.append(curstring);
					s1.append(dimvalue.get(layer).get(i));
					run(dimvalue, result, layer + 1, s1.toString());
				}
			}
		}
		// 只有一个集合时：
		else if (layer == dimvalue.size() - 1) {
			// 只有一个集合，且集合中没有元素
			if (dimvalue.get(layer).size() == 0)
				result.add(curstring);
			// 只有一个集合，且集合中有元素时：其笛卡尔积就是这个集合元素本身
			else {
				for (int i = 0; i < dimvalue.get(layer).size(); i++) {
					result.add(curstring + dimvalue.get(layer).get(i));
				}
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<List<String>> dimvalue = new ArrayList<List<String>>();
		List<String> v1 = new ArrayList<String>();
		v1.add("语文1");
		v1.add("语文2");
		List<String> v2 = new ArrayList<String>();
		v2.add("英语1");
		List<String> v3 = new ArrayList<String>();
		v3.add("数学1");
		v3.add("数学2");
		v3.add("数学3");
		//
		dimvalue.add(v1);
		dimvalue.add(v2);
		// dimvalue.add(v2);
		dimvalue.add(v3);

		List<String> result = new ArrayList<String>();

		CartesianProductPlus.run(dimvalue, result, 0, "");

		int i = 1;
		for (String s : result) {
			System.out.println(i++ + ":" + s);
		}
	}
}
