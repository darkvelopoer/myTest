package com.myapps.examples.client;

import java.util.ArrayList;
import java.util.List;

import com.myapps.examples.dto.ProductDataObj;
import com.myapps.examples.dto.TopicDataObj;
import com.myapps.examples.processor.MaxComparable;
import com.myapps.examples.processor.TestProcessor;

public class SimpleTest {
	public static void main (String[] args) {
		compareSomething();
		
	}
	
	private static void doSome() {
		TestProcessor tp = new TestProcessor();
		
		List<ProductDataObj> pList = new ArrayList<ProductDataObj>();
		ProductDataObj p = new ProductDataObj();
		p.setStoreId("Store1");
		p.setProductId("Prod1");
		pList.add(p);
		p = new ProductDataObj();
		p.setStoreId("Store2");
		p.setProductId("Prod2");
		pList.add(p);
		
		List<TopicDataObj> tList = new ArrayList<TopicDataObj>();
		TopicDataObj t = new TopicDataObj();
		t.setTitleId("Title1");
		t.setTitleName("Tname1");
		tList.add(t);
		t = new TopicDataObj();
		t.setTitleId("Title2");
		t.setTitleName("Tname2");
		tList.add(t);
		
		tp.acceptList(pList, tList);
		
	}
	
	private static void compareSomething() {
		Integer t = MaxComparable.maximum(5, 3, 9);
		System.out.println(t);
		Double e = MaxComparable.maximum(9.5, 5.98, 6.6);
		System.out.println(e);
	}
	
	
}
