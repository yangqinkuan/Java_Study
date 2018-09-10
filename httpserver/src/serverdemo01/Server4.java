package serverdemo01;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * ������������������
 * @author Administrator
 *
 */
public class Server4 {
	private ServerSocket server;
	public static final String CRLF="\r\n";
	public static final String BLANK=" ";
	
	
	public static void main(String[] args) {
		Server4 server = new Server4();
		server.start();
		
		
		
	}
	/** 
	 * ��������
	 */
	public void start(){
		
		try {
			server = new ServerSocket(8888);

			this.receive();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * ���ܿͻ���
	 */
	private void receive(){
		try {
			Socket client = server.accept();
			StringBuilder sb = new StringBuilder();
			String msg = null; //���ܿͻ��˵�������Ϣ
			
			
			byte[] data = new byte[20480];
			int len = client.getInputStream().read(data);
			//���ܿͻ��˵�������Ϣ
			String requestInfo = new String(data,0,len).trim();
			
			System.out.println(requestInfo);
			
			
			//��Ӧ


			Response rep = new Response(client.getOutputStream());
			rep.println("<html><head><title>HTTP��Ӧʾ��</title>");
			rep.println("</head><body>Hello ���߿�!</body></html>");
			rep.pushToClient(500);
			
			
			
			
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * ֹͣ����
	 */
	public void stop(){
		
	}
}
