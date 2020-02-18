package com.myapps.examples.processor;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.myapps.examples.dto.ProductDataObj;

public class ReadProcessor {
	
	public List<String> readTextConvertToJson(String filePath) {
		List<String> fileInJsonLst = new ArrayList<String>();
		try (Stream<Path> walk = Files.walk(Paths.get(filePath)))  {
			List<String> result = walk.filter(Files::isRegularFile)
					.map(x -> x.toString()).collect(Collectors.toList());

			result.forEach(x -> {
				try {
					List<String> contents = Files.lines(Paths.get(x)).collect(Collectors.toList());
					
					//contents.forEach(System.out::println);
					contents.forEach(y -> {
						fileInJsonLst.add(toJsonString(y.split("\\|")));
						}
					);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			
			/*for(String fileName:result) {
				System.out.println("fileName: " + fileName);
				Stream<String> lines = Files.lines(Paths.get(fileName));
				List<String> cont = lines.collect(Collectors.toList());
				cont.forEach(System.out::println);
			}*/
			//result.forEach(Files.lines(Paths.get()).;
			
			fileInJsonLst.forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//BufferedReader br = new BufferedReader(new FileReader(file)); 
		return fileInJsonLst;
	}
	
	private String toJsonString(String[] arrStr) {		
		int cnt = 0;
		ProductDataObj pdObj = new ProductDataObj();
		for(String str:arrStr) {
			if(cnt == 0) {
				pdObj.setProductId(str);
			} else if(cnt == 1) {
				pdObj.setStoreId(str);
			} else if(cnt == 2) {
				pdObj.setCurrencyType(str);
			} else if(cnt == 3) {
				pdObj.setAmount(Integer.parseInt(str));
			} else if(cnt == 4) {
				pdObj.setQuantity(Integer.parseInt(str));
			} else {
				break;
			}
			
			cnt++;
		}
		return new Gson().toJson(pdObj);
	}
	
	/*public static void main(String[] args) {
		readTextConvertToJson("D:\\dir\\out");
	}*/
}
