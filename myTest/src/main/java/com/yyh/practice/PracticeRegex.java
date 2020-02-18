package com.yyh.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PracticeRegex {

	public static void main(String[] args){
		Pattern pattern = Pattern.compile("^[a-z]+[\\$_.\\w]*$");
		Matcher matcher = pattern.matcher("foo-");
		
		//^[-a-z0-9~!$%^&*_=+}{\'?]+(\.[-a-z0-9~!$%^&*_=+}{\'?]+)*@([a-z0-9_][-a-z0-9_]*(\.[-a-z0-9_]+)*\.
		//(aero|arpa|biz|com|coop|edu|gov|info|int|mil|museum|name|net|org|pro|travel|mobi|[a-z][a-z])|([0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}))(:[0-9]{1,5})?$
		
		 System.out.println("Looking at: " + matcher.lookingAt());
		 System.out.println("Matches: " + matcher.matches());
	}
	
	
}
