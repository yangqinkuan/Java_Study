package net.tcp;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *1�� ���������� ָ���˿�  ServerSocket(int port)
 *2�����ܿͻ��˵�����
 * @author Administrator
 *
 */
public class MultiServer {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8888);
		while(true){
			Socket socket = server.accept();
			System.out.println("һ���ͻ��˽�������");
			String msg = "��ӭʹ��";
		
			DataOutputStream dos  = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(msg);
			dos.flush();
		}
		
		
	}
}
