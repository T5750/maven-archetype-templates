package com.cnblogs.yjmyzz.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class DateUtil {
	public static Date addMonths(Date src, int addMonths) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(src);
		calendar.add(Calendar.MONTH, addMonths);
		return calendar.getTime();
	}

	public static Date addMonths(int addMonths) {
		return addMonths(new Date(), addMonths);
	}

	public static Date addDays(Date src, int addDays) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(src);
		calendar.add(Calendar.DATE, addDays);
		return calendar.getTime();
	}

	public static Date addDays(int addDays) {
		return addDays(new Date(), addDays);
	}

	public static Date addHours(Date src, int addHours) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(src);
		calendar.add(Calendar.HOUR, addHours);
		return calendar.getTime();
	}

	public static Date addHours(int addHours) {
		return addHours(new Date(), addHours);
	}

	public static Date addSeconds(Date src, int addSeconds) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(src);
		calendar.add(Calendar.SECOND, addSeconds);
		return calendar.getTime();
	}

	public static Date addSeconds(int addSeconds) {
		return addSeconds(new Date(), addSeconds);
	}

	/**
	 * 格式化日期输出
	 * 
	 * @param src
	 *            待格式化的日期变量
	 * @param formatPattern
	 *            输出的样式 <blockquote>
	 *            <table border=0 cellspacing=3 cellpadding=0 summary="Examples of date and time patterns interpreted in the U.S. locale">
	 *            <tr bgcolor="#ccccff">
	 *            <th align=left>Date and Time Pattern
	 *            <th align=left>Result
	 *            <tr>
	 *            <td><code>"yyyy.MM.dd G 'at' HH:mm:ss z"</code>
	 *            <td><code>2001.07.04 AD at 12:08:56 PDT</code>
	 *            <tr bgcolor="#eeeeff">
	 *            <td><code>"EEE, MMM d, ''yy"</code>
	 *            <td><code>Wed, Jul 4, '01</code>
	 *            <tr>
	 *            <td><code>"h:mm a"</code>
	 *            <td><code>12:08 PM</code>
	 *            <tr bgcolor="#eeeeff">
	 *            <td><code>"hh 'o''clock' a, zzzz"</code>
	 *            <td><code>12 o'clock PM, Pacific Daylight Time</code>
	 *            <tr>
	 *            <td><code>"K:mm a, z"</code>
	 *            <td><code>0:08 PM, PDT</code>
	 *            <tr bgcolor="#eeeeff">
	 *            <td><code>"yyyyy.MMMMM.dd GGG hh:mm aaa"</code>
	 *            <td><code>02001.July.04 AD 12:08 PM</code>
	 *            <tr>
	 *            <td><code>"EEE, d MMM yyyy HH:mm:ss Z"</code>
	 *            <td><code>Wed, 4 Jul 2001 12:08:56 -0700</code>
	 *            <tr bgcolor="#eeeeff">
	 *            <td><code>"yyMMddHHmmssZ"</code>
	 *            <td><code>010704120856-0700</code>
	 *            <tr>
	 *            <td><code>"yyyy-MM-dd'T'HH:mm:ss.SSSZ"</code>
	 *            <td><code>2001-07-04T12:08:56.235-0700</code>
	 *            </table>
	 *            </blockquote>
	 * @return 输出后的日期字符串
	 */
	public static String formatDate(Date src, String formatPattern) {
		if (src == null) {
			return "";
		}
		DateFormat fmt = new SimpleDateFormat(formatPattern);
		return fmt.format(src);
	}

	public static String formatDate(Date src) {
		return formatDate(src, "yyyy-MM-dd HH:mm:ss");
	}

	public static String formatDate() {
		return formatDate(new Date(), "yyyy-MM-dd");
	}

	public static String formatDate(String formatPattern) {
		return formatDate(new Date(), formatPattern);
	}

	public static Date getDate(int year, int month, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(year, month - 1, day);
		return calendar.getTime();
	}
}
