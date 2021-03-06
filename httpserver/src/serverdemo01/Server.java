package serverdemo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务器，并启动
 * @author Administrator
 *
 */
public class Server {
	private ServerSocket server;
	public static void main(String[] args) {
		Server server = new Server();
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
			StringBuilder sb = new StringBuilder();
			String msg = null; //接受客户端的请求信息
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			
			while((msg=br.readLine()).length()>0){
				sb.append(msg);
				sb.append("\r\n");
				if(null==msg){
					break;
				}
			}
			//接受客户端的请求信息
			String requestInfo = sb.toString().trim(); 
			
			System.out.println(sb.toString());
			
			
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
