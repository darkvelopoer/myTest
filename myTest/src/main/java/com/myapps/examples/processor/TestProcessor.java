package com.myapps.examples.processor;

import java.util.ArrayList;
import java.util.List;

import com.myapps.examples.dto.ProductDataObj;
import com.myapps.examples.dto.TopicDataObj;

public class TestProcessor<T> {
	public List<T> acceptList(List<T> multipleTypes, List<T> appendTypes){
		
		System.out.println(multipleTypes.size());
		//List<T> appendTypes = new ArrayList<T>();
		
		for(T val:multipleTypes) {
			if(val instanceof ProductDataObj) {
				ProductDataObj pobj = (ProductDataObj)val;
				System.out.println("storeId: " + pobj.getStoreId());
			}
			else if(val instanceof TopicDataObj) {
				TopicDataObj tobj = (TopicDataObj)val;
				System.out.println("storeId: " + tobj.getTitleId());
			}
			
			appendTypes.add(val);
		}
		
		System.out.println("Appended: " + appendTypes.size());
		
		return null;
	}
	
	public T processAny(T someObj){
		if(someObj instanceof ProductDataObj) {
			System.out.println("ProductDataObj");
		}else if(someObj instanceof TopicDataObj) {
			System.out.println("TopicDataObj");
		}
		return someObj;
	}
	
	
}
