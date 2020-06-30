package com.xjj.java.xml;
/**
 * 熟悉SAX解析xml的流程
 * @author Administrator
 *
 */

import java.io.IOException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.xjj.java.reflect.Person;

public class TestXml {
	
	public static void main(String[] args) throws Exception {
		//SAX解析
		//1.获取解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//2.从解析工厂获取解析器
		SAXParser parser = factory.newSAXParser();
		//3.加载文档，注册处理器
		
		//4.编写处理器
		PHandler pHandler = new PHandler();
		//5.解析
		parser.parse(Thread.currentThread().getContextClassLoader()
	          .getResourceAsStream("com/xjj/java/xml/web.xml"),pHandler);
		
	}
}
class PHandler extends DefaultHandler{
	
	@Override
	public void startDocument() throws SAXException {
	 System.out.println("解析文档开始");
	}
	
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
	   System.out.println(qName+"-->解析开始");
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String content = new String(ch, start, length).trim(); 
		if(content.length()>0) {
			System.out.println("内容为:"+content);
		}else {
			System.out.println("内容为:"+"空");
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		 System.out.println(qName+"-->解析结束");
	}
	
	@Override
	public void endDocument() throws SAXException {
		System.out.println("解析文档结束");
	}
	
}
