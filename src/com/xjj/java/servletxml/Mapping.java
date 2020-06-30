package com.xjj.java.servletxml;

import java.util.HashSet;
import java.util.Set;
/**
 *  <servlet-mapping>
   <servlet-name>reg</servlet-name>
   <url-pattern>/register</url-pattern>
   <url-pattern>/r</url-pattern>
  </servlet-mapping>
 * @author Administrator
 *
 */
public class Mapping {
	
	private String name;
	private Set<String> patterns;
	
	public Mapping() {
		patterns = new HashSet<>();
	}
	public Mapping(String name, Set<String> patterns) {
		super();
		this.name = name;
		this.patterns = patterns;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<String> getPatterns() {
		return patterns;
	}
	public void setPatterns(Set<String> patterns) {
		this.patterns = patterns;
	}
	
	public void addPattern(String paString) {
		this.patterns.add(paString);
	}
	
	

}
