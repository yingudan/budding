package com.ripper.budding.design.strategy.normal;

/**
 * 新客户小批量
 * 
 * @author shandowF
 * @Date 2019年6月3日
 */
public class NewCustomerFewStrategy implements Strategy {

	@Override
	public double getPrice(double standardPrice) {
		System.out.println("不打折,原价");
		return standardPrice;
	}

}
