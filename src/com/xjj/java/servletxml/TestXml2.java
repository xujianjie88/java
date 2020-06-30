package com.xjj.java.servletxml;
import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator.OfDouble;
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
		WebHandler pHandler = new WebHandler();
		//5.解析
		parser.parse(Thread.currentThread().getContextClassLoader()
	          .getResourceAsStream("com/xjj/java/servletxml/web.xml"),pHandler);
		
		//获取数据
		List<Entity> entities = pHandler.getEntities();
		for(Entity e:entities) {
			System.out.println(e.getName()+":"+e.getClz());
		}
		List<Mapping> mappings = pHandler.getMappings();
		System.out.println(entities.size());
		System.out.println(mappings.size());
	}
}
class WebHandler extends DefaultHandler{
	private List<Entity> entities;
	private List<Mapping> mappings;

	private Entity entity;
	private Mapping mapping;
	private String tag;//存储操作的标签
	private boolean isMapping = false;
	
	@Override
	public void startDocument() throws SAXException {
		entities = new ArrayList<>();
		mappings = new ArrayList<>();
	}
	
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
	   if(null!=qName) {
			   tag = qName;//存储标签
		   if(qName.equals("servlet")) {
			   entity = new Entity();
			   isMapping = false;
		   }else if(qName.equals("servlet-mapping")){
			   mapping = new Mapping();
			   isMapping = true;
		   }
	    }
	  }
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String content = new String(ch, start, length).trim(); 
		if(null!=tag) {//处理空
			if(isMapping) {//操作servlet-mapping
				if(tag.equals("servlet-name")) {
					mapping.setName(content);
				}else if(tag.equals("servlet-class")) {
					mapping.addPattern(content);
				}
			}else {//操作servlet
				if(tag.equals("servlet-name")) {
					entity.setName(content);
				}else if(tag.equals("servlet-class")) {
					entity.setClz(content);
				}
			}
			
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		 System.out.println(qName+"-->解析结束");
		 if(null!=qName) {
			 if(qName.equals("servlet")) {
				   entities.add(entity);
			   }else if(qName.equals("servlet-mapping")) {
				   mappings.add(mapping);
			   }
		 }
		 tag = null;//讲tag置空，防止下次解析赋值为空
	}
	
	@Override
	public void endDocument() throws SAXException {
		
	}


	public List<Entity> getEntities() {
		return entities;
	}

	public List<Mapping> getMappings() {
		return mappings;
	}


	
}
