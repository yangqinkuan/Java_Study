package net.tcp.chat.demo04;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 创建客户端： 发送数据+接收数据
 * 写出数据：输出流
 * 读取数据：输入流
 * @author Administrator
 *
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("请输入名称： ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine();
		if(name.equals("")){
			return;
		}
		
		Socket client = new Socket("localhost",9999);
		//控制台输入流
		new Thread(new Send(client,name)).start();//一条路径
		new Thread(new Receive(client)).start();

	
	}
}
