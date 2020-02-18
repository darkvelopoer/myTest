package com.myapps.examples.processor;

import java.io.File;
import java.time.LocalDate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.myapps.examples.dto.TopicDataObjs;

public class XmlProcessor {

	public void marshalToXml(TopicDataObjs topics) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(TopicDataObjs.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		jaxbMarshaller.marshal(topics, System.out); //console
		jaxbMarshaller.marshal(topics, new File("D://dir/xml/topics_" + LocalDate.now() + ".xml"));
	}
}
