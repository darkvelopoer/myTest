package com.myapps.examples.util;

import java.security.Key;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class GenerateToken {

	public static void main(String[] args) {
		System.out.println(generateJWTToken());
	}
	
	private static String generateJWTToken() {
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    int tokenDurationHour = Integer.parseInt("1"); //1 hour
	    int tokenDurationDay = Integer.parseInt("30"); //30 days
	    
		Calendar calSixtyMinLater = Calendar.getInstance();
		calSixtyMinLater.add(Calendar.HOUR, tokenDurationHour);
		
		Calendar calThirtyDaysLater = Calendar.getInstance();
		calThirtyDaysLater.add(Calendar.DATE, tokenDurationDay);

		//Generate JWT
	    HashMap<String,Object> map = new HashMap<String,Object>();
	    map.put("alg","none");//HS256
	    map.put("typ","JWT");
	    HashMap<String,Object> mapClaims = new HashMap<String,Object>();
	    map.put("clientId","clientId123");
	    map.put("memNo","memNo123");
	    map.put("createdAt", formatter.format(new Date()));
	    map.put("expiredAt", formatter.format(calSixtyMinLater.getTime()));
	    
		//The JWT signature algorithm we will be using to sign the token
	    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
	    //We will sign our JWT with our ApiKey secret
	    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("123456");
	    Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
	    
	    String jwtToken = Jwts.builder().setClaims(mapClaims)
				            .setHeader(map)
				            .setExpiration(new Date(System.currentTimeMillis() + (3600 * 1000))) //60 minutes
				            .signWith(signatureAlgorithm, signingKey)
				            .compact();
	    return jwtToken;
	}
}
