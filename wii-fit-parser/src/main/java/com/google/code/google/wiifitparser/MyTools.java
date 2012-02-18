package com.google.code.google.wiifitparser;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class MyTools {

	public static String getHexString(byte value) {

		String string = Integer.toHexString(value);

		if (string.length() > 2)
			string = string.substring(string.length() - 2, string.length());

		if (string.length() == 1)
			string = "0" + string;

		return string;
	}

//	public static String right(String string, int length, char filler) {
//		while (string.length() < length)
//			string = filler + string;
//		return string.substring(string.length() - length, string.length());
//	}

	public static GregorianCalendar calendar = new GregorianCalendar();

	public static Date getDate(int year, int month, int day) {
		calendar.set(year, month - 1, day, 0, 0, 0);
		return calendar.getTime();
	}

	public static Date getDate(int year, int month, int day, int hour,
			int minute) {
		calendar.set(year, month - 1, day, hour, minute, 0);
		return calendar.getTime();
	}

	private static SimpleDateFormat formatWithoutTime = new SimpleDateFormat(
			"yyyy-MM-dd");

	// new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");

	public static String formatDateWithoutTime(Date value) {
		return formatWithoutTime.format(value);
	}

	private static SimpleDateFormat formatWithTime = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm");

	public static String formatDateWithTime(Date value) {
		return formatWithTime.format(value);
	}
}
