package com.cnblogs.yjmyzz.util;

import java.util.List;

public class ListUtil {
	public static String getString(List<?> list) {
		if (list == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for (Object o : list) {
			sb.append(o.toString() + " ");
		}
		return sb.toString().trim();
	}
}
