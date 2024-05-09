package com.ripper.budding.design.strategy.normal;

/**
 * 新客户大批量
 * 
 * @author shandowF
 * @Date 2019年6月3日
 */
public class NewCustomerManyStrategy implements Strategy {

	@Override
	public double getPrice(double standardPrice) {
		System.out.println("打九折");
		return standardPrice * 0.9;
	}

}
