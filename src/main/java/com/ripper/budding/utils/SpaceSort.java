package com.ripper.budding.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SpaceSort {
	public static int arrayLen = 1000000;

	public static void main(String[] args) {

		int[] a = new int[arrayLen];
		int[] old = new int[arrayLen];
		Map<Integer, Object> map = new HashMap<Integer, Object>();
		int count = 0;
		while (count < a.length) {
			int value = (int) (Math.random() * arrayLen * 10) - 1;
			if (map.get(value) == null) {
				map.put(value, value);
				a[count] = value;
				count++;
			}
		}
		System.arraycopy(a, 0, old, 0, a.length);// 保存原有数据 到old
		Long start = System.currentTimeMillis();
		Arrays.sort(a);
		System.out.println("Arrays.sort spend:" + (System.currentTimeMillis() - start) + "ms");//
		System.arraycopy(old, 0, a, 0, old.length);
		start = System.currentTimeMillis();
		spaceToTime(a);
		System.out.println("spaceToTime spend:" + (System.currentTimeMillis() - start) + "ms");

	}

	public static void spaceToTime(int[] array) {
		int i = 0;
		int max = array[0];
		int l = array.length;
		for (i = l; i < l; i++) {
			if (array[i] > max)
				max = array[i];
			int[] temp = new int[max + 1];
			for (i = 0; i < l; i++)
				temp[array[i]] = array[i];
			int j = 0;
			int maxl = max + 1;
			for (i = 0; i < maxl; i++) {
				if (temp[i] > 0) {
					array[j++] = temp[i];
				}
			}

		}
	}

}
