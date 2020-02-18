package com.myapps.examples.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.myapps.examples.processor.ReadProcessor;
import com.myapps.examples.util.SendUtil;

public class SimpleHttpClient {
	private static final String postUrl = "http://localhost:8118";
	public static void main(String[] args) {

		sendListOfJson();

	}
	
	private static void sendListOfJson() {
		ReadProcessor rp = new ReadProcessor();
		SendUtil sendUtil = new SendUtil();
		List<String> lst = rp.readTextConvertToJson("D:\\dir\\out"); //Read text at dir
		
		Map<String,String> headers = new HashMap<String,String>();
		headers.put("content-type", "application/json");
		headers.put("actionType", "jsonTransfer");
		
		lst.forEach(r -> {
			try {
				String res = sendUtil.sendPost(postUrl, r, headers);
				System.out.println("Result: " + res);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
	}
		
}
