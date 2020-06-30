package com.xjj.java.net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * 不让请求时的解决方：
 *+模拟浏览器
 * @author Administrator
 *
 */
public class TestSlider2 {
	
	public static void main(String[] args) throws Exception {
		//获取URL
		URL url = new URL("https://www.dianping.com");
		
		HttpsURLConnection  connection = (HttpsURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
		//下载资源
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
		String msg = null;
		while (null!=(msg=bufferedReader.readLine())) {
		    System.out.println(msg);
		}
		bufferedReader.close();
		//处理
		
		//分析
		
	}

}
