package com.xjj.java.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 接收端  注意：同一个协议下端口不能重复
 * 1.使用DatagramSocket 指定端口 创建接收端
 * 2.准备容器 封装成DatagramPacker包裹
 * 3.阻塞式接受包裹recevice(DatagramPacker p)
 * 4.分析数据
 *    byte[] getData()
 *           geyLength()
 * 5.释放资源
 * @author Administrator
 *
 */
public class UdpServer {
	
	public static void main(String[] args) throws Exception{
		 System.out.println("接收方启动中。。。。");
//		 1.使用DatagramSocket 指定端口 创建接收端，端口需是发送端的 new InetSocketAddress("localhost",9999)
		 DatagramSocket server = new DatagramSocket(9999);
//		 * 2.准备容器 封装成DatagramPacker包裹
		 byte[] container = new byte[1024*60];
		 DatagramPacket packet = new DatagramPacket(container,0,container.length);
//		 * 3.阻塞式接受包裹receve(DatagramPacker p)
		 server.receive(packet);
//		 * 4.分析数据
//		 *    byte[] getData()
//		 *           geyLength()
		 byte[] datas = packet.getData();
		 int len = packet.getLength();
		 System.out.println(new String(datas,0,len));
//		 * 5.释放资源
		 server.close();
	}

}
