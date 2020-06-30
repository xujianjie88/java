package com.xjj.java.servletxml;
/**
 * <servlet>
   <servlet-name>reg</servlet-name>
   <servlet-class>com.xjj.java.servletxml.RegisterServlet</servlet-class>
  </servlet>
 * @author Administrator
 *
 */
public class Entity {
	
	private String name;
	private String clz;
	
	public Entity() {
		super();
	}


	public Entity(String name, String clz) {
		super();
		this.name = name;
		this.clz = clz;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClz() {
		return clz;
	}
	public void setClz(String clz) {
		this.clz = clz;
	}
	
	

}
