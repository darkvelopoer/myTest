package com.yyh.practice.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

public class CryptoUtil {
	
	/**
	 * 아름넷 key,iv값 정의
	 */
	private static final String KEY = "smart@arumnetkey";
	private static final String IV = "arumnet@walletiv";
	
	private static final String ENC_FORMAT = "AES/CBC/NoPadding";
	private static final String ENC_TYPE = "utf-8";
	
	
	/**
	 * @param algorithm
	 * @param keyData
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 * @throws InvalidKeySpecException
	 */
	public static Key generateKey(String algorithm, byte[] keyData) throws NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException {  
        SecretKeySpec keySpec = new SecretKeySpec(keyData, algorithm);  
        return keySpec;   
	} 

	
	/**
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static String encodeStr(String str) throws Exception {
		String result = null;
		Key key = generateKey("AES", KEY.getBytes());  
		IvParameterSpec ivParameterSpec = new IvParameterSpec(IV.getBytes());  
		Cipher cipher = Cipher.getInstance(ENC_FORMAT);  
		cipher.init(Cipher.ENCRYPT_MODE, key, ivParameterSpec);  

		byte[] plain = padString(str).getBytes();  
		byte[] encrypt = cipher.doFinal(plain);  
		result = Base64.encodeBase64String(encrypt).replace(StringUtils.CR, StringUtils.EMPTY).trim();
	    
		return result;
	}
	
	/**
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static String decodeStr(String str) throws Exception {
		String result = null;
		Key key = generateKey("AES", KEY.getBytes());  
		IvParameterSpec ivParameterSpec = new IvParameterSpec(IV.getBytes());  
		Cipher cipher = Cipher.getInstance(ENC_FORMAT);  
		cipher.init(Cipher.DECRYPT_MODE, key, ivParameterSpec);
		
		byte plain[] = Base64.decodeBase64(str);
		byte[] decrypt = cipher.doFinal(plain);
		result = new String(decrypt, ENC_TYPE);
		result = result.trim();
	    
		return result;
	}
	
	/**
	 * @param source
	 * @return
	 */
	private static String padString(String source) {
		  char paddingChar = ' ';
		  int size = 16;
		  int padLength = size - (source.getBytes().length % size);
		  if(padLength != 16){
			  for (int i = 0; i < padLength; i++) {
			    source += paddingChar;
			  }
		  }
		  return source;
	}
	
	public static String getSHA256FileHexHash(String fileName) throws NoSuchAlgorithmException, FileNotFoundException, IOException {
		byte[] buffer= new byte[8192];
	    int count;
	    byte[] hash;
	    BufferedInputStream bis = null;
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			bis = new BufferedInputStream(new FileInputStream(fileName));
			while ((count = bis.read(buffer)) > 0) {
			    digest.update(buffer, 0, count);
			}
			hash = digest.digest();
			
		} finally {
			bis.close();
		}
		return DatatypeConverter.printHexBinary(hash);
	}

}
