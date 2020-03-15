package com.yyh.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.myapps.examples.dto.ProductDataObj;

public class PracticeStream {

	public static void main(String[] args){
		//testStreamMap();
		//testInitStreamMap();
		//convertListToMap();
		//collectFunc();
		streamFun();
	}
	
	private static void testStreamMap() {
		Map<String, Boolean> maps = new HashMap<>();
		maps.put("T1", true);
		maps.put("T2", true);
		maps.put("T3", false);
		maps.put("T4", true);
		maps.put("T5", false);
		
		Map<String, Boolean> maps2 = Stream.of(new Object[][] {
			{"X1", true},
			{"X2", false},
			{"X3", true},
		}).collect(Collectors.toMap(data -> (String) data[0], data -> (Boolean) data[1]));
		
		Map<String, Boolean> newMaps = maps2.entrySet().stream().filter(y -> y.getValue() == true).collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
		for(Map.Entry<String, Boolean> entry : newMaps.entrySet()) {
			System.out.println(entry.getKey() + "::" + entry.getValue());
		}
	}
	
	private static void testInitStreamMap() {
		//Note that, we should avoid using such initialization using Streams, as it could cause a huge performance overhead and lots of garbage object are created just to initialize the map.
		Map<String, String> map = Stream.of(new String[][] {
			{"T1", "X1"},
			{"T2", "X2"},
		}).collect(Collectors.collectingAndThen(
			    Collectors.toMap(data -> data[0], data -> data[1]), 
			    Collections::<String, String> unmodifiableMap));
		
		//map.put("T3", "X3");
	}
	
	private static void convertListToMap() {
		ProductDataObj pdo = new ProductDataObj();
		pdo.setProductId("P1");
		pdo.setStoreId("Store1");
		List<ProductDataObj> pdos = new ArrayList<ProductDataObj>();
		pdos.add(pdo);
		
		Map<String, ProductDataObj> mp = pdos.stream().collect(Collectors.toMap(ProductDataObj::getStoreId, p -> p));
		System.out.println(mp);
		/*for(Map.Entry<String, ProductDataObj> entry : mp.entrySet()) {
			
		}*/
	}
	
	private static void convertStreamFrmArray() {
		String[] arr = {"aa", "bb", "cc", "dd"};
		Stream<String> stream = Arrays.stream(arr);
		//stream.collect(collector)
		Stream<String> stream2 = Arrays.asList(arr).stream();
		Stream<String> stream3 =  Arrays.asList(arr).subList(0, 2).stream();
		
	}
	
	private static void collectFunc() {
		List<String> strings = Arrays.asList("Jack", "JackChuang", "hollis","Jack666", "Hello", "HelloWorld", "Jack", "Jack", "Jack2");
		//strings  = strings.stream().filter(string -> string.startsWith("Jack")).collect(Collectors.toList());
		Set<String> strings2  = strings.stream().filter(string -> string.startsWith("Jack")).collect(Collectors.toSet());
		//Stream<String> strings2 = Stream.of("Hollis", "HollisChuang", "hollis", "Hello", "HelloWorld", "Hollis");
		strings2.forEach(System.out::println);
		//System.out.println(strings2);
	}
	
	private static void streamFunc() {
		//List<String> strings = Arrays.asList("Hollis", "", "HollisChuang", "H", "hollis");
		//strings.stream().filter(string -> ! string.isEmpty()).forEach(System.out::println);
		

		//List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		//numbers.stream().map(x -> x*2).forEach(System.out::println);
		
		
		//List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		//numbers.stream().limit(5).forEach(System.out::println);
		
		//List<Integer> numbers2 = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		//numbers2.stream().sorted().forEach(System.out::println);
		//System.out.println("-----------");
		//numbers2.stream().distinct().forEach(System.out::println);
		

		List<String> strings = Arrays.asList("Hollis", "HollisChuang", "hollis", "Hello", "HelloWorld", "Hollis");
		//Stream<?> s = strings.stream().filter(string -> string.length()<= 6).map(String::length).sorted().limit(3)
		//            .distinct();
		//strings.stream().filter(string -> string.length()<= 6).map(String::length).sorted().limit(3)
        //.distinct().forEach(System.out::println);
		
		Stream<?> s = strings.stream().filter(string -> string.length()<= 6).map(i -> i.substring(2)).sorted();
		//s.forEach(System.out::println);
		System.out.println(s.count());
		//strings.stream().filter(string -> string.length()<= 6).sorted()
	}
	
	private static void streamFun() {
		Map < String, List < String >> phoneNumbers = new HashMap < String, List < String >> ();
		phoneNumbers.put("John Lawson", Arrays.asList("3232312323", "8933555472"));
		phoneNumbers.put("Mary Jane", Arrays.asList("12323344", "492648333"));
		phoneNumbers.put("Mary Lou", Arrays.asList("77323344", "938448333"));
		
		Map < String, List < String >> filteredNumbers = phoneNumbers.entrySet().stream()
		    .filter(x -> x.getKey().contains("John"))
		    .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
		filteredNumbers.forEach((key, value) -> {
		    System.out.println("Name: " + key + ": ");
		    value.forEach(System.out::println);
		});
	}
	
}
