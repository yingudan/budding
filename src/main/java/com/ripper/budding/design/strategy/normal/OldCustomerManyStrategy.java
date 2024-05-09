package com.ripper.budding.design.strategy.normal;

public class OldCustomerManyStrategy implements Strategy {
	/**
	 * 给标准价格打八折
	 */
	@Override
	public double getPrice(double standardPrice) {
		System.out.println("打八折");
		return standardPrice * 0.8;
	}

}
