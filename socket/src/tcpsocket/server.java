package tcpsocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
	public static void main(String[] args) throws Exception {
		//�������20006�˿ڼ����ͻ��������TCP����
		ServerSocket server = new ServerSocket(20006);
		Socket client = null;
		boolean f = true;
		while(f){
			//�ȴ��ͻ��˵�����,���û�л�ȡ����
			client = server.accept();
			System.out.println("��ͻ������ӳɹ���");
			//Ϊÿ���ͻ��˿���һ���߳�
			new Thread(new threadutil(client)).start();
		}
		server.close();
	}
}
