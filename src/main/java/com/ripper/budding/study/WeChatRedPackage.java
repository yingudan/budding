package com.ripper.budding.study;

public class WeChatRedPackage {
	/**
	 * @param totalMoney 红包总金额
	 * @param num 红包数量
	 * @param minMoney 最小金额
	 * @author shandowF
	 * @date 2018年5月23日
	 */
	public static double[] divide(double totalMoney, int num, double minMoney) {
		double[] each = new double[num];
		for (int i = 0; i < num - 1; i++) {
			// 计算最大安全值，保证不会超出 。如果安全值越大，价格波动越大 .建议是平均值
			double maxSafeMoney = (totalMoney - (num - 1 - i) * minMoney) / (num - 1 - i);
			// 随机算出最小值，保证不低于最小值
			each[i] = Math.random() * (maxSafeMoney - minMoney) + minMoney;
			// 计算当前剩下的钱
			totalMoney = totalMoney - each[i];
		}
		each[num - 1] = totalMoney;
		return each;
	}

	public static void main(String[] args) {
		double[] rs = divide(20, 5, 0.01);
		for (double each : rs) {
			System.out.format("%.2f\n", each);
		}
	}

}
