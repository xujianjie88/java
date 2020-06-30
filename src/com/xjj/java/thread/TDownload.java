package com.xjj.java.thread;

public class TDownload extends Thread{
	
	private String url;//远程路径
	private String name;//存储的名字
	
	public TDownload(String url, String name) {
		super();
		this.url = url;
		this.name = name;
	}


	@Override
	public void run() {
		WebDownload webDownload = new WebDownload();
		webDownload.download(url, name);
		System.out.println(name);
		
	}
	
	public static void main(String[] args) {
		TDownload td1 = new TDownload("https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E4%BC%98%E7%BE%8E%E5%9B%BE%E7%89%87&step_word=&hs=2&pn=3&spn=0&di=218680&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&istype=0&ie=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=undefined&cs=234634259%2C4236876085&os=54892700%2C159557102&simid=3579428015%2C308375459&adpicid=0&lpn=0&ln=1282&fr=&fmq=1559138256910_R&fm=&ic=undefined&s=undefined&hd=undefined&latest=undefined&copyright=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&ist=&jit=&cg=&bdtype=0&oriquery=&objurl=http%3A%2F%2Fpic15.nipic.com%2F20110628%2F1369025_192645024000_2.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3Bgtrtv_z%26e3Bv54AzdH3Ffi5oAzdH3F90088lb_z%26e3Bip4s&gsm=0&rpstart=0&rpnum=0&islist=&querylist=&force=undefined", "1.jpg");
		TDownload td2 = new TDownload("https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E4%BC%98%E7%BE%8E%E5%9B%BE%E7%89%87&hs=2&pn=1&spn=0&di=220440&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&ie=utf-8&oe=utf-8&cl=2&lm=-1&cs=234634259%2C4236876085&os=54892700%2C159557102&simid=3579428015%2C308375459&adpicid=0&lpn=0&ln=30&fr=ala&fm=&sme=&cg=&bdtype=0&oriquery=%E4%BC%98%E7%BE%8E%E5%9B%BE%E7%89%87&objurl=http%3A%2F%2Fpic15.nipic.com%2F20110628%2F1369025_192645024000_2.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3Bgtrtv_z%26e3Bv54AzdH3Ffi5oAzdH3F90088lb_z%26e3Bip4s&gsm=0&islist=&querylist=", "2.jpg");
		TDownload td3 = new TDownload("https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E4%BC%98%E7%BE%8E%E5%9B%BE%E7%89%87&hs=2&pn=1&spn=0&di=220440&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&ie=utf-8&oe=utf-8&cl=2&lm=-1&cs=234634259%2C4236876085&os=54892700%2C159557102&simid=3579428015%2C308375459&adpicid=0&lpn=0&ln=30&fr=ala&fm=&sme=&cg=&bdtype=0&oriquery=%E4%BC%98%E7%BE%8E%E5%9B%BE%E7%89%87&objurl=http%3A%2F%2Fpic15.nipic.com%2F20110628%2F1369025_192645024000_2.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3Bgtrtv_z%26e3Bv54AzdH3Ffi5oAzdH3F90088lb_z%26e3Bip4s&gsm=0&islist=&querylist=", "3.jpg");
		
		//启动三个线程
		td1.start();
		td2.start();
		td3.start();
				
	}

}
