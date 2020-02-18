package com.myapps.examples.processor;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.myapps.examples.dto.ProductDataObj;

public class WriteProcessor {

	private final String filePath = "D:\\dir\\in\\";
			
	public void processData(String jsonData, String actionType) throws IOException {
		/*JsonObject jsonObject = new JsonParser().parse(jsonData).getAsJsonObject();
        String prodId = jsonObject.get("productId").getAsString();
        System.out.println("prodId: " + prodId);*/
        if(actionType.equals("jsonTransfer") && isJsonValid(jsonData)) {
	        ProductDataObj productData = new Gson().fromJson(jsonData, ProductDataObj.class);
	        System.out.println("prod:" + productData.getProductId());
	        System.out.println("amt:" + productData.getAmount());
	        System.out.println("sid:" + productData.getStoreId());

	        //call dao
	       
	        
	        //call writer
	        writeFile(productData);
        }
	}
	
	public boolean isJsonValid(String jsonInString) {
		try {
			new Gson().fromJson(jsonInString, Object.class);
			return true;
		} catch (JsonSyntaxException ex) {
			return false;
		}
	}
	
	private void writeFile(ProductDataObj productData) throws IOException {
		Path path = Paths.get(filePath + productData.getProductId() + ".txt");
		try(BufferedWriter bw = Files.newBufferedWriter(path)) {
			bw.write(productData.getProductId() + "|" + productData.getStoreId() + "|" + productData.getCurrencyType() + "|" + 
				productData.getAmount() + "|" + productData.getQuantity());
		}
		
		/*try(BufferedReader br = Files.newBufferedReader(path)) {
			StringBuffer sbuf = new StringBuffer();
			String readLine = br.readLine();
			sbuf.append(br.readLine());
			
			while(readLine!=null) {
				sbuf.append(br.readLine());
			}
			
			System.out.println("WriteResult:" + sbuf.toString());
		}*/
		/*FileWriter fw = new FileWriter(filePath + productData.getProductId() + ".txt");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(productData.getProductId() + "|" + productData.getStoreId() + "|" + productData.getCurrencyType() + "|" + 
				productData.getAmount() + "|" + productData.getQuantity());
		
		bw.close();*/
	}
}
