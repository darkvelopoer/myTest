package com.yyh.practice;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class CalTest {
	public static void main(String args[]) throws IOException {

		// System.out.println("Date:" + getEndOfDay());
		// to_date('20190912111111', 'yyyymmddhh24miss')

		/*
		 * DateFormat formatterDb = new SimpleDateFormat("yyyy-MM-dd"); //HHmmss String
		 * d = formatterDb.format(new Date()); System.out.println("Date:" + d);
		 */

		/*
		 * String str = "2019-09-12"; String ss = "11:11:11"; String str2 =
		 * str.replace("-", "") + ss.replace(":", ""); System.out.println(str2);
		 */
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss.SSS");
		try {
			Date date1 = sdf.parse("20200210142011.001");
			System.out.println(date1);
			
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
			String strDate = dateFormat.format(date1);
			System.out.println(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//double d = Double.parseDouble("123.20") * 100;
		//int i = (int) d;
		//System.out.println(i);

	}

	private static Date getEndOfDay() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, 5);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();
	}

	private static String removeSeparatorCharacters(String param) {
		param = StringUtils.remove(param, "\\|");
		return param;
	}

	public static boolean isPalindromString(String text) {
		String reverse = reverse(text);
		if (text.equals(reverse)) {
			return true;
		}
		return false;
	}

	public static String reverse(String input) {
		if (input == null || input.isEmpty()) {
			return input;
		}
		return input.charAt(input.length() - 1) + reverse(input.substring(0, input.length() - 1));
	}

}
