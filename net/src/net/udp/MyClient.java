package net.udp;
/**
 * �ͻ���
 * 1����������� + �˿�
 * 2��׼������
 * 3����װ�ɰ������͵ĵ㼰�˿ڣ�
 * 4������
 * 5���ͷ�
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
		//1����������� + �˿�
		DatagramSocket client = new DatagramSocket(6666);
		//2��׼������
		String msg = "udp���";	
		byte[] data = msg.getBytes();	
		//3����������͵ĵص㼰�˿ڣ�
		DatagramPacket packet = new DatagramPacket(data, data.length,new InetSocketAddress("localhost",8888 ));
		//4������
		client.send(packet);
		//5���ͷ�
		client.close();
	}
}
