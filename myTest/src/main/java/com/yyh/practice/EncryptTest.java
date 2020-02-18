package com.yyh.practice;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

public class EncryptTest {
	public static void main(String args[]) throws IOException {
		 
		 String s1 = "654321";  
         try {
			System.out.println("\n" + s1 + " : " + toHexString(getSHA(s1)));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

	}
	   
	   public static byte[] getSHA(String input) throws NoSuchAlgorithmException 
	    {  
	        MessageDigest md = MessageDigest.getInstance("SHA-256");  
	        return md.digest(input.getBytes(StandardCharsets.UTF_8));  
	    } 
	    
	    public static String toHexString(byte[] hash) 
	    { 
	        BigInteger number = new BigInteger(1, hash);  
	        StringBuilder hexString = new StringBuilder(number.toString(16));  
	        while (hexString.length() < 32)  {  
	            hexString.insert(0, '0');  
	        }  
	  
	        return hexString.toString();  
	    } 	  
	    
		private static void checksumMD5(String hashKey, String serviceProvider, String mobileNumber, String amount){
			String strInput = hashKey + serviceProvider + mobileNumber + amount; 
			String generatedChecksum = StringUtils.upperCase(DigestUtils.md5Hex(strInput));
			System.out.println(generatedChecksum);
		}
		
		private static void checksumMD5(String strInput){
			String generatedChecksum = StringUtils.upperCase(DigestUtils.md5Hex(strInput));
			System.out.println(generatedChecksum);
		}
		
}
