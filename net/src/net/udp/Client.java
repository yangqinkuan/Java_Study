package net.udp;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
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


public class Client {
	public static void main(String[] args) throws IOException {
		//1����������� + �˿�
		DatagramSocket client = new DatagramSocket(6666);
		//2��׼������
		Double num = 89.12;	
		byte[] data = convert(num);	
		//3����������͵ĵص㼰�˿ڣ�
		DatagramPacket packet = new DatagramPacket(data, data.length,new InetSocketAddress("localhost",8888 ));
		//4������
		client.send(packet);
		//5���ͷ�
		client.close();
	}
	/**
	 * �ֽ����� ����Դ + Data �����
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
