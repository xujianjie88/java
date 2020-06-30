package com.xjj.java.onlinechat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 接受端：使用面向对象封装
 * @author Administrator
 *
 */
public class TalkServer03 implements Runnable{
	
	private DatagramSocket server; 
	public TalkServer03(int port) {
		try {
			this.server = new DatagramSocket(port);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
	}

	@Override
	public void run() {
		 while(true) {
			 byte[] container = new byte[1024*60];
			 DatagramPacket packet = new DatagramPacket(container,0,container.length);
			 try {
				//3.阻塞式接受包裹recevice(DatagramPacker p)
				 server.receive(packet);
				//4.分析数据
				//byte[] getData()
				//geyLength()
				 byte[] datas = packet.getData();
				 int len = packet.getLength();
				 String data = new String(datas,0,len);
				 System.out.println(data);
				 if(data.equals("bye")) {
					 break;
				 }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		 }
		 //5.释放资源
		 server.close();		
	}

}
