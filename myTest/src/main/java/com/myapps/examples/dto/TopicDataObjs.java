package com.myapps.examples.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "topics")
@XmlAccessorType (XmlAccessType.FIELD)
public class TopicDataObjs {
	private List<TopicDataObj> topics;

	public List<TopicDataObj> getTopics() {
		return topics;
	}

	public void setTopics(List<TopicDataObj> topics) {
		this.topics = topics;
	}
	
}
