package net.tcp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 1、创建客户端   必须指定服务器+端口 此时就在连接
 * 
 * @author Administrator
 *
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client =  new Socket("localhost",8888);
		/*BufferedReader br=new BufferedReader(new InputStreamReader(client.getInputStream())) ;
		String echo = br.readLine();*/
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String echo = dis.readUTF();
		System.out.println(echo);
	}
}
