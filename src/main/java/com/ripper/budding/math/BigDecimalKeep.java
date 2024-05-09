package com.ripper.budding.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class bigDemicalKeep {
	public static void main(String[] args) {
//		BigDecimal decimal = new BigDecimal("1222222222222222222222222222.65");
//		// BigDecimal setScale1 = decimal.setScale(1,
//		// BigDecimal.ROUND_HALF_DOWN);//1
//		// 数字代表 保留几位小数 (四舍五入)
//		BigDecimal setScale1 = decimal.setScale(1, BigDecimal.ROUND_HALF_UP);
//		System.out.println(setScale1);
//		BigDecimal cz = new BigDecimal(1).subtract(dto.getTestPlan().multiply(new BigDecimal(100)));	
		
		BigDecimal cz = new BigDecimal(1).subtract(new BigDecimal("0.6884"));
		System.out.println(cz);
//		new BigDecimal(5).divide(new BigDecimal("0.0001").multiply(new BigDecimal(100)),2, RoundingMode.HALF_UP).multiply(cz);

		BigDecimal a=new BigDecimal(11846).divide(new BigDecimal("0.6884"),2, RoundingMode.HALF_UP).multiply(cz);
//		
		System.out.println(a.longValue());
		
	}
}
