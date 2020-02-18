package com.myapps.examples.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class SendUtil {
	
	public String sendPost(String url, String transferStr, Map<String,String> headers) throws IOException {
		HttpPost post = new HttpPost(url);
		String result = "";
		
		/*for(Map.Entry<String, String> entry : headers.entrySet()) {
		}*/
		
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		headers.forEach((k,v)->{
			nvps.add(new BasicNameValuePair(k, v));
		});
		
        //List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        //nvps.add(new BasicNameValuePair("content-type", "application/json"));
        //nvps.add(new BasicNameValuePair("actionType", "jsonTransfer"));

		nvps.forEach((k)->{
			post.addHeader(k.getName(), k.getValue());
		});
		
        //for (NameValuePair nvp : nvps)
        //{
        //    post.addHeader(nvp.getName(), nvp.getValue());
        //}
		post.setEntity(new StringEntity(transferStr)); 

		
		try (CloseableHttpClient httpClient = HttpClients.createDefault();
	             CloseableHttpResponse response = httpClient.execute(post)) {

			 System.out.println("Status code:" + response.getStatusLine().getStatusCode());
			 System.out.println("Reason phrase: " + response.getStatusLine().getReasonPhrase());
			 result = EntityUtils.toString(response.getEntity());
	    }
		 
		return result;
	}
}
