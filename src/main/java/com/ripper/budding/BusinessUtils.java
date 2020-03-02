package com.ripper.budding;

import java.math.BigDecimal;

/**
 * 
 * @depiction
 * @author ripper [RipperF@hotmail.com]
 * @date 2020年1月20日
 */
public class BusinessUtils {

	/**
	 * getBigDecimal转换防止报错
	 * 
	 * @author ripper [RipperF@hotmail.com]
	 * @date 2020年1月21日
	 */
	public static BigDecimal getBigDecimal(String bigDecimal) {
		if (StringUtils.isEmpty(bigDecimal)) {
			return BigDecimal.ZERO;
		}
		BigDecimal result = BigDecimal.ZERO;
		try {
			result = new BigDecimal(bigDecimal);// 防止转换报错
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 加法防止空对象报错
	 * 
	 * @return a+b
	 * @author ripper [RipperF@hotmail.com]
	 * @date 2020年1月21日
	 */
	public static BigDecimal add(BigDecimal a, BigDecimal b) {
		if (a == null) {
			a = BigDecimal.ZERO;
		}
		if (b == null) {
			b = BigDecimal.ZERO;
		}
		return a.add(b);
	}

}
