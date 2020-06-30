package com.xjj.java.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
/**
 * 
 * @author Administrator
 *
 */
public class MapTest {
	
	public static void main(String[] args) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("aaa", 111);
		map.put("bbb", 2222);
	    
		//方式一;
		for(String key:map.keySet()) {
			System.out.println("键:"+key+"值:"+map.get(key));
		}
		
//	  //方式二：
//	  System.out.println("通过Map.entrySet使用iterator遍历key和value：");
//	  Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
//	  while (it.hasNext()) {
//	   Map.Entry<String, Object> entry = it.next();
//	   System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
//	  }
	 
		
	  //方式三:推荐，尤其是容量大时
	  System.out.println("通过Map.entrySet遍历key和value");
	  for (Entry<String, Object> entry : map.entrySet()) {
	   System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
	  }
		  
		
		
	}

	
	
}
