package com.yyh.practice;

import org.apache.commons.codec.digest.DigestUtils;
//import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.StringUtils;

public class ChecksumGen {
	public static void main(String args[]){  
		
		//checksumMD5("0617AF3E5643CA3C4FFAED3F1AD08F6E", "CELCOM", "0132617822", "1000"); //BC0DE43E681AB44CAD0331A71D0DCF90
		//checksumMD5("0617AF3E5643CA3C4FFAED3F1AD08F6E", "CELCOM", "01120809087", "1000"); 
		//checksumMD5("D87DEA658D7B9BFA8FCE7478E5752EBC", "CELCOM", "01120809087", "1000"); 
		
		//checksumMD5("349318BD1FVIPXJJ321TRY6344391100", "CELCOM", "01119276510", "5000"); 

		//checksumMD5("111018XWS1B378PL714FDS2206378289", "CELCOM", "01119276510", "1000");
		
		//checksumMD5("0617AF3E5643CA3C4FFAED3F1AD08F6E", "CELCOM", "01119276510", "1000"); 
		
		//checksumMD5("0617AF3E5643CA3C4FFAED3F1AD08F6E", "CELCOM", "0197246216", "1000"); 
		checksumMD5("0617AF3E5643CA3C4FFAED3F1AD08F6E", "CELCOM", "0194368550", "1000"); 
		
	}
	
	private static void checksumMD5(String hashKey, String serviceProvider, String mobileNumber, String amount){
		String strInput = hashKey + serviceProvider + mobileNumber + amount; 
		String generatedChecksum = StringUtils.upperCase(DigestUtils.md5Hex(strInput));
		System.out.println(generatedChecksum);
	}
}
