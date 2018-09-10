package serverdemo01;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 创建服务器，并启动
 * @author Administrator
 *
 */
public class Server6 {
	private ServerSocket server;
	public static final String CRLF="\r\n";
	public static final String BLANK=" ";
	
	
	public static void main(String[] args) {
		Server6 server = new Server6();
		server.start();
		
		
		
	}
	/** 
	 * 启动方法
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
	 * 接受客户端
	 */
	private void receive(){
		try {
			Socket client = server.accept();
			Servlet serv = new Servlet();
			Request req=new Request(client.getInputStream());
			Response rep = new Response(client.getOutputStream());
			serv.service(req,rep);
			//请求
			
			
			
			//响应


			

			rep.pushToClient(500);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 停止方法
	 */
	public void stop(){
		
	}
}
