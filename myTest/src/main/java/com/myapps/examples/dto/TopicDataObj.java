package com.myapps.examples.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "topic")
@XmlAccessorType (XmlAccessType.FIELD)
public class TopicDataObj {
	private String titleId;
	private String titleName;
	
	public TopicDataObj() {
	}
	
	public TopicDataObj(String titleId, String titleName){
		this.titleId = titleId;
		this.titleName = titleName;
	}
	
	public String getTitleId() {
		return titleId;
	}
	public void setTitleId(String titleId) {
		this.titleId = titleId;
	}
	public String getTitleName() {
		return titleName;
	}
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	
}
