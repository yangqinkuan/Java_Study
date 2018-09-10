package net.udp;
/**
 * 客户端
 * 1、创建服务端 + 端口
 * 2、准备数据
 * 3、封装成包（发送的点及端口）
 * 4、发送
 * 5、释放
 * @author Administrator
 *
 */  
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;


public class MyClient {
	public static void main(String[] args) throws IOException {
		//1、创建服务端 + 端口
		DatagramSocket client = new DatagramSocket(6666);
		//2、准备数据
		String msg = "udp编程";	
		byte[] data = msg.getBytes();	
		//3、打包（发送的地点及端口）
		DatagramPacket packet = new DatagramPacket(data, data.length,new InetSocketAddress("localhost",8888 ));
		//4、发生
		client.send(packet);
		//5、释放
		client.close();
	}
}
