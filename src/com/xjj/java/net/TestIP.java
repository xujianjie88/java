package com.xjj.java.net;

import java.net.InetAddress;
import java.net.UnknownHostException;
/**
 * IP定位一个节点计算机、路由、通讯设备等
 * InetAddress:
 * 1、getLocalHost：本机
 * 2、getByname根据域名DNS|IP地址--》解析IP
 * 
 * 两个成员方法：
 * 1、getHostAddress返回地址
 * 2、getHostName返回计算机名
 * 
 * 
 * @author Administrator
 *
 */
public class TestIP {
	
	public static void main(String[] args) throws UnknownHostException {
		//使用getLocalHost方法创建InetAddress对象
		InetAddress address = InetAddress.getLocalHost();
		System.out.println(address.getHostAddress());//返回IP地址,192.168.3.20
		System.out.println(address.getHostName());//输出主机名字TAPB7VWUC3X0AKJ
		
		//根据域名得到InetAddress对象
		address = InetAddress.getByName("www.163.com");
		System.out.println(address.getHostAddress());//返回服务器的ip:120.198.197.253
		System.out.println(address.getHostName());//输出www.163.com
	}

}
