package com.ripper.budding.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathTest {

	public static final BigDecimal a1 = new BigDecimal(10);

	public static final BigDecimal a2 = new BigDecimal(10.2);

	public static void main(String[] args) {
		BigDecimal q = new BigDecimal("22.0");
		
		System.out.println(q.setScale(3, BigDecimal.ROUND_DOWN));
		
		
		
	}

	/**
	 * 判断涨幅是否大于百分之十
	 * @param before
	 * @param after
	 * @param compare
	 * @return
	 */
	public static boolean queryFloat(BigDecimal before, BigDecimal after,BigDecimal compare) {
		BigDecimal res=after.subtract(before).abs().divide(before,  2,
				RoundingMode.HALF_UP);
		if(res.compareTo(compare)>0){//大于0说明浮动大于10%
			return false;
		}
		return true;
	}
}
