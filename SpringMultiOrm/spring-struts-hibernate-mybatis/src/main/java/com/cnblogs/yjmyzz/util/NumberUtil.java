package com.cnblogs.yjmyzz.util;

import java.math.BigDecimal;

import org.springframework.util.StringUtils;

public class NumberUtil {
	public static int getIntValue(BigDecimal b) {
		if (b == null) {
			return 0;
		}
		return b.intValue();
	}

	public static BigDecimal getBiDecimal(String s) {
		if (StringUtils.isEmpty(s)) {
			return null;
		}
		return new BigDecimal(s);
	}
}
