package com.xjj.java.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 发送端
 * 1.使用DatagramSocket 指定端口 创建发送端
 * 2.准备容数据   一定转成字节数组
 * 3.封装成DatagramPacker包裹 需要指定目的地
 * 4.发送包裹send(DatagramPacker p)
 * 5.释放资源
 */
public class UdpClient {


	public static void main(String[] args) throws Exception {
		 System.out.println("发送端启动中。。。");
//		 * 1.使用DatagramSocket 指定端口 创建发送端
		 DatagramSocket client = new DatagramSocket(8888);
//		 * 2.准备容数据   一定转成字节数组
		  String data = "许健杰";
		  byte[] datas = data.getBytes();
//		 * 3.封装成DatagramPacket包裹 需要指定目的地
		  DatagramPacket packet = new DatagramPacket(datas,0,datas.length,
				         new InetSocketAddress("localhost",9999));
//		 * 4.发送包裹send(DatagramPacker p)
		  client.send(packet);
//		 * 5.释放资源
		  client.close();
	}
}
