package com.xjj.java.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 接收端  实现多次交流 注意：同一个协议下端口不能重复
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
public class UdpTalkServer02 {
	
	public static void main(String[] args) throws Exception{
		 System.out.println("接收方启动中。。。。");
//		 1.使用DatagramSocket 指定端口 创建接收端
		 DatagramSocket server = new DatagramSocket(9999);
//		 * 2.准备容器 封装成DatagramPacker包裹
		 while(true) {
			 byte[] container = new byte[1024*60];
			 DatagramPacket packet = new DatagramPacket(container,0,container.length);
	//		 * 3.阻塞式接受包裹recevice(DatagramPacker p)
			 server.receive(packet);
	//		 * 4.分析数据
	//		 *    byte[] getData()
	//		 *           geyLength()
			 byte[] datas = packet.getData();
			 int len = packet.getLength();
			 String data = new String(datas,0,len);
			 System.out.println(data);
			 if(data.equals("bye")) {
				 break;
			 }
		 }
//		 * 5.释放资源
		 server.close();
	}

}
