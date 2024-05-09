package com.ripper.budding.math;

/**
 * 斐波拉契
 * 
 * @author shandowF
 * @date 2016年11月23日
 */
public class Pbqsl {
	/**
	 * 这是一个斐波拉契问题
	 */
	public static void main(String[] args) {
		System.out.println("第1个月兔子对数：1");
		System.out.println("第2个月兔子对数：2");
		int monthOne = 1;// 第1个月兔子对数
		int monthTwo = 1;// 第2个月兔子对数
		int nextMonth;// 定义下个月兔子对数
		int totalMonth = 12;// 1年
		for (int i = 3; i <= totalMonth; i++) {
			nextMonth = monthTwo;
			monthTwo = monthTwo + monthOne;
			monthOne = nextMonth;
			System.out.println("第" + i + "个月兔子对数：" + monthTwo);
		}
	}
}
