package net.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetDemo01 {

	public static void main(String[] args) throws UnknownHostException {
		//ʹ��getLocalHost��������InetAddress����
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println(addr.getHostAddress());
		System.out.println(addr.getHostName());
		//���������õ�InetAddress����
		addr = InetAddress.getByName("www.163.com");
		System.out.println(addr.getHostAddress());
		System.out.println(addr.getHostName());
		//����ip�õ�InetAddress����
		addr = InetAddress.getByName("61.135.253.15");
		System.out.println(addr.getHostAddress());
		System.out.println(addr.getHostName());
		
		
		
	}

}
