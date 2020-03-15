package com.yyh.practice;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.xml.bind.DatatypeConverter;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;


public class SignatureTest {

	
	public Boolean validateSignature(Object object, String signature) {
		String secretKey = "OATBSCEDREP";//PropertiesManager.getProperty("partner.secret.key");
		System.out.println("secretKey:"+secretKey);
		
		//convert to map
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> map = mapper.convertValue(object, Map.class);
		List<String> sortedValues = map.values().stream().sorted(String.CASE_INSENSITIVE_ORDER).collect(Collectors.toList());
		
		String payload = StringUtils.join(sortedValues, ":");
		payload = payload.concat(":").concat(secretKey);
		
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			System.out.println("digest:"+digest);
		} catch (NoSuchAlgorithmException e) {
			System.out.println(e.getMessage());
		}
		if(null != digest) {
			String generatedSignature = DatatypeConverter.printBase64Binary(digest.digest(payload.getBytes()));
			System.out.println("Signature:"+signature);
			System.out.println("generatedSignature:"+generatedSignature);
			return (signature.contains(generatedSignature));
		}
		return false;
	}
}
