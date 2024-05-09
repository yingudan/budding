package com.ripper.budding.design.strategy.normal;

import java.math.BigDecimal;

/**
 * 策略接口
 * 
 * @author shandowF
 * @Date 2019年6月3日
 */
public interface Strategy {

	/**
	 * 给标准价格打折
	 * 
	 * @author shandowF
	 * @Date 2019年6月3日
	 * @return
	 */
	public double getPrice(double standardPrice);
	
	

}
