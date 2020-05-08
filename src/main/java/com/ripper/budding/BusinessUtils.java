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

	/**
	 * 减法 止空对象报错
	 * 
	 * @return a+b
	 * @author ripper [RipperF@hotmail.com]
	 * @date 2020年1月21日
	 */
	public static final BigDecimal sub(BigDecimal a, BigDecimal b) {
		if (a == null) {
			a = BigDecimal.ZERO;
		}
		if (b == null) {
			b = BigDecimal.ZERO;
		}
		return a.subtract(b);
	}

	/**
	 * 除法保留小数
	 * 
	 * @return a/b
	 * @author ripper [RipperF@hotmail.com]
	 * @date 2020年1月21日
	 */
	public static final BigDecimal divide(BigDecimal a, BigDecimal b, Integer theNum) {
		if (a == null) {
			return BigDecimal.ZERO;
		}
		if (b == null) {
			return BigDecimal.ZERO;
		}
		if (BigDecimal.ZERO.compareTo(b) == 0) {
			return BigDecimal.ZERO;
		}
		return a.divide(b, theNum, BigDecimal.ROUND_HALF_UP);
	}

}
