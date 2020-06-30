package com.xjj.java.net;

import java.net.InetSocketAddress;
/**
 * 端口：
 * 1.区分软件的
 * 2、2个字节0-65535 Udo Tcp
 * 3、同一个协议端口不能冲突
 * 4、定义的端口越大越好
 * InetSocketAddress
 * new InetSocketAddress(地址|域名,端口)
 * @author Administrator
 *
 */
public class TestPort {
	
	public static void main(String[] args) {
		//包含端口
		InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1",8080);
		InetSocketAddress inetSocketAddress2 = new InetSocketAddress("localhost",9000);
		System.out.println(inetSocketAddress.getHostName());
		System.out.println(inetSocketAddress2.getAddress());
		System.out.println(inetSocketAddress2.getPort());
	}

}
