package com.xjj.java.xml;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

/**
 * 熟悉SAX解析xml的流程,并且封装数据
 * @author Administrator
 *
 */
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class TestXml2 {
	
	public static void main(String[] args) throws Exception {
		//SAX解析
		//1.获取解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//2.从解析工厂获取解析器
		SAXParser parser = factory.newSAXParser();
		//3.加载文档，注册处理器
		
		//4.编写处理器
		PersonHandler pHandler = new PersonHandler();
		//5.解析
		parser.parse(Thread.currentThread().getContextClassLoader()
	          .getResourceAsStream("com/xjj/java/xml/web.xml"),pHandler);
		
		//获取数据
		List<Person> person = pHandler.getPersons();
		for(Person p:person) {
			System.out.println(p.getName()+":"+p.getAge());
		}
	}
}
class PersonHandler extends DefaultHandler{
	private List<Person> persons;

	private Person person;
	private String tag;//存储操作的标签
	@Override
	public void startDocument() throws SAXException {
		persons = new ArrayList<>();
	}
	
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
	   if(null!=qName) {
		   tag = qName;//存储标签
	   }
	   if(qName.equals("person")) {
		   person = new Person();
	   }
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String content = new String(ch, start, length).trim(); 
		if(null!=tag) {
			if(tag.equals("name")) {
				person.setName(content);
			}else if(tag.equals("age")) {
				if(content.length()>0) {
					person.setAge(Integer.valueOf(content));
				}
			}
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		 System.out.println(qName+"-->解析结束");
		 if(null!=qName) {
			 if(qName.equals("person")) {
				   persons.add(person);
			   }
		 }
		 tag = null;//讲tag置空，防止下次解析赋值为空
	}
	
	@Override
	public void endDocument() throws SAXException {
		
	}
	
	public List<Person> getPersons() {
		return persons;
	}
	
}
