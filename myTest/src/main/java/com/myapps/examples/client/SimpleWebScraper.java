package com.myapps.examples.client;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.myapps.examples.dto.TopicDataObj;
import com.myapps.examples.dto.TopicDataObjs;
import com.myapps.examples.processor.XmlProcessor;

public class SimpleWebScraper {
	public static void main (String[] args) {
		try {
			Document doc = Jsoup.connect("https://asia.nikkei.com/").get(); //("https://www.infoq.com/").get();
			
			System.out.printf("Title: %s\n", doc.title());
			
			/*Elements topics = doc.getElementsByClass("article-teaser__content"); //("card__title"); 
			
			List<String> lstTopic = new ArrayList<String>();
			topics.forEach(e -> {
				//e.getAllElements().stream().distinct().collect(Collectors.toList());
				
				System.out.println(e.getAllElements().text());
				//lstTopic.add(e.getAllElements().text());
			});*/
			
			//Get the links
			Elements links = doc.select("a");
			links.forEach(e -> {
				String linkHref = e.attr("href"); 
				System.out.println(linkHref);
			});
			
			/*
			List<TopicDataObj> topicDatas = new ArrayList<TopicDataObj>();
			List<String> distinctTopics = lstTopic.stream().distinct().collect(Collectors.toList()) ; 
			
			Integer count = 1000;
			for(String topic:distinctTopics) {
				topicDatas.add(new TopicDataObj(count.toString(), topic));
				count++;
			}
			
			TopicDataObjs topicDataObjs = new TopicDataObjs();
			topicDataObjs.setTopics(topicDatas);
			XmlProcessor xmlProcessor = new XmlProcessor();
			try {
				xmlProcessor.marshalToXml(topicDataObjs);
			} catch (JAXBException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
			/*distinctTopics.forEach(e -> {
				System.out.println(e);
				TopicDataObj topic = new TopicDataObj();
				count = count +1;

			});*/
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
