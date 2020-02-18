package com.yyh.practice;

import org.apache.commons.lang3.StringUtils;

public class StringTest {

	public static void main (String[] args) {
		//substringTest();
		strTest(null);
	}

	private static void substringTest() {
		String temp = "actionType: jsonTransfer";
		
		int t1 = temp.indexOf("actionType:");
		String res = temp.substring(t1+12, temp.length());
		System.out.println(t1);
		System.out.println(res);
	}
	
	private static void strTest(String input) {
		boolean b = StringUtils.isEmpty(input);
		
		System.out.println(b);
	}
}
