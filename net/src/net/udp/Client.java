package net.udp;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
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


public class Client {
	public static void main(String[] args) throws IOException {
		//1、创建服务端 + 端口
		DatagramSocket client = new DatagramSocket(6666);
		//2、准备数据
		Double num = 89.12;	
		byte[] data = convert(num);	
		//3、打包（发送的地点及端口）
		DatagramPacket packet = new DatagramPacket(data, data.length,new InetSocketAddress("localhost",8888 ));
		//4、发生
		client.send(packet);
		//5、释放
		client.close();
	}
	/**
	 * 字节数组 数据源 + Data 输出流
	 * @throws IOException 
	 */
	public static byte[] convert(double num) throws IOException{
		byte[] data = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(bos);
		dos.writeDouble(num);
		dos.flush();
		
		data = bos.toByteArray(); 
		dos.close();
		return data;
	}
}
