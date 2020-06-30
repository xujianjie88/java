package com.xjj.java.net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * 网络爬虫的原理+模拟浏览器
 * @author Administrator
 *
 */
public class TestSlider {
	
	public static void main(String[] args) throws Exception {
		//获取URL
		URL url = new URL("https://www.jd.com");
		//下载资源
		InputStream iStream = url.openStream();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(iStream, "UTF-8"));
		String msg = null;
		while (null!=(msg=bufferedReader.readLine())) {
		    System.out.println(msg);
		}
		bufferedReader.close();
		//处理
		
		//分析
		
	}

}
